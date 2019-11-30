/*
 * Copyright (C) 2009 Jean-Rémy Falleri <jr.falleri@laposte.net>
 */

/*
 * This file is part of Gumm.

 * Gumm is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Gumm is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public License
 * along with Gumm. If not, see <http://www.gnu.org/licenses/>.
 */

package com.googlecode.gumm.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Munkres algorithm for minimum weight assignment in weighted bipartite graphs.
 * This implementation follows the steps described in http://www.netlib.org/utk/lsi/pcwLSI/text/node222.html.
 * @author Jean-Rémy Falleri
 */
public class MunkresAlgorithm {

	// First indice: rows
	// Second indice: columns
	private float[][] costMatrix;
	
	private float[][] initialCostMatrix;
	
	private int[] coveredCols;
	
	private int[] coveredRows;

	private int[] starredZerosInCols;
	
	private int[] starredZerosInRows;
	
	private int[] primedZerosInRows;
	
	private boolean rotated;
	
	private int colNb;
	
	private int rowNb;
	
	private int[][] assignments;

	public MunkresAlgorithm(float[][] costMatrix) {
		this.initialCostMatrix = costMatrix;
		this.costMatrix = dumpMatrix(costMatrix);

		this.rowNb = costMatrix.length;
		this.colNb = costMatrix[0].length;
		
		// Rotates the cost matrix if there are less columns than rows.
		if ( colNb < rowNb )
			rotateCostMatrix();
		// Transform the cost matrix to an inverted costMatrix ( c[i][j] = 1 - c[i][j]).
		invertCostMatrix();
		// Init the arrays.
		init();
		// Lauch step 0 of the munkres algorithm.
		step0();
	}
	
	/**
	 * Returns the computed assignment.
	 * @return an array of int array. A[i][0]: source ID for the Ith assigment. A[i][1]: target ID for the Ith assignment.
	 */
	public int[][] getAssigments() {
		return this.assignments;
	}
	
	public float getAssigmentsWeight() {
		float r = 0.0F;
		
		for( int[] assignment: this.assignments )
			r += initialCostMatrix[assignment[0]][assignment[1]];
		
		return r;
	}
	
	/**
	 * Find the smallest value of a row and substract it
	 * from each value of the row.
	 */
	private void step0() {
		for(int i = 0 ; i < rowNb ; i++ ) {
			float min = Float.MAX_VALUE;
			for(int j = 0 ; j < colNb ; j++ ) 
				if ( costMatrix[i][j] < min )
					min = costMatrix[i][j];
			for(int j = 0 ; j < colNb ; j++ ) 
				costMatrix[i][j] -= min;
		}

		step1();
	}
	
	/**
	 * Sets starred zeros.
	 */
	private void step1() {
		for(int i = 0 ; i < rowNb ; i++ )
			for( int j = 0 ; j < colNb ; j++ ) 
				if ( costMatrix[i][j] == 0F  && isStarrable(i,j) ) {
					starredZerosInCols[j] = i;
					starredZerosInRows[i] = j;
				}
		
		step2();
	}

	/**
	 * Checks if the assignment is completed or not.
	 */
	private void step2() {
		for(int j = 0 ; j < colNb ; j++ )
			if ( starredZerosInCols[j] != -1 )
				coveredCols[j] = 1;
		
		if ( getCoveredColsNb() == rowNb ) {
			finish();
			return;
		}
		
		step3();
	}
	
	private void step3() {
		int row = -1;

		for(int i = 0 ; i < rowNb ; i++ )
			for( int j = 0 ; j < colNb ; j++ ) 
				if ( costMatrix[i][j] == 0F  && coveredRows[i] == 0 && coveredCols[j] == 0 ) {
					primedZerosInRows[i] = j;
					row = i;
				}
		
		if ( row == -1 )
			step5();
		else {
			int starCol = starredZerosInRows[row];
			if ( starCol == -1 )
				step4(row);
			else {
				coveredRows[row] = 1;
				coveredCols[starCol] = 0;
				step3();
			}
		}
		
	}
	
	private void step4(int row) {
		List<Integer[]> sequence = new ArrayList<Integer[]>(rowNb);
		sequence.add( new Integer[] { row , primedZerosInRows[row] } );
		
		boolean done = false;
		while( ! done ) {
			int i = sequence.size();
			if ( i % 2 == 0 ) {
				Integer[] sZero = sequence.get(i - 1);
				int pZeroRow = sZero[0];
				int pZeroCol = primedZerosInRows[pZeroRow];
				sequence.add( new Integer[]{ pZeroRow, pZeroCol } );
			}
			else {
				Integer[] pZero = sequence.get(i - 1);
				int sZeroCol = pZero[1];
				int sZeroRow = starredZerosInCols[sZeroCol];
				
				if ( sZeroRow == -1 )
					done = true;
				else
					sequence.add( new Integer[] { sZeroRow,sZeroCol } );
			}
			
		}
		
		for( int i = 0; i < sequence.size() ; i++ ) {
			if ( i % 2 != 0 ) {
				Integer[] sZero = sequence.get(i);
				starredZerosInRows[sZero[0]] = -1;
				starredZerosInCols[sZero[1]] = -1;
			}
		}
		
		for( int i = 0; i < sequence.size() ; i++ ) {
			if ( i % 2 == 0 ) {
				Integer[] pZero = sequence.get(i);
				
				int pZeroRow = pZero[0];
				int pZeroCol = pZero[1];
				
				starredZerosInRows[pZeroRow] = pZeroCol;
				starredZerosInCols[pZeroCol] = pZeroRow;
			}
		}
		
		for( int i = 0 ; i < rowNb ; i++ ) {
			primedZerosInRows[i] = -1;
			coveredRows[i] = 0;
		}
		
		for( int j = 0 ; j < colNb ; j++ )
			coveredCols[j] = 0;
		
		step2();
	}
	
