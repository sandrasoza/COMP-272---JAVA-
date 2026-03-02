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
    int minVal = 0;

    // Traverse the TreeSet
    for(integer value : set) {

        // Compare target value 
        if( set < target ){
            maxVal = set;
        } if (maxVa){
            getMin = min(maxVal, minVal);  
        }  
    }
    return getMin;
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