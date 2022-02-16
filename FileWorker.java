import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileWorker {
    public static int[][] extractAdjacencyMatrix(String fileName, int size, boolean lowerMatrix) {
        File file = new File(fileName);
        int[][] adjacencyMatrix = new int[size][size];
        
        try {
            Scanner scanner = new Scanner(file);      
            while (!scanner.next().equals("EDGE_WEIGHT_SECTION")) {
                // Skip file line
            }
            
            int i, j;
            for (i = 0; i < size; i++) {
                if(lowerMatrix) {                    
                    for (j = 0; j <= i; j++) {
                        adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = scanner.nextInt();
                    }                    
                } else {                    
                    for (j = i; j < size; j++) {
                        adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = scanner.nextInt();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Oops, erro ao abrir o arquivo '"+fileName+"'");
        }
        return adjacencyMatrix;
    }
}