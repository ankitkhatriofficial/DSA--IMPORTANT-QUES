/**
  * Problem statement: Your friend has a sorted Array and he wants you to find the mininum element in that array. But your friend is very clever 
  * and he rotates the sorted array by 'N' times. You have to find the minimum element in the rotated sorted array.
  *
  * Topic: Binary Search
  * Time Complexity: O(logn)
  * Space Complexity: O(1)
*/

import java.util.*;

class Solution{
    
    public static void main(String[] args){
        // Before rotated
        // int[] A = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        // After rotation
        int[] A = {60, 70, 80, 90, 10, 20, 30, 40, 50};
        
        System.out.println(findMinElement(A));
    }
    
    private static int findMinElement(int[] A){
        int low = 0, high = A.length - 1;
        
        while(low < high){
            int mid = low + (high - low) / 2;
            if(Math.abs(high - low) == 1)
                return Math.min(A[high], A[low]);
            
            if(A[mid] < A[high]) high = mid;
            else low = mid;
        }
        return A[low]; // the minimum element in the array
    }
}
        
