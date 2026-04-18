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

        for(int i = 1; i < words.size(); i++){  // Traverse the sorted list 
            
            if(words.get(i).equals(words.get(i-1))){
                
                if(results.isEmpty() || !results.get(results.size() - 1).equals(words.get(i))){
                    results.add(words.get(i));  // Add only if current element is not in the list
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
        
        ArrayList<String> pairs = new ArrayList<>(); 
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while(i < j ){  
            int sum = nums[i] + nums[j];  // Add the values located at the extremes

            if(sum == k ){  // Compare if equal to k
                String result = "("+ nums[i] +", " + nums[j] + ")";  // Get pair

                if(pairs.isEmpty() || !pairs.get(pairs.size() - 1).equals(result)){
                    pairs.add(result);
                }
                i++;  // Move from the front
                j--;  // Move from the back 
                
            } else if (sum < k){
                i++;  // Move forward if less than k 
            } else {
                j--;  // Move backwards if greater than k 
            }
        }

        return pairs;
    }

    /*
     * Question 3 — Boulder Game
     *
     * Returns the weight of the last remaining boulder.
     * If no boulders remain, returns 0.
     */
    public static int lastBoulderWeight(int[] boulders) {

    // Creatre a max Priority queue
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

    // Add elements to the Queue
    for (int i : boulders) {
        maxPQ.add(i);
    }

    int x = 0;
    int y = 0;

    while (maxPQ.size() > 1) {

        // Get the first two largest boulders, assume they are equal.
        x = maxPQ.poll();
        y = maxPQ.poll();

        if (x != y) {
            maxPQ.add(x - y);  // Update weight if different
        }
    }

    return maxPQ.isEmpty() ? 0 : maxPQ.poll();
    }
}
