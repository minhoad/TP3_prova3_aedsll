import java.util.ArrayList;
import java.util.Stack;

public class Heuristic {

    private int[][] adjacencyMatrix;
    private int size;
    MST mst = new MST();

    public Heuristic(int[][] adjacencyMatrix, int size) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.size = size;
    }

    private class MST {

        int parent[];
        int key[];

        /**
         * minKey func for MST Algorithm Source:
         * https://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
         *
         * @param key
         * @param mstSet
         * @return
         */
        private int minKey(int key[], Boolean mstSet[]) {
            // Initialize min value
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < size; v++) {
                if (mstSet[v] == false && key[v] < min) {
                    min = key[v];
                    min_index = v;
                }
            }

            return min_index;
        }
        // A utility function to print the constructed MST stored in
        // parent[]
        void printMST(int parent[], int n, int graph[][]) {
            System.out.println("Edge   Weight");
            for (int i = 1; i < size; i++) {
                System.out.println(parent[i] + " - " + i + "    "
                        + graph[i][parent[i]]);
            }
        }

        /**
         * primMST func for MST Algorithm Source:
         * https://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
         *
         * @param graph
         */
        private void primMST(int graph[][]) {
            // Array to store constructed MST
            parent = new int[size];

            // Key values used to pick minimum weight edge in cut
            key = new int[size];

            // To represent set of vertices not yet included in MST
            Boolean mstSet[] = new Boolean[size];

            // Initialize all keys as INFINITE
            for (int i = 0; i < size; i++) {
                key[i] = Integer.MAX_VALUE;
                mstSet[i] = false;
            }

            // Always include first 1st vertex in MST.
            key[0] = 0;     // Make key 0 so that this vertex is
            // picked as first vertex
            parent[0] = -1; // First node is always root of MST

            // The MST will have V vertices
            for (int count = 0; count < size - 1; count++) {
                // Pick thd minimum key vertex from the set of vertices
                // not yet included in MST
                int u = minKey(key, mstSet);

                // Add the picked vertex to the MST Set
                mstSet[u] = true;

                // Update key value and parent index of the adjacent
                // vertices of the picked vertex. Consider only those
                // vertices which are not yet included in MST
                for (int v = 0; v < size; v++) // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                {
                    if (graph[u][v] != 0 && mstSet[v] == false
                            && graph[u][v] < key[v]) {
                        parent[v] = u;
                        key[v] = graph[u][v];
                    }
                }
            }
        }
    }

    public void calculateHeuristic() {
        // First - calculate the AGM in the matrix
        this.mst.primMST(adjacencyMatrix);

        ArrayList<Integer> adjList[] = (ArrayList<Integer>[]) new ArrayList[size];
        int i;
        for (i = 0; i < size; i++) {
            if (adjList[i] == null) {
                adjList[i] = new ArrayList<>();
            }
            if (this.mst.parent[i] != -1) {
                adjList[i].add(this.mst.parent[i]);
                if (adjList[this.mst.parent[i]] == null) {
                    adjList[this.mst.parent[i]] = new ArrayList<>();
                }
                adjList[this.mst.parent[i]].add(i);
            }
        }
        
        int start = 1;
        
        // Find the first vertice that is a leaf
        for (i = 0; i < size; i++) {
            if (adjList[i].size() == 1) {
                start = i;
            }
        }

        // DFS in the tree
        boolean cityVisited[] = new boolean[size];

        int city = start;
        cityVisited[start] = true;
        int cost = 0;
        int citiesVisited = 1;
        
        Stack<Integer> way = new Stack();
        way.push(city);
        
        while (citiesVisited <= size) {
            boolean foundCity = false;
            for (int c : adjList[city]) {
                if (cityVisited[c]) {
                    continue;
                }
                citiesVisited++;
                cityVisited[c] = true;
                cost += adjacencyMatrix[city][c];
                city = c;
                foundCity = true;
                way.push(city);
            }
            if (!foundCity) {
                if (way.empty()) {
                    System.out.println("Final cities number: " + citiesVisited);
                    System.out.println("Final cost: " + cost);
                    break;
                }
                
                int backCity = way.pop();
                if (backCity == city) {
                    backCity = way.pop();
                }
                city = backCity;
            }
        }
    }
}