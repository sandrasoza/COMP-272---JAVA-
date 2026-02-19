/*
 * *** Sandra Soza Zambrano / 272 -002 ***
 * Sources: https://www.geeksforgeeks.org/dsa/basic-operations-for-queue-in-data-structure/
 *
 * This file shows a simple Binary Tree (we'll insert like a BST for convenience).
 * You will implement the following methods:
 *
 *   1) replaceValueHelper(node, oldVal, newVal)
 *      Replace every occurrence of oldVal with newVal (visit the entire tree).
 *
 *   2) averageHelper(node) -> int[]{sum, count}
 *      Return the subtree sum and node count (post-order style).
 *
 *   3) insertLevelOrder(value)
 *      Insert without using comparisons: fill the tree level-by-level (BFS),
 *      placing the new node at the first available position.
 *
 *   4) isValidBST()
 *      Return true if the tree satisfies the BST property (strict ordering:
 *      all left < node < all right).
 *
 *   5) mystery()
 *      A provided method. Answer the questions in the comment above it.
 *
 * Keep your code clear and direct. No tricks.
 */


import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class BTNode {
    int data;
    BTNode left, right;
    BTNode(int d) { data = d; }
}

public class BinaryTree {
    private BTNode root;

    public BinaryTree() { root = null; }
    public void clear()  { root = null; }

    /* Insert like a simple BST so we can build a predictable shape quickly. */
    public void insert(int value) { root = insertRec(root, value); }
    private BTNode insertRec(BTNode n, int v) {
        if (n == null) return new BTNode(v);
        if (v < n.data) n.left  = insertRec(n.left, v);
        else if (v > n.data) n.right = insertRec(n.right, v);
        else { /* duplicate value -> do nothing */ }
        return n;
    }

    /* Preorder traversal as a single string with spaces, ending with a space. */
    public String preOrder() { return preOrderRec(root); }
    private String preOrderRec(BTNode n) {
        if (n == null) return "";
        return n.data + " " + preOrderRec(n.left) + preOrderRec(n.right);
    }

    /* Replace all occurrences of oldVal with newVal in the entire tree. */
    public void replaceValue(int oldVal, int newVal) {
        replaceValueHelper(root, oldVal, newVal); // you implement the helper
    }

    /* Return the average of all node values as a double.
       If the tree is empty, we define the average to be 0.0 (simple and safe). */
    public double average() {
        if (root == null) return 0.0; // empty tree -> average is 0.0
        int[] pair = averageHelper(root); // pair[0] = sum, pair[1] = count
        int sum = pair[0], count = pair[1];
        if (count == 0) return 0.0;   // safety
        return (double) sum / (double) count;
    }

    /***********************************************************
     * YOUR WORK STARTS HERE
     * Implement the two helpers below. Keep them small and clean.
     ***********************************************************/

    /* replaceValueHelper:
       Visit every node. If node.data == oldVal, change it to newVal. */
    protected void replaceValueHelper(BTNode node, int oldVal, int newVal) {
    // TODO: implement (use simple recursion). If node is null, just return.
        if (node == null){
            return;
        }
    
        if (node.data == oldVal){
            node.data = newVal;
        }
        replaceValueHelper(node.left, oldVal, newVal);
        replaceValueHelper(node.right, oldVal, newVal);
        
    }

    /* averageHelper:
       Return an int array {sum, count} for this subtree.
       Use post-order style: get left pair, right pair, then add current node. */
    protected int[] averageHelper(BTNode node) {
        // TODO: implement and return {sum, count}
        int sum = 0;
        int count = 0;

        if(node != null){
            // Use recursion
            int[] storeLeft = averageHelper(node.left);
            int[] storeRight = averageHelper(node.right);
        
            // Compute sum and count
            sum = storeLeft[0]+ storeRight[0] + node.data;
            count = storeLeft[1] + storeRight[1] + 1;
        }

        return new int[]{sum, count}; // placeholder so code compiles
    }

    /* insertLevelOrder:
   Insert a new node into the tree so that the tree remains
   as complete as possible (fill each level left to right).

   This method must:
     - Use level-order traversal (BFS).
     - Insert the new node at the first available position.
     - Not use any value comparisons.

    */
    public void insertLevelOrder(int value) {
        // TODO: implement
        // Create a new node containing the given value
        BTNode temp = new BTNode(value);

        // Check if the list is empty
        if(root == null){
            root = temp;
            return;
        }

        // Create a Queue for BFS implementation using a LinkedList
        Queue<BTNode> q =  new LinkedList<>();
        //add the root
        q.add(root);

        while(!q.isEmpty()){

            BTNode current = q.remove(); // Remove first element from the queue
            // Check if the current node has a left child
            if(current.left != null){ // Enqueue left child
                q.add(current.left);
            }else{
                current.left = temp;  // Insert new node to the left
                return;
            }
            if(current.right != null){ // Enqueue right child
                q.add(current.right);
            }else{ 
                current.right = temp;  // Insert new node to the right
                return;
            } 
        }    
    }

    
    /* isValidBST:
      Return true if the tree satisfies the Binary Search Tree property.
      A tree is a BST if for every node:
          all values in the left subtree are strictly smaller, and
          all values in the right subtree are strictly larger.
   */
    public boolean isValidBST() {
        // TODO: implement (use recursion)
        return false; // placeholder
    }


    /* mystery:

   This method returns a string containing all node values separated by spaces.
   The string must end with a space (like preOrder).

   QUESTION:
   1) What does this method compute?
     This method returns a string using in-order traversal 
   2) What is its time and space complexity?
     2.1 Time Complexity: O(n) because each node is visited in the tree
     2.2 Space Complexity: O(n) no additional varibales are created. 
   3) Under what condition will the returned string have sorted values?
     This current tree follows in-order traversal which visits each node in sorted order. It visits left node - root - right node
     and so on, traversing the tree in a increasing order or predetermined sequence. 
   Write your answers as comments above the mystery method.
   */
    public String mystery() {

        String result = "";
        Stack<BTNode> stack = new Stack<>();
        BTNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result += current.data + " ";

            current = current.right;
        }

        return result;
    }
    


    public static void main(String[] args){
        BinaryTree Btt = new BinaryTree(); //instance 

        //insert nodes 

        Btt.insert(1);
        Btt.insert(2);
        Btt.insert(3);
        Btt.insert(4);
        Btt.insert(5);


        String preOrdercheck = Btt.preOrder();
        System.out.println(preOrdercheck);
    }

}