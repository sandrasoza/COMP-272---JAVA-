/*
 * *** Sandra Soza Zambrano /COMP 272 - 002 ***
 *
 * This file implements a simple AVL Tree focused only on INSERTIONS.
 * You are to implement the four rotation methods so that insertions
 * keep the tree balanced. No deletion of nodes is required.
 *
 * Notes:
 *  - height(null) = 0
 *  - Null children represent the leaf placeholders
 *  - A node with two null children therefore has height = 1
 *  - Duplicates are ignored (do nothing).
 */

class Node {
    int value;
    int height;
    Node leftChild, rightChild;

    public Node(int data) {
        value = data;
        height = 1;
        leftChild = rightChild = null;
    }
}

public class LUC_AVLTree {
    private Node rootNode;

    public LUC_AVLTree() { rootNode = null; }
    public void removeAll() { rootNode = null; }
    public boolean checkEmpty() { return rootNode == null; }
    public void insert(int v) { rootNode = insertElement(v, rootNode); }

    private int getHeight(Node n) { return (n == null) ? 0 : n.height; }
    private int getMax(int a, int b) { return (a > b) ? a : b; }

    private int getBalanceFactor(Node n) {
        if (n == null) return 0;
        return getHeight(n.leftChild) - getHeight(n.rightChild);
    }

    private Node insertElement(int value, Node node) {
        if (node == null) return new Node(value);

        if (value < node.value) {
            node.leftChild = insertElement(value, node.leftChild);
            if (Math.abs(getBalanceFactor(node)) > 1) {
                if (value < node.leftChild.value)
                    node = LLRotation(node);   // TODO
                else
                    node = LRRotation(node);   // TODO
            }
        }
        else if (value > node.value) {
            node.rightChild = insertElement(value, node.rightChild);
            if (Math.abs(getBalanceFactor(node)) > 1) {
                if (value > node.rightChild.value)
                    node = RRRotation(node);   // TODO
                else
                    node = RLRotation(node);   // TODO
            }
        } else {
            // duplicate -> do nothing
        }

        node.height = getMax(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        return node;
    }

    /***********************************************************
     * YOUR WORK STARTS HERE
     * Implement the four rotations below.
     * After rotation, update the heights of the nodes you moved.
     ***********************************************************/

    /**
     * LLRotation: Right-rotate around x when left-left heavy.
     * Return the new subtree root.
     */
    private Node LLRotation(Node x) {
        // TODO: implement, then update heights, then return new root
        // Identify b and t2
        Node b = x.leftChild;
        Node t2 = b.rightChild;
        
        // During rotation b becomes the root
        b.rightChild= x;  
        x.leftChild = t2;
      
        // Update height 
        b.height = getMax(getHeight(b.leftChild), getHeight(b.rightChild)) + 1;
        x.height = getMax(getHeight(x.leftChild), getHeight(x.rightChild)) + 1;
        return b;
    }

    /**
     * RRRotation: Left-rotate around x when right-right heavy.
     * Return the new subtree root.
     */
    private Node RRRotation(Node x) {
        // TODO: implement, then update heights, then return new root
        
        // Identify b and t1
        Node b = x.rightChild;
        Node t1 = b.leftChild;

        // During rotation b becomes the root
        b.leftChild = x;  
        x.rightChild = t1;

        // Update b and x height 
        b.height = getMax(getHeight(b.leftChild), getHeight(b.rightChild)) + 1;
        x.height = getMax(getHeight(x.leftChild), getHeight(x.rightChild)) + 1;
        return b;
    }

    /**
     * LRRotation: First rotate left child, then rotate x.
     * Return the new subtree root.
     */
    private Node LRRotation(Node x) {
        // TODO: implement using your other rotations (small and clean)
        Node b = x.leftChild;
        Node c = b.rightChild;
        Node t1 = c.leftChild;
        Node t2 = c.rightChild;

        // During rotation C becomes the root
        c.rightChild = x;  
        c.leftChild = b;
        b.rightChild = t1;
        x.leftChild = t2;

        //Update height
        b.height = getMax(getHeight(b.leftChild), getHeight(b.rightChild)) + 1;
        x.height = getMax(getHeight(x.leftChild), getHeight(x.rightChild)) + 1;
        c.height = getMax(getHeight(c.leftChild), getHeight(c.rightChild)) + 1;

        return c;
    }

    /**
     * RLRotation: First rotate right child, then rotate x.
     * Return the new subtree root.
     */
    private Node RLRotation(Node x) {
        // TODO: implement using your other rotations (small and clean)
        Node b = x.rightChild;
        Node c = b.leftChild;
        Node t1 = c.leftChild;
        Node t2 = c.rightChild;

        // During rotation C becomes the root
        c.leftChild = x;  
        c.rightChild = b;
        x.rightChild = t1;
        b.leftChild = t2;

        //Update height
        b.height = getMax(getHeight(b.leftChild), getHeight(b.rightChild)) + 1;
        x.height = getMax(getHeight(x.leftChild), getHeight(x.rightChild)) + 1;
        c.height = getMax(getHeight(c.leftChild), getHeight(c.rightChild)) + 1;

        return c;
    }
}