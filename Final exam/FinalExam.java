import java.util.*;
import java.io.*;
import java.nio.file.*;

public class FinalExam {

    /* =========================================================
     * Exercise 1 - Trending Hashtags Report
     * ========================================================= */
    static class TrendingReport {
        private HashMap<String, Integer> freq;

        public TrendingReport() {
            freq = new HashMap<>();
        }

        /*
         * TODO: Reads hashtags from a file (one per line)
         * and updates their frequencies.
         */
        public void loadFromFile(String filename) throws IOException {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for(String line : lines){
                String tag = line.trim();
                if (!tag.isEmpty()){
                    addTag(tag);
                }
            }
        }

        /*
         * TODO: Updates the frequency of a given hashtag.
         */
        public void addTag(String tag) {
            if (tag == null) return;

            if (freq.containsKey(tag)) {
                freq.put(tag, freq.get(tag) + 1);
            } else {
                freq.put(tag, 1);
            }
        }

        /*
         * TODO: Returns the frequency of a hashtag,
         * or 0 if it does not appear.
         */
        public int getFrequency(String tag) {
            return freq.containsKey(tag) ? freq.get(tag) : 0;
        }

        /*
         * TODO: Returns the k most frequent hashtags.
         * Use a PriorityQueue.
         */
        public ArrayList<String> topKFrequent(int k) {

            // Create a min heap PQ
            PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> compareByFrequency(a, b)
            );

            
            // Add each tag to the PriorityQueue
            for (String tag : freq.keySet()) {
                pq.offer(tag);
                if (pq.size() > k) {  //Keep the tags with the highest frequency
                    pq.poll();
                }
            }
              
            return new ArrayList<>(pq);
        }

        /* 
        * Helper method that compares two hashtags by frequency. 
        * Returns a negative value if the tag is less frequent and a positive if is more frequent.
        * Returns 0 if they have the same frequency
        */ 
        private int compareByFrequency(String a, String b) {
            return getFrequency(a) - getFrequency(b);
        }

        

        /*
         * TODO: Returns all distinct hashtags sorted by:
         * 1. decreasing frequency
         * 2. alphabetical order if frequencies are equal
         */
        public ArrayList<String> sortedReport() {
            ArrayList<String> tags = new ArrayList<>();
            for (String tag : freq.keySet()) {
                tags.add(tag);
            }

            // Lambda to sort by decreasing frequency, alphabetically when frequencies are equal
             Collections.sort(tags, (a, b) -> compareForSorted(a, b));

            return tags;
        }

