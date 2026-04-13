import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("cat");
        words.add("bird");
        words.add("dog");
        words.add("dog");
        words.add("apple");

        System.out.println("Question 1:");
        System.out.println(ProblemSolutions.showDuplicates(words));

        System.out.println("\nQuestion 2:");
        System.out.println(ProblemSolutions.pair(new int[]{1,2,3,4,5,6}, 7));

        System.out.println("\nQuestion 3:");
        System.out.println(ProblemSolutions.lastBoulderWeight(new int[]{2,7,4,1,8,1}));

        System.out.println("\nQuestion 4:");
        PriorityQueueMinHeap pq = new PriorityQueueMinHeap(new int[]{7,3,9,1,6,8,2});
        pq.heapify();
        System.out.println("Heap after heapify: " + pq);
        System.out.println("Sorted result: " + PriorityQueueMinHeap.pqSort(new int[]{7,3,9,1,6,8,2}));
    }
}