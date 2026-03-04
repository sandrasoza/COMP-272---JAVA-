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
     // Get the values closer to the target
     Integer lowVal = set.floor(target);
     Integer highVal = set.ceiling(target);

     // Return if target falls below the small value or above the largest value 
     if (lowVal == null) return highVal;    
     if (highVal == null) return lowVal;     

     // Compute floor and ceiling different 
     int lowDif = target - lowVal;
     int highDif = highVal - target;

     
     int closest = 0;
     if (lowDif <= highDif) {
      closest = lowVal;   // Return smallest if their difference is equal 
     } else {
      closest = highVal;
     }
     
     return closest;
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
    // Create a set 
    TreeSet<Integer> newSet = new TreeSet<>();

    // Get floor and ceiling
    Integer left_side = set.floor(target);  // Smaller values at the left of target
    Integer right_side = set.ceiling(target);  // Larger values at the right of target 

    // Expand and collect values 1
    while((left_side != null || right_side != null) && newSet.size() < k) {
      if (left_side == null) {  // Floor does not exist
            newSet.add(right_side);
            right_side = set.higher(right_side);
        }
        else if (right_side == null) {  // Ceiling does not exist 
            newSet.add(left_side);
            left_side = set.lower(left_side);
        }
        else {  // Compute difference 
            int leftDif = target - left_side;
            int rightDif = right_side - target;

            if (leftDif <= rightDif) {
                newSet.add(left_side);
                left_side = set.lower(left_side);
            } else {
                newSet.add(right_side);
                right_side = set.higher(right_side);
            }
        }
    }
    
    return newSet;
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
    // Use a submap 
    int count = map.subMap(low, true, high, true).size(); // Inclusive range 
    return  count;
    
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
    // Return if set has less than 2 elements
    if (set.size() < 2) {
      return 0;
    }
    int maxDiff = 0;
    Integer prev = null;  // set to null
    
    // Traverse map
    for (Integer element: set){
      if (prev != null){  
        int currGap = element - prev;  // Diff between consecutive values
         if (currGap > maxDiff ){
          maxDiff = currGap;
        }
      }
      prev = element;  // Move forward in the set 
    }
      return maxDiff;
    }
 
  }
