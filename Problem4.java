import java.util.*;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program by: Vaughn Dylan Quinn R. Mangas");
        System.out.print("Enter the number of edges: ");
        int edgeCount = scanner.nextInt();
        scanner.nextLine();

        // Create a map to store the degree of each vertex
        Map<String, Integer> degreeMap = new HashMap<>();

        System.out.println("Enter the edges (format: from to):");
        for (int i = 0; i < edgeCount; i++) {
            String from = scanner.next();
            String to = scanner.next();
            scanner.nextLine();

            degreeMap.put(from, degreeMap.getOrDefault(from, 0) + 1);
            degreeMap.put(to, degreeMap.getOrDefault(to, 0) + 1);
        }
        
        // Output the degree of each vertex
        for (Map.Entry<String, Integer> entry : degreeMap.entrySet()) {
            System.out.println("Degree of vertex " + entry.getKey() + ": " + entry.getValue());
        }
        
        scanner.close();
    }
}
