/** 
  * Problem Statement: You ae given a rotated sorted(ascending) array and a target element. You have to print the index of the element.
  * Print -1 if the element is not present. "You can print any index if the target element is repeated more than once in the array."
  *
  * Topic: Binary Search
  * Time Complexity: O(logn)
  * Space Complexity: O(1)
*/

import java.util.*;

class Solution{
    
    public static void main(String[] args){
        int[] A = { 40, 50, 60, 70, 80, 90, 100, 10, 10, 10, 10, 20, 30};
        int target = 10;
        System.out.println(search(A, target));
    }
    
    // Function to solve the Given Problem => TC: O(3logn) => O(logn)
    private static int search(int[] A, int target){
        int minIdx = minElement(A); // Findinig the minimum element in the given sorted rotated Array
        
        if(target == A[minIdx]) return minIdx; // if target element is the mininum element
        if(target < A[minIdx]) return -1; // if target element is smaller than minimum element
        
        int res = BinarySearch(A, 0, minIdx - 1, target); // search on left part of minimum element in the array
        if(res != -1) return res;
        
        return BinarySearch(A, minIdx + 1, A.length - 1, target); // search on right part of minimum element in the array
    }
    
    // Function to find element in sorted Array => TC: O(logn)
    private static int BinarySearch(int[] A, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(A[mid] == target) return mid;
            if(target < A[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
    
    // Function to find minimum element in rotated Sorted Array => TC: O(logn)
    // https://github.com/ankitkhatriofficial/DSA--IMPORTANT-QUES/blob/main/Binary-search/find-min-ele-in-sorted-rotated-array.java
    private static int minElement(int[] A){
        int low = 0, high = A.length - 1;
        
        while(low < high){
            int mid = low + (high - low) / 2;
            if(Math.abs(high - low) == 1){
                if(A[low] < A[high]) return low;
                else return high;
            }
            
            if(A[mid] < A[high]) high = mid;
            else low = mid;
        }
        return low;
    }
}
        
