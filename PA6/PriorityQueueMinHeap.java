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
        // TODO: complete this method
    }

    /*
     * Removes and returns the minimum element from the heap.
     * Assumes the heap is not empty.
     */
    public int removeMin() {

        // TODO: complete this method
        return 0;
    }

    public static ArrayList<Integer> pqSort(int[] values) {
        /*
         * Returns a sorted ArrayList using a priority queue built with heapify.
         */
        // TODO: complete this method
        return null;
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}