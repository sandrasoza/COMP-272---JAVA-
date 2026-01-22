/*
 * COMP 272 — Programming Assignment 1 
 * Student: Sandra Soza Zambrano   Section: 400C
 *
 * IMPORTANT:
 * - Implement the TODO methods. Keep the method signatures unchanged.
 * - Do NOT modify Main_v3.java (driver).
 * - You may add private helpers and fields if needed.
 */

import java.util.*;
import java.util.Stack;

public class HW1 {

    /* =========================
     * Part 1 — Linked List (SLL)
     * ========================= */
    public static class SinglyLinkedList {
        static class Node {
            int data;
            Node next;
            Node(int d){ data = d; }
        }

        private Node head;
        private int size = 0;

        // Utilities for testing/demo
        public void addLast(int x){
            Node nn = new Node(x);
            if(head == null){ head = nn; }
            else{
                Node cur = head;
                while(cur.next != null) cur = cur.next;
                cur.next = nn;
            }
            size++;
        }

        public int size() { return size; }

        @Override public String toString(){
            StringBuilder sb = new StringBuilder("[");
            Node cur = head;
            while(cur != null){
                sb.append(cur.data);
                cur = cur.next;
                if(cur != null) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
        /**
         * Remove all duplicate values, preserving the first occurrence.
         * Example: [3,1,3,2,1] -> [3,1,2]
         */
        public void removeDuplicates(){
            // TODO: implement using a HashSet or O(n^2) two-pointer approach
            
            //Utilizes a HashSet
            //Check if the list is empty 
            if (head == null){
                throw new IllegalStateException("List is empty");
            }
            
            //Create a new Hashset and a head and prev pointer 
            HashSet<Integer> elements =  new HashSet<>();
            Node current = head;
            Node prev = null;

            while (current != null){
                if (elements.contains(current.data)){ //delete if duplicate is found
                    prev.next = current.next; //skip the current node 
                }else{
                    //add to the HashSet for the first time 
                    elements.add(current.data);
                    prev = current; //continue with the next node 
                }
                current = current.next;
            }
            
        }


        /**
         * Reverse the entire list by using a stack (java.util.Stack).
         * You must use a Stack in your solution (push values or nodes).
         * Example: [1,2,3,4] -> [4,3,2,1]
         * Time: O(n), Extra Space: O(n).
         */
        public void reverse(){
            // TODO: implement using java.util.Stack

            Stack<Integer> stack = new Stack<>();  //declare stack 
            Node current =  head;  //start at the head

            while (current != null){ //Traverse the linked list 
                stack.push(current.data);
                current = current.next;
            }

            //Rebuild the list from the stack
            current = head; 
            while (current != null){  //Traverse the linked list 
                Integer value = stack.pop();
                current.data = value;  //Assign popped value to the current node (reversed order)
                current = current.next;
            }

        }

        /**
         * Return the value of the n-th node from the end (1-based).
         * Example: [10,20,30,40,50], n=2 -> 40.
         * Use a single pass (two pointers). Throw NoSuchElementException if invalid.
         */
        public int getNthFromEnd(int n){
            // TODO: implement two-pointer technique
            Node fast = head;
            Node slow = head;

            int  distance = n;
            int count = 0;

            while (count != distance){  //Traverse the list
                if (fast == null){
                    throw new NoSuchElementException("n out of range");
                }
                count ++;
                fast = fast.next;  //Advance to the next node
            }
            while (fast != null){  //fast starts at position n 
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }

    }

    /* =========================
     * Part 2 — Stack
     * ========================= */

    /**
     * STACK: Return true if input is a palindrome ignoring case and spaces.
     * Examples: "Race Car" -> true, "racecar" -> true, "ab ca" -> false.
     * Time: O(n), Extra Space: O(n).
     * Use java.util.Stack<Character>.
     */
    public static boolean isPalindrome(String input){
        Stack<Character> st = new Stack<>();
        String s = input.toLowerCase().replaceAll("\\s+", "");
        
        // TODO: implement method here  

        for(int i = 0; i < s.length(); i++){//Traverse the string 
                st.push(s.charAt(i));  //Push each character
         }

        boolean isEqual = true;
        // Traverse again and compare each character 
        for(int i = 0; i < s.length(); i++){ 
            Character letter = st.pop();

            if(letter != s.charAt(i)){ 
               isEqual = false; 
             }
        }  
        return isEqual;
    }

    /* =========================
     * Part 3 — Algorithm Analysis
     * ========================= */

    public static int algorithmAnalysis1(int n, int m) {
        int a = 0, b = 0;

        for (int i=0; i < n; i++) a++;   // simulate work
        for (int j=0; j < m; j++) b++;   // simulate work

        /*
         * Select the correct option listed below:
         *   1. O(N * M) time, O(1) space
         *   2. O(N + M) time, O(N + M) space
         *   3. O(N + M) time, O(1) space
         *   4. O(N * M) time, O(N + M) space
         *
         * TODO: return the answer (which option is correct), in the return statement
        */

        // RETURN THE CORRECT OPTION NUMBER LISTED ABOVE
        return -1;
    }


    public static int algorithmAnalysis2(int n) {
        int i, j, k = 0;
        for (i = n/2; i <= n; i++)
            for ( j = 2; j <= n; j = j*2 )
                k += n/2;

        /*
         * Select the correct option listed below:
         *   1. O(N) time
         *   2. O(N log N) time
         *   3. O(N^2) time
         *   4. O(N^2 log N) time
         *
         * TODO: return the answer (which option is correct), in the return statement
         */

        // RETURN THE CORRECT OPTION LISTED ABOVE
        return -1;
    }
}
