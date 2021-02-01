package algorithms.array.medium;

import org.testng.Assert;
import org.testng.annotations.Test;

/****
 * https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
 * Given a matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.

	If there is no common element, return -1.
	
	 
	
	Example 1:
	
	Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
	Output: 5
	 
	
	Constraints:
	
	1 <= mat.length, mat[i].length <= 500
	1 <= mat[i][j] <= 10^4
	mat[i] is sorted in strictly increasing order.
 */

public class Array04_smallestCommonElementInAllRows {

	 @Test
	 private void test() {
		 int[][] mat = {{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
		 Assert.assertEquals(5, smallestCommonElement(mat));
	 }
	
	 public int smallestCommonElement(int[][] mat) {
	        int[] count = new int[10001];
	        int n= mat.length, m = mat[0].length;
	        
	        for(int j=0; j < m; j++){
	            for(int i =0; i< n; i++){
	                if(++count[mat[i][j]] == n){
	                    return mat[i][j];
	                }
	            }
	        }
	        return -1;
	    }
}
