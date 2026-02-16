/*
 * *** DO NOT MODIFY THIS FILE ***
 *
 * This Main runs small automated checks for each part of the assignment.
 * Read the console output carefully. If a test fails, use the message
 * to guide your debugging.
 */

import java.util.*;

public class Main {

    // -------------------------
    // Q1: replaceValueHelper (20 pts)
    // -------------------------
    public static int testQ1_replaceValueHelper() {
        int points = 0;

        // Build a small BST so structure is predictable
        BinaryTree bt = new BinaryTree();
        for (int v : new int[]{10, 5, 15, 2, 7, 12, 20}) bt.insert(v);

        // Replace 7 -> 70 (preorder should reflect change)
        bt.replaceValue(7, 70);
        String expectedPre = "10 5 2 70 15 12 20 ";
        boolean ok = bt.preOrder().equals(expectedPre);

        System.out.println((ok ? "[PASS] " : "[FAIL] ") + "Q1 replaceValueHelper");
        if (ok) points += 20;

        return points; // /20
    }

    // -------------------------
    // Q2: averageHelper (20 pts)
    // -------------------------
    public static int testQ2_averageHelper() {
        int points = 0;

        // Build a predictable BST
        BinaryTree bt = new BinaryTree();
        for (int v : new int[]{10, 5, 15, 2, 7, 12, 20}) bt.insert(v);

        // Average of (10+5+15+2+7+12+20) / 7 = 71/7
        double avg = bt.average();
        double expected = 71.0 / 7.0;
        boolean ok = Math.abs(avg - expected) < 1e-9;

        System.out.println((ok ? "[PASS] " : "[FAIL] ") + "Q2 averageHelper");
        if (ok) points += 20;

        return points; // /20
    }

    // -------------------------
    // Q3: insertLevelOrder (20 pts)
    // -------------------------
    public static int testQ3_insertLevelOrder() {
        int points = 0;

        // Use values that would NOT land in these positions via BST insertion.
        // Level-order insertion should fill: root, left, right, left-left, ...
        BinaryTree bt = new BinaryTree();
        for (int v : new int[]{10, 5, 15, 12}) bt.insertLevelOrder(v);

        // Expected shape after BFS insertion:
        //       10
        //      /  \
        //     5   15
        //    /
        //   12
        //
        // Preorder: 10 5 12 15
        String expectedPre = "10 5 12 15 ";
        boolean ok = bt.preOrder().equals(expectedPre);

        System.out.println((ok ? "[PASS] " : "[FAIL] ") + "Q3 insertLevelOrder");
        if (ok) points += 20;

        return points; // /20
    }

    // -------------------------
    // Q4: isValidBST (20 pts)
    // -------------------------
    public static int testQ4_isValidBST() {
        int points = 0;

        boolean okAll = true;

        // Case 1: a valid BST built using BST insert
        {
            BinaryTree bt = new BinaryTree();
            for (int v : new int[]{10, 5, 15, 2, 7, 12, 20}) bt.insert(v);
            boolean ok = bt.isValidBST();
            okAll = okAll && ok;
        }

        // Case 2: break BST property using replaceValue (structure unchanged, values changed)
        // Replace 5 -> 50 makes a left-subtree node greater than root (10), so NOT a BST.
        {
            BinaryTree bt = new BinaryTree();
            for (int v : new int[]{10, 5, 15, 2, 7, 12, 20}) bt.insert(v);
            bt.replaceValue(5, 50);
            boolean ok = !bt.isValidBST();
            okAll = okAll && ok;
        }

        System.out.println((okAll ? "[PASS] " : "[FAIL] ") + "Q4 isValidBST");
        if (okAll) points += 20;

        return points; // /20
    }


    // -------------------------
    // Overall summary
    // -------------------------
    public static void main(String[] args) {
        System.out.println("=== COMP 272 Assignment Autograder ===");

        int total = 0;

        int q1 = testQ1_replaceValueHelper();  // /20
        int q2 = testQ2_averageHelper();       // /20
        int q3 = testQ3_insertLevelOrder();    // /20
        int q4 = testQ4_isValidBST();          // /20

        total = q1 + q2 + q3 + q4 + q5;

        System.out.println("--------------------------------------");
        System.out.println("Q1 replaceValueHelper: " + q1 + " / 20");
        System.out.println("Q2 averageHelper:      " + q2 + " / 20");
        System.out.println("Q3 insertLevelOrder:   " + q3 + " / 20");
        System.out.println("Q4 isValidBST:         " + q4 + " / 20");
        System.out.println("--------------------------------------");
        System.out.println("SUBTOTAL: " + total + " / 80 (This does not include Question 5)");
    }