import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program by: Vaughn Dylan Quinn R. Mangas");
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        // Create adjacency matrix based on user input
        int[][] adjacencyMatrix = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Display the list of edges and their counts
        System.out.println("List of Edges and their Number of times appearing:");
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    char startVertex = (char) ('a' + i);
                    char endVertex = (char) ('a' + j);
                    int edgeCount = adjacencyMatrix[i][j];
                    System.out.println("Edge " + startVertex + "-" + endVertex + ": " + edgeCount + " times");
                }
            }
        }
        scanner.close();
    }
}