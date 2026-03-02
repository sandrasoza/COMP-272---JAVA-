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

import java.util.*;

public class RBTreeProblems {

  /**
   * closestValue()
   *
   * Given a TreeSet of integers and a target value, return the element
   * in the set that is numerically closest to the target.
   *
   * If two values are equally close, return the smaller value.
   *
   * You must use TreeSet navigation methods.
   */
  public static int closestValue(TreeSet<Integer> set, int target) {
    // TODO
    int maxVal = 0;

    // Traverse the TreeSet
    for(integer value : set) {

        // Compare target value 
        if( set < target ){
            maxVal = set;
        } 
        
    }
    return 0;
  }

  /**
   * kClosestValues()
   *
   * Return the k values in the set that are closest to the target value.
   * The result must be returned as a TreeSet so it is sorted ascending.
   *
   * Suggested strategy:
   *   - Start near the target using floor() and/or ceiling().
   *   - Expand outward using lower() and higher().
   */
  public static Set<Integer> kClosestValues(TreeSet<Integer> set, int target, int k) {
    // TODO
    return new TreeSet<>();
  }

  /**
   * rangeCount()
   *
   * Given a TreeMap<Integer,String> and a range [low, high] inclusive,
   * return how many keys fall inside that range.
   *
   * You MUST use subMap() to obtain the range view of the map.
   * Do NOT iterate over the entire map.
   */
  public static int rangeCount(TreeMap<Integer,String> map, int low, int high) {
    // TODO
    return 0;
  }

  /**
   * longestGap()
   *
   * Given a TreeSet of integers representing sorted positions,
   * return the largest difference between consecutive values.
   *
   * If the set has fewer than 2 elements, return 0.
   */
  public static int longestGap(TreeSet<Integer> set) {
    // TODO
    return 0;
  }
}