import java.util.*;

public class Problem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for user input and initialize variables for Graph 1
        System.out.println("Program by: Vaughn Dylan Quinn R. Mangas");
        System.out.println("Enter the number of vertices for Graph 1:");
        int n1 = scanner.nextInt();
        int[][] graph1 = new int[n1][n1];

        // Prompt for adjacency matrix of Graph 1
        System.out.println("Enter the adjacency matrix for Graph 1:");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                graph1[i][j] = scanner.nextInt();
            }
        }

        // Prompt for user input and initialize variables for Graph 2
        System.out.println("Enter the number of vertices for Graph 2:");
        int n2 = scanner.nextInt();
        int[][] graph2 = new int[n2][n2];

        // Prompt for adjacency matrix of Graph 2
        System.out.println("Enter the adjacency matrix for Graph 2:");
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n2; j++) {
                graph2[i][j] = scanner.nextInt();
            }
        }

        if (isIsomorphic(graph1, graph2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }

        scanner.close();
    }

    // Method to check if two graphs are isomorphic
    public static boolean isIsomorphic(int[][] graph1, int[][] graph2) {
        int n1 = graph1.length;
        int n2 = graph2.length;

        if (n1 != n2) {
            return false;
        }

        // Check if both graphs have the same degree sequence
        int[] degreeSeq1 = new int[n1];
        int[] degreeSeq2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                degreeSeq1[i] += graph1[i][j];
                degreeSeq2[i] += graph2[i][j];
            }
        }

        Arrays.sort(degreeSeq1);
        Arrays.sort(degreeSeq2);

        // Compare degree sequences
        for (int i = 0; i < n1; i++) {
            if (degreeSeq1[i] != degreeSeq2[i]) {
                return false;
            }
        }

        return true; // If degree sequences match, graphs are isomorphic
    }
}





