package com.googlecode.gumm.utils;

import java.util.LinkedList;
import java.util.List;

import uk.ac.shef.wit.simmetrics.similaritymetrics.JaroWinkler;

public class StoilosMetric {

	public static void main(String[] args) {
		String s1 = "boulbe";String s2 = "aarz";
		//String s1 = "nique";String s2 = "piquenique";
		//String s1 = "numPages";String s2 = "numberOfPages";
		//sim(s1,s2,0.6D);
		System.out.println(sim(s1,s2));
	}
	
	public static double sim(String s1,String s2) {
		return sim(s1,s2,0.6D);
	}

	public static double sim(String s1,String s2,double p) {
		List<String> allMaxSubStrings = allMaxSubstrings(s1, s2);

		int sum = 0;
		for( String s : allMaxSubStrings )
			sum += s.length();
		
		double comm = (2D * (double) sum)/(double) (s1.length() + s2.length());
		double us1 = (double) (s1.length() - sum) / (double) (s1.length());
		double us2 = (double) (s2.length() - sum) / (double) (s2.length());
		
		double diff = (double) ( us1 * us2 ) / (double) (p + (1D - p)*(us1+us2-us1*us2) );
		
		JaroWinkler jwd = new JaroWinkler();
		double jw = (double) jwd.getUnNormalisedSimilarity(s1,s2);
		
		double raw = comm - diff;
		
		return (raw + 1D) / 2D;
	}
	
	public static List<String> allMaxSubstrings(String s1,String s2) {
		List<String> substrings = new LinkedList<String>();
		int[] bounds = longestCommonSubstringBounds(s1, s2);
		while( bounds[4] > 0 ) {
			substrings.add(longestCommonSubstring(s1, s2));
			s1 = s1.substring(0,bounds[0]) + s1.substring(bounds[1],s1.length());
			s2 = s2.substring(0,bounds[2]) + s2.substring(bounds[3],s2.length());
			bounds = longestCommonSubstringBounds(s1, s2);
		}
		return substrings;
	}
	
	public static String longestCommonSubstring(String s1,String s2) {
		int[] bounds = longestCommonSubstringBounds(s1, s2);
		if ( bounds[4] < 1 )
			return "";
		else
			return s1.substring(bounds[0],bounds[1]);
	}

	public static int[] longestCommonSubstringBounds(String s1,String s2) {
		int len = 0;
		int[][] mat = new int[s1.length()+1][s2.length()+1];
		int[] bounds = new int[] { 0 , 0 , 0 }; 
		
		for( int i = 0 ; i <= s1.length() ; i++ )
			mat[i][0] = 0;
		for( int j = 0 ; j <= s2.length() ; j++ )
			mat[0][j] = 0;
		
		for( int i = 1 ; i <= s1.length() ; i++ ) {
			for( int j = 1 ; j <= s2.length() ; j++ ) {
				if ( s1.charAt(i-1) != s2.charAt(j-1) )
					mat[i][j] = 0;
				else {
					mat[i][j] = 1 + mat[i-1][j-1];
					if ( mat[i][j] > len ) {
						len = mat[i][j];
						bounds[0] = i;
						bounds[1] = j;
						bounds[2] = len;
					}
				}
			}
		}
		int[] answer = new int[5];
		answer[0] = bounds[0] - bounds[2];
		answer[1] = bounds[0];
		answer[2] = bounds[1] - bounds[2];
		answer[3] = bounds[1];
		answer[4] = bounds[2];
		return answer;
	}
	
	private static void debugMatrix(int[][] mat,String s1, String s2) {
		int m = mat.length;
		int n = mat[0].length;
		System.out.print("  ");
		System.out.print("\n");
		for( int i = 0 ; i < s1.length() ; i++ ) {
			for( int j = 0 ; j < s2.length() ; j++ ) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
