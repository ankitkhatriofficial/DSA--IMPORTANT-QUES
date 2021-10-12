/**
  * Problem Statement: You are given a sorted Array and a target element. You need to find the ceil and floor of the target. If target is present in the array, floor & ceil
  * of target will be the target. If the target is not present in the array, print just smaller (floor) and just larger (ceil) of the target element. 
  * If floor or ceil is not available in the array, print -1.
  
  * Topic: Binary Search
  * Time Complexity: O(logn)
  * Space Complexity: O(1)
*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        int[] A = {1, 2, 3, 4, 8, 10, 12, 19};
        int target = 5;
        System.out.println("Floor is: " + getFloor(A, target));
        System.out.println("Ceil is: " + getCeil(A, target));
    }
    
    private static int getFloor(int[] A, int target){
        int floor = -1;
        
        int low = 0, high = A.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(A[mid] == target) return A[mid];
            else if(A[mid] < target){
                floor = A[mid];
                low = mid + 1;
            }else 
                high = mid - 1;
        }
        return floor;
    }
    
    private static int getCeil(int[] A, int target){
        int ceil = -1;
        
        int low = 0, high = A.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(A[mid] == target) return A[mid];
            else if(A[mid] < target) low = mid + 1;
            else{
                ceil = A[mid];
                high = mid - 1;
            }
        }
        return ceil;
    }
}
            
