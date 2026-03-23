/******************************************************************
 *
 *   Sandra Soza Zambrano / COMP 272- 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;


class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        HashSet <Integer> set = new HashSet<>();
        boolean isSubset = true;

        // Copy list1 into the hash table
        for(Integer value : list1){
            set.add(value);
        }

        // Check if the elements of list2 exist in list1
        for(Integer element: list2){
            if(!set.contains(element)){
                isSubset = false;
                return isSubset;
            }
            
        }

        return isSubset;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        if(array.length < k || k <= 0){  // Check edge cases
            return -1;
        }

        // Create a min heap priority queue
        PriorityQueue <Integer> queue = new PriorityQueue<>();

        // Copy elements in the queue 
        for(Integer value : array){
            queue.add(value);

            if(queue.size() > k){  // Queue cannot exceed size k
                queue.remove();
            }
            
        }

        return queue.poll();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE

        return null;
    }

}