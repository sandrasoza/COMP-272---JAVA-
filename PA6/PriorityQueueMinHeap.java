import java.util.*;

public class PriorityQueueMinHeap {
    private ArrayList<Integer> heap;

    public PriorityQueueMinHeap() {
        heap = new ArrayList<>();
    }

    public PriorityQueueMinHeap(int[] data) {
        heap = new ArrayList<>();
        for (int value : data) {
            heap.add(value);
        }
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int left(int index) {
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * index + 2;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void bubbleDown(int index) {
        while (true) {
            int leftChild = left(index);
            int rightChild = right(index);
            int smallest = index;

            if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
                smallest = leftChild;
            }

            if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
                smallest = rightChild;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    /*
     * Rearranges the internal ArrayList so that it satisfies
     * the min-heap property using the bottom-up heapify algorithm.
     */
    public void heapify() {

        // Begin at the last non- leaf node
        int index = (size()/ 2) - 1;
        
        // Go from the index to the root 
        for(int i = index; i >= 0 ; i--){

            bubbleDown(i); 
        }
    }

    /*
     * Removes and returns the minimum element from the heap.
     * Assumes the heap is not empty.
     */
    public int removeMin() {

        int root = heap.get(0);  // Get the root
        int temp = heap.remove(size() -1);  // Get the last element 

        // Update the root position with the last array element
        if(!heap.isEmpty()){
            heap.set(0, temp);
            bubbleDown(0);  // Restore heap property
        }

         return root;
    }

    /*
     * Returns a sorted ArrayList using a priority queue built with heapify.
    */
    public static ArrayList<Integer> pqSort(int[] values) {
    
        // Add values in a min Heap Priority Queue
        PriorityQueueMinHeap elements = new PriorityQueueMinHeap(values);
        elements.heapify(); // Arrange to satisfy  min-heap property

        // Array list to store the sorted elements
        ArrayList<Integer> sorted = new ArrayList<>();

        int size = elements.size();
        for(int i = 0; i < size; i++){
            sorted.add(elements.removeMin());  
        }

        return sorted;
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}