import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Program by: Vaughn Dylan Quinn R. Mangas");
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        
        // Create the incidence matrix
        int[][] incidenceMatrix = new int[vertices][edges];
        
        // Input edge information
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter edge " + (i + 1) + " information (vertex1 vertex2 frequency):");
            String vertex1 = scanner.next();
            String vertex2 = scanner.next();
            int frequency = scanner.nextInt();
            
            int index1 = vertexToIndex(vertex1);
            int index2 = vertexToIndex(vertex2);
            
            incidenceMatrix[index1][i] += frequency;
            incidenceMatrix[index2][i] += frequency;
        }
        
        // Print the incidence matrix
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < edges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }

    // Convert vertex letter to matrix index
    public static int vertexToIndex(String vertex) {
        return vertex.toUpperCase().charAt(0) - 'A';
    }
}