	private void step5() {
		float minValue = Float.MAX_VALUE;
		
		for(int i = 0 ; i < rowNb ; i++ )
			for(int j = 0; j < colNb ; j++ )
				if ( costMatrix[i][j] < minValue && coveredRows[i] == 0 && coveredCols[j] == 0 )
					minValue = costMatrix[i][j];

		
		for(int i = 0 ; i < rowNb ; i++ )
			if ( coveredRows[i] == 1 ) 
				for(int j = 0; j < colNb ; j++)
					costMatrix[i][j] += minValue;
		
		for(int j = 0 ; j < colNb ; j++ )
			if ( coveredCols[j] == 0 )
				for(int i = 0 ; i < rowNb ; i++ )
					costMatrix[i][j] -= minValue;
		
		step3();
	}
	
	private void finish() {
		this.assignments = new int[rowNb][2];
		
		int n = 0;
		
		for(int j = 0 ; j < colNb ; j++ ) {
			if ( coveredCols[j] == 1 ) {
				int sZeroCol = j;
				int sZeroRow = starredZerosInCols[j];
				if ( rotated ) {
					assignments[n][0] = sZeroCol;
					assignments[n][1] = sZeroRow;
				}
				else {
					assignments[n][1] = sZeroCol;
					assignments[n][0] = sZeroRow;
				}
				n++;
			}
		}
	}
	
	private void init() {
		this.coveredRows = new int[rowNb];
		this.starredZerosInRows = new int[rowNb];
		this.primedZerosInRows = new int[rowNb];
		
		this.coveredCols = new int[colNb];
		this.starredZerosInCols = new int[colNb];
		
		
		for( int i = 0 ; i < rowNb ; i++ ) {
			this.coveredRows[i] = 0;
			this.starredZerosInRows[i] = -1;
			this.primedZerosInRows[i] = -1;
		}
		for(int j = 0 ; j < colNb ; j++ ) {
			this.coveredCols[j] = 0;
			this.starredZerosInCols[j] = -1;
		}
	}
	
	private int getCoveredColsNb() {
		int cov = 0;
		for(int j = 0 ; j < colNb ; j++ )
			if ( coveredCols[j] == 1 )
				cov++;
		
		return cov;
	}
	
	private boolean isStarrable(int row,int col) {
		if ( starredZerosInRows[row] != -1 )
			return false;
		else if ( starredZerosInCols[col] != -1 )
			return false;
		else
			return true;
	}
	
	private void invertCostMatrix() {
		for(int i = 0 ; i < rowNb ; i++ )
			for(int j = 0 ; j < colNb ; j++ )
				costMatrix[i][j] = 1F - costMatrix[i][j];
	}

	private void rotateCostMatrix() {
		float[][] newMatrix = new float[costMatrix[0].length][costMatrix.length];
		for(int i = 0 ; i < costMatrix.length ; i++ )
			for(int j = 0 ; j < costMatrix[0].length ; j++ )
				newMatrix[j][i] = costMatrix[i][j];

		costMatrix = newMatrix;
		
		int tmp = this.rowNb;
		this.rowNb = colNb;
		this.colNb = tmp;
		this.rotated = true;
	}
	
	private float[][] dumpMatrix(float[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		float[][] newMatrix = new float[r][c];
		
		for(int i = 0;i < r ; i++ )
			for(int j = 0 ; j < c ; j++)
				newMatrix[i][j] = matrix[i][j];
		
		return newMatrix;
	}
	
	public void debugAssignments() {
		for(int i = 0 ; i < assignments.length ; i++ )
			System.out.println("Assignment " + i + "\t(" + assignments[i][0] + "," + assignments[i][1] +")" );
	}
	
	public void debugCostMatrix() {
		System.out.println("---");
		for(int i = 0 ; i < costMatrix.length ; i++ ) {
			for(int j = 0 ; j < costMatrix[0].length ; j++ ) {
				float sValue = Math.round(costMatrix[i][j] * 100F);
				sValue = sValue / 100;
				String value = Float.toString(sValue);
				if ( starredZerosInRows[i] == j )
					value += "*";
				if ( primedZerosInRows[i] == j )
					value += "'";
				System.out.print(value);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.println("---");
	}
	
	public void debugInitialCostMatrix() {
		System.out.println("---");
		for(int i = 0 ; i < initialCostMatrix.length ; i++ ) {
			for(int j = 0 ; j < initialCostMatrix[0].length ; j++ ) {
				float sValue = Math.round(initialCostMatrix[i][j] * 100F);
				sValue = sValue / 100;
				String value = Float.toString(sValue);
				System.out.print(value);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.println("---");
	}
	
}
