/** 
  * Problem Statement: You are given a nearly sorted Array. You need to print the index of the target element located in the array. If the target element is not in the
  * array, print -1. You can print any index of the target if target is repeated in the array.
  * Nearly Sorted Array => The originial Sorted Array is get modified. ith element of original array could be at ith location, (i+1) location, or (i-1) location.
  * For example: original Array A = [10, 20, 30, 40, 50] 
  * After modifying the Array A
  * [10, 30, 20, 50, 40] => Here 10 is at the same place where it was in the original array. 20 is placed at (i+1) location in the new array, 30 is placed (i-1) location
  * in the new array. And similarly for 40 & 50 also.
  
  * Topic: Binary Search
  * Time Complexity: O(logn)
  * Space Complexity: O(1)
*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        // Original Sorted Array
        // int[] A = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        
        // Nearly sorted Array  => A[i] can be at {A[i], A[i-1], A[i+1]}
        int[] A = {10, 30, 20, 50, 40, 60, 70, 90, 80, 110, 100};
        
        int target = 70;
        System.out.println(search(A, target));
    }
    
    // Modified version of Binary Search
    private static int search(int[] A, int target){
        int N = A.length;
        int low = 0, high = N - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            /* in normal Binary search, only mid is compared to target, here mid, mid - 1 and mid + 1 all will be compared */
            
            if(A[mid] == target) return  mid;
            else if((mid - 1 < N) && (A[mid - 1] == target)) return mid - 1;
            else if((mid + 1 < N) && (A[mid + 1] == target)) return mid + 1;
            
            /* Move left or right based on decision */
            if(target < A[mid]) high = mid - 2;
            else if(target > A[mid]) low = mid + 2;
        }
        return -1; // If not Found
    }
}
