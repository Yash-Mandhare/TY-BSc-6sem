// Write a java program to create a TreeSet, add some colors (String) and print out the content of TreeSet in ascending order.

import java.util.TreeSet;

public class slip16TreeSetExample {
    public static void main(String[] args) {
        // Create a TreeSet to store colors
        TreeSet<String> colorsSet = new TreeSet<>();

        // Add colors to the TreeSet
        colorsSet.add("Red");
        colorsSet.add("Blue");
        colorsSet.add("Green");
        colorsSet.add("Yellow");
        colorsSet.add("Orange");

        // Print the TreeSet in ascending order
        System.out.println("Colors in ascending order:");
        for (String color : colorsSet) {
            System.out.println(color);
        }
    }
}
