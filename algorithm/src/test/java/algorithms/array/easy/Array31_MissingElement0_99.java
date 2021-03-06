package algorithms.array.easy;

import org.testng.annotations.Test;

//http://www.geeksforgeeks.org/print-missing-elements-that-lie-in-range-0-99/
/****************
 * 
 *     Input: {88, 105, 3, 2, 200, 0, 10}
     Output: 1
             4-9
             11-87
             89-99


     Input: {9, 6, 900, 850, 5, 90, 100, 99}
     Output: 0-4
             7-8
             10-89
             91-98
 *
 */
public class Array31_MissingElement0_99 {


	@Test
	//Time complexity is O(n)
	public void Approach01(){

		int[] input = {22,0,1,2,3,10,30,50,40,60,80,70,99,-10,120};

		boolean[] flag = new boolean[100];

		for(int i=0; i< input.length; i++){
			if(input[i] >= 0 && input[i] < 100)
			{
				flag[input[i]] = true;
			}
		}
		for(int i=0; i< 100 ; i++){
			System.out.println(flag[i]);
		}

		int i =0 ;
		while(i < 100){


			if(!flag[i]){

				int j = i+1;

				while(j < 100 && !flag[j]){
					j++;
				}

				if(j == i+1) 
					System.out.println("Missing : " + i);
				else 
					System.out.println(String.format("Missing: %1$d - %2$d ",i,j-1));

				i= j;
			}
			else
				i++;			
		}
	}
}
