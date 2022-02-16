import java.util.Arrays;
public class Principal {
    public static void main(String[] args) { // código para mostrar o crescimento do tempo necessário para resolver por força bruta
        long start = System.currentTimeMillis();
        for (int i = 2; i < 11; i++) {
            Grafo grafo = new Grafo(i);
            if (i == 2) {
                grafo.addEdge(0, 1, 1);
                grafo.addEdge(1, 0, 6);
                BruteForce h = new BruteForce(grafo);
                System.out.println(Arrays.toString(h.rodaCaminhos()));
                long end = System.currentTimeMillis();
                System.out.println("Time: " + (end-start));
            }
            if (i == 3) {
                grafo.addEdge(0, 1, 1);
                grafo.addEdge(1, 2, 6);
                grafo.addEdge(2, 0, 2);
                BruteForce h = new BruteForce(grafo);
                System.out.println(Arrays.toString(h.rodaCaminhos()));
                long end = System.currentTimeMillis();
                System.out.println("Time: " + (end-start));

            }
            if (i == 4) {
                grafo.addEdge(0, 1, 1);
                grafo.addEdge(1, 2, 6);
                grafo.addEdge(2, 3, 2);
                grafo.addEdge(3, 0, 5);
                BruteForce h = new BruteForce(grafo);
                System.out.println(Arrays.toString(h.rodaCaminhos()));
                long end = System.currentTimeMillis();
                System.out.println("Time: " + (end-start));
            }
            if (i == 5) {
                grafo.addEdge(0, 1, 1);
                grafo.addEdge(1, 2, 6);
                grafo.addEdge(2, 3, 2);
                grafo.addEdge(3, 4, 5);
                grafo.addEdge(4, 0, 3);
                BruteForce h = new BruteForce(grafo);
                System.out.println(Arrays.toString(h.rodaCaminhos()));
                long end = System.currentTimeMillis();
                System.out.println("Time: " + (end-start));
            }
            if (i == 6) {
                grafo.addEdge(0, 1, 1);
                grafo.addEdge(1, 2, 6);
                grafo.addEdge(2, 3, 2);
                grafo.addEdge(3, 4, 5);
                grafo.addEdge(4, 5, 3);
                grafo.addEdge(5, 0, 7);
                BruteForce h = new BruteForce(grafo);
                System.out.println(Arrays.toString(h.rodaCaminhos()));
                long end = System.currentTimeMillis();
                System.out.println("Time: " + (end-start));
            }
            if (i == 7) {
                grafo.addEdge(0, 1, 1);
                grafo.addEdge(1, 2, 6);
                grafo.addEdge(2, 3, 2);
                grafo.addEdge(3, 4, 5);
                grafo.addEdge(4, 5, 3);
                grafo.addEdge(5, 6, 7);
                grafo.addEdge(6, 0, 2);
                BruteForce h = new BruteForce(grafo);
                System.out.println(Arrays.toString(h.rodaCaminhos()));
                long end = System.currentTimeMillis();
                System.out.println("Time: " + (end-start));
            }
            if (i == 8) {
                grafo.addEdge(0, 1, 1);
                grafo.addEdge(1, 2, 6);
                grafo.addEdge(2, 3, 2);
                grafo.addEdge(3, 4, 5);
                grafo.addEdge(4, 5, 3);
                grafo.addEdge(5, 6, 7);
                grafo.addEdge(6, 7, 2);
                grafo.addEdge(7, 0, 1);
                BruteForce h = new BruteForce(grafo);
                System.out.println(Arrays.toString(h.rodaCaminhos()));
                long end = System.currentTimeMillis();
                System.out.println("Time: " + (end-start));
            }
            if (i == 9) {
                grafo.addEdge(0, 1, 1);
                grafo.addEdge(1, 2, 6);
                grafo.addEdge(2, 3, 2);
                grafo.addEdge(3, 4, 5);
                grafo.addEdge(4, 5, 3);
                grafo.addEdge(5, 6, 7);
                grafo.addEdge(6, 7, 2);
                grafo.addEdge(7, 8, 1);
                grafo.addEdge(8, 0, 9);
                BruteForce h = new BruteForce(grafo);
                System.out.println(Arrays.toString(h.rodaCaminhos()));
                long end = System.currentTimeMillis();
                System.out.println("Time: " + (end-start));
            }
            if (i == 10) {
                grafo.addEdge(0, 1, 1);
                grafo.addEdge(1, 2, 6);
                grafo.addEdge(2, 3, 2);
                grafo.addEdge(3, 4, 5);
                grafo.addEdge(4, 5, 3);
                grafo.addEdge(5, 6, 7);
                grafo.addEdge(6, 7, 2);
                grafo.addEdge(7, 8, 1);
                grafo.addEdge(8, 9, 9);
                grafo.addEdge(9, 0, 4);
                BruteForce h = new BruteForce(grafo);
                System.out.println(Arrays.toString(h.rodaCaminhos()));
                long end = System.currentTimeMillis();
                System.out.println("Time: " + (end-start));
            }
        }
    /*public static void main(String[] args) { // código para mostrar a distância encontrada
        System.out.println("-- si1032.tsp -- ");
        int[][] testMatrix = FileWorker.extractAdjacencyMatrix("si1032.tsp", 1032, false);
        Heuristic heuristic = new Heuristic(testMatrix, 1032);
        heuristic.calculateHeuristic();
        
        System.out.println("");
        
        System.out.println("-- pa561.tsp -- ");
        testMatrix = FileWorker.extractAdjacencyMatrix("pa561.tsp", 561, true);
        heuristic = new Heuristic(testMatrix, 561);
        heuristic.calculateHeuristic();
        
        System.out.println("");
        
        System.out.println("-- si535.tsp -- ");
        testMatrix = FileWorker.extractAdjacencyMatrix("si535.tsp", 535, false);
        heuristic = new Heuristic(testMatrix, 535);
        heuristic.calculateHeuristic();
    */}
}