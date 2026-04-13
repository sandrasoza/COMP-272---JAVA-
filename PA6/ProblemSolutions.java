/******************************************************************
 *
 *   Sandra Soza Zambrano / COMP 272-002
 *   
 *
 ******************************************************************/

import java.util.*;

public class ProblemSolutions {

    /*
     * Question 1 — Sorting 1
     *
     * Returns a sorted ArrayList containing the unique strings
     * that appear more than once in the input list.
     */
    public static ArrayList<String> showDuplicates(ArrayList<String> words) {

        ArrayList<String> results = new ArrayList<>();

        Collections.sort(words);  // Sort the ArrayList

     
        for(int i = 1; i < words.size(); i++){  // Traverse the list 
            
            if(words.get(i).equals(words.get(i-1))){
                
                if(results.isEmpty() || !results.get(results.size() - 1).equals(words.get(i))){
                    results.add(words.get(i));  // At least one duplicate
                }
           
            }

        }

        return results;

    }

    /*
     * Question 2 — Sorting 2
     *
     * Returns a sorted ArrayList of pairs written as strings,
     * where each pair sums to k.
     *
     * Example pair format: "(1, 6)"
     */
    public static ArrayList<String> pair(int[] nums, int k) {
        // TODO: complete this method
        return null;
    }

    /*
     * Question 3 — Boulder Game
     *
     * Returns the weight of the last remaining boulder.
     * If no boulders remain, returns 0.
     */
    public static int lastBoulderWeight(int[] boulders) {
        // TODO: complete this method
        return 0;
    }
}
