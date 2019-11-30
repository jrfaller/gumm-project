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

public class LongestCommonSubsequence {

	public static double getSimilarity(String s1, String s2) {
		String lcs = getLCS(s1, s2);
		return (double) lcs.length() / (double) Math.max(s1.length(), s2.length());
	}
	
	public static String getLCS(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		
        int[][] mat = new int[l1+1][l2+1];

        // compute length of LCS and all subproblems via dynamic programming.
        for (int i = l1-1; i >= 0; i--) {
            for (int j = l2-1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    mat[i][j] = mat[i+1][j+1] + 1;
                else 
                    mat[i][j] = Math.max(mat[i+1][j], mat[i][j+1]);
            }
        }

        StringBuffer buffer = new StringBuffer();
        
        int i = 0, j = 0;
        while(i < l1 && j < l2) {
            if ( s1.charAt(i) == s2.charAt(j) ) {
            	buffer.append(s1.charAt(i));
                i++;
                j++;
            }
            else if (mat[i+1][j] >= mat[i][j+1]) 
            	i++;
            else
            	j++;
        }
        
        return buffer.toString();
	}
	
}
