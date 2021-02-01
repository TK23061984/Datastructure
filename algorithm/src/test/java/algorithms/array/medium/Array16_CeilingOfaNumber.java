package algorithms.array.medium;
import org.testng.annotations.Test;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/NEG5xqrm576
 * Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’. The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.

Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.

Example 1:

Input: [4, 6, 10], key = 6
Output: 1
Explanation: The smallest number greater than or equal to '6' is '6' having index '1'.
Example 2:

Input: [1, 3, 8, 10, 15], key = 12
Output: 4
Explanation: The smallest number greater than or equal to '12' is '15' having index '4'.
Example 3:

Input: [4, 6, 10], key = 17
Output: -1
Explanation: There is no number greater than or equal to '17' in the given array.
Example 4:

Input: [4, 6, 10], key = -1
Output: 0
Explanation: The smallest number greater than or equal to '-1' is '4' having index '0'.
 */
public class Array16_CeilingOfaNumber {

	 public int searchCeilingOfANumber(int[] arr, int key) {
	     if(arr.length == 0) return -1;
	     if(arr[0] > key) {
	    	 return 0;
	     }
	     if(arr[arr.length-1] < key)
	    	 return -1;

	    int start = 0, end = arr.length-1;
	    while(start <= end){
	      int mid = start + (end - start)/2;
	      if(arr[mid] > key){
	        end = mid -1;
	      }else if(arr[mid] < key){
	        start = mid + 1;
	      }else{
	        return mid;
	      }
	    }

	    return start;
	  }

	  @Test
	  public void main() {
	    System.out.println(this.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
	    System.out.println(this.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15, 15 }, 12));
	    System.out.println(this.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
	    System.out.println(this.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
	  }
	
}
