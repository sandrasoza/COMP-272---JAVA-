/*
 * *** Sandra Soza Zambrano / 272 -002 ***
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
    }

    /* averageHelper:
       Return an int array {sum, count} for this subtree.
       Use post-order style: get left pair, right pair, then add current node. */
    protected int[] averageHelper(BTNode node) {
        // TODO: implement and return {sum, count}
        return new int[]{0, 0}; // placeholder so code compiles
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
   2) What is its time and space complexity?
   3) Under what condition will the returned string have sorted values?

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

}