        /* 
        * Helper method that compares two hashtags for the sorted report.
        * Returns a negative value when one element is more frequent than other,
        * a positive value if a frequency is less than other,
        * and 0 if the frequency is the same.
        */
        private int compareForSorted(String a, String b) {
            if (getFrequency(a) != getFrequency(b)) {
                return getFrequency(b) - getFrequency(a); 
            } else {
                return a.compareTo(b); 
            }
        }
    }


    /* =========================================================
     * Exercise 2 - Route Existence in a Graph
     * ========================================================= */
    static class Graph {
        private Map<String, ArrayList<String>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }

        public void addVertex(String v) {
            adjList.putIfAbsent(v, new ArrayList<>());
        }

        public void addEdge(String v1, String v2) {
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        public ArrayList<String> getNeighbors(String v) {
            return adjList.get(v);
        }

        public Set<String> getVertices() {
            return adjList.keySet();
        }

        /*
         * TODO: Implement BFS using a queue.
         * Return the order in which vertices are visited.
         */
        public ArrayList<String> bfs(String start) {
            return new ArrayList<>();
        }

        /*
         * TODO: Implement iterative DFS using a stack.
         * Return the order in which vertices are visited.
         */
        public ArrayList<String> dfs(String start) {
            return new ArrayList<>();
        }

        /*
         * TODO: Implement shortestPath using BFS.
         * Return the actual shortest path from start to destination
         * as a list of vertices, or an empty list if no path exists.
         */
        public ArrayList<String> shortestPath(String start, String destination) {
            return new ArrayList<>();
        }
    }

    /* =========================================================
     * Exercise 3 - Event Scheduler with AVL Tree
     * ========================================================= */
    static class AVLNode {
        String eventName;
        int startTime;
        int height;
        AVLNode left, right;

        public AVLNode(String eventName, int startTime) {
            this.eventName = eventName;
            this.startTime = startTime;
            this.height = 1;
        }
    }

    static class EventSchedulerAVL {
        private AVLNode root;

        private int height(AVLNode node) {
            return (node == null) ? 0 : node.height;
        }

        private int getBalance(AVLNode node) {
            return (node == null) ? 0 : height(node.left) - height(node.right);
        }

        private void updateHeight(AVLNode node) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }

        /*
         * TODO: Perform a right rotation and return the new root
         * of the rotated subtree.
         */
        private AVLNode rotateRight(AVLNode y) {
            return null;
        }

        /*
         * TODO: Perform a left rotation and return the new root
         * of the rotated subtree.
         */
        private AVLNode rotateLeft(AVLNode x) {
            return null;
        }

        public void addEvent(String eventName, int startTime) {
            root = insert(root, eventName, startTime);
        }

        /*
         * TODO: Insert a new event into the AVL tree.
         */
        private AVLNode insert(AVLNode node, String eventName, int startTime) {
            return null;
        }
    }

    /* =========================================================
     * Basic Testing Code
     * ========================================================= */

    private static void report(String testName, boolean passed) {
        if (passed) {
            System.out.println("[SUCCEEDED] " + testName);
        } else {
            System.out.println("[FAILED] " + testName);
        }
    }

    private static boolean safeEquals(Object a, Object b) {
        return Objects.equals(a, b);
    }

    private static boolean safeListEquals(List<String> a, List<String> b) {
        return Objects.equals(a, b);
    }

    /* ======================== Exercise 1 Tests ======================== */

    private static Path createHashtagFile() throws IOException {
        Path p = Files.createTempFile("hashtags", ".txt");
        List<String> lines = Arrays.asList(
                "#Loyola",
                "#CS",
                "#Loyola",
                "#Finals",
                "#CS",
                "#CS"
        );
        Files.write(p, lines);
        return p;
    }

    private static void testTrendingReport() {
        System.out.println("\n=== Basic Tests: Exercise 1 - Trending Hashtags Report ===");

        try {
            TrendingReport tr = new TrendingReport();

            tr.addTag("#CS");
            tr.addTag("#CS");
            tr.addTag("#Loyola");

            report("addTag / getFrequency basic repeated count",
                    tr.getFrequency("#CS") == 2);

            report("getFrequency returns 0 for missing hashtag",
                    tr.getFrequency("#Missing") == 0);

            Path p = createHashtagFile();
            tr = new TrendingReport();
            tr.loadFromFile(p.toString());

            report("loadFromFile reads file correctly",
                    tr.getFrequency("#CS") == 3 && tr.getFrequency("#Loyola") == 2);

            report("topKFrequent basic case",
                    safeListEquals(tr.topKFrequent(2), Arrays.asList("#CS", "#Loyola")));

            report("sortedReport basic case",
                    safeListEquals(tr.sortedReport(), Arrays.asList("#CS", "#Loyola", "#Finals")));

       
        /*
         * ADDITIONAL CASES YOU SHOULD ADD TESTS FOR:
         * - addTag(null)
         * - loadFromFile with empty file
         * - loadFromFile with blank lines / extra spaces
         * - case sensitivity (#AI vs #ai)
         * - topKFrequent with k <= 0
         * - topKFrequent with k larger than number of distinct hashtags
         * - ties in frequency broken alphabetically
         * - sortedReport on empty structure
         */

         // addTag with null
        tr = new TrendingReport();
        tr.addTag(null);
        report("addTag(null) handled gracefully",
                tr.getFrequency(null) == 0);

        // loadFromFile with empty file
        Path emptyFile = Files.createTempFile("empty", ".txt");
        tr = new TrendingReport();
        tr.loadFromFile(emptyFile.toString());
        report("loadFromFile with empty file",
                tr.sortedReport().isEmpty());

        // loadFromFile with blank lines and extra spaces
        Path blankLines = Files.createTempFile("blank", ".txt");
        Files.write(blankLines, Arrays.asList("#CS", "   ", "", "#Loyola"));
        tr = new TrendingReport();
        tr.loadFromFile(blankLines.toString());
        report("loadFromFile skips blank lines and extra spaces",
                tr.getFrequency("#CS") == 1 && tr.getFrequency("#Loyola") == 1);

        // case sensitivity
        tr = new TrendingReport();
        tr.addTag("#AI");
        tr.addTag("#ai");
        report("case sensitivity (#AI vs #ai are different)",
                tr.getFrequency("#AI") == 1 && tr.getFrequency("#ai") == 1);

        // topKFrequent with k larger than distinct hashtags
        tr = new TrendingReport();
        tr.addTag("#CS");
        tr.addTag("#Loyola");
        report("topKFrequent k larger than distinct hashtags",
                tr.topKFrequent(10).size() == 2);

        // topKFrequent with k = 0
        report("topKFrequent with k = 0",
                tr.topKFrequent(0).isEmpty());

        // ties broken alphabetically in sortedReport
        tr = new TrendingReport();
        tr.addTag("#Loyola");
        tr.addTag("#CS");
        report("sortedReport ties broken alphabetically",
                safeListEquals(tr.sortedReport(), Arrays.asList("#CS", "#Loyola")));

        // sortedReport on empty structure
        tr = new TrendingReport();
        report("sortedReport on empty structure",
                tr.sortedReport().isEmpty());

    } catch (IOException e) {
        report("TrendingReport file-based test", false);
    }
}

    /* ======================== Exercise 2 Tests ======================== */

    private static Graph buildSampleGraph() {
        Graph g = new Graph();
        for (String v : Arrays.asList("A", "B", "C", "D", "E", "F", "X", "Y")) {
            g.addVertex(v);
        }
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "E");
        g.addEdge("C", "F");
        g.addEdge("X", "Y");
        return g;
    }

    private static void testGraph() {
        System.out.println("\n=== Basic Tests: Exercise 2 - Graph ===");

        Graph g = buildSampleGraph();

        report("bfs basic traversal",
                safeListEquals(g.bfs("A"), Arrays.asList("A", "B", "C", "D", "E", "F")));

        report("dfs basic traversal",
                safeListEquals(g.dfs("A"), Arrays.asList("A", "B", "D", "E", "C", "F")));

        /*
         * ADDITIONAL CASES YOU SHOULD ADD TESTS FOR:
         * - bfs with missing start vertex
         * - dfs with missing start vertex
         * - shortestPath existing path
         * - shortestPath returns empty list when no path exists
         * - shortestPath when start == destination
         * - shortestPath when start is missing
         * - shortestPath when destination is missing
         * - shortestPath on graph with one vertex
         * - shortestPath where multiple paths exist
         * - traversal on disconnected graph
         * - traversal on graph containing a cycle
         */
    }

    /* ======================== Exercise 3 Tests ======================== */

    private static List<Integer> inorderTimes(AVLNode node, List<Integer> out) {
        if (node == null) {
            return out;
        }
        inorderTimes(node.left, out);
        out.add(node.startTime);
        inorderTimes(node.right, out);
        return out;
    }

    private static int actualHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(actualHeight(node.left), actualHeight(node.right));
    }

    private static boolean isAVLBalanced(AVLNode node) {
        if (node == null) {
            return true;
        }
        int balance = actualHeight(node.left) - actualHeight(node.right);
        return Math.abs(balance) <= 1
                && isAVLBalanced(node.left)
                && isAVLBalanced(node.right);
    }

    private static void testAVL() {
        System.out.println("\n=== Basic Tests: Exercise 3 - Event Scheduler with AVL Tree ===");

        EventSchedulerAVL scheduler = new EventSchedulerAVL();
        scheduler.addEvent("E30", 30);
        scheduler.addEvent("E20", 20);
        scheduler.addEvent("E10", 10);

        report("AVL remains balanced after simple insertion sequence",
                isAVLBalanced(scheduler.root));

        report("AVL inorder traversal remains sorted",
                safeEquals(inorderTimes(scheduler.root, new ArrayList<>()),
                           Arrays.asList(10, 20, 30)));

        /*
         * ADDITIONAL CASES YOU SHOULD ADD TESTS FOR:
         * - LL rotation case
         * - RR rotation case
         * - LR rotation case
         * - RL rotation case
         * - several insertions in mixed order
         * - duplicate start time updates existing node instead of adding another one
         * - stored heights are updated correctly
         * - tree remains balanced after every insertion
         * - insertion into empty tree
         */
    }

    /* ======================== Main ======================== */

    public static void main(String[] args) {
        System.out.println("FinalExam.java starter file");
        System.out.println("Basic tests only.");
        System.out.println("Students must add more tests of their own.");

        testTrendingReport();
        testGraph();
        testAVL();
    }
}
