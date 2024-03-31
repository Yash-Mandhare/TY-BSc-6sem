// Write a java program to read ‘N’ names of your friends, store it into HashSet and display them in ascending order.

import java.util.*;

public class FriendNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of friends: ");
        int n = scanner.nextInt();

        Set<String> friendSet = new HashSet<>();

        // Read 'N' names of friends
        scanner.nextLine(); // Consume the newline character
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            String name = scanner.nextLine();
            friendSet.add(name);
        }

        // Display names in ascending order
        List<String> sortedFriends = new ArrayList<>(friendSet);
        Collections.sort(sortedFriends);
        System.out.println("\nNames of friends in ascending order:");
        for (String friend : sortedFriends) {
            System.out.println(friend);
        }

        scanner.close();
    }
}
