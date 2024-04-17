// Write a Java program to store city names and their STD codes using an appropriate collection and perform following operations:
// i. Add a new city and its code (No duplicates)
// ii. Remove a city from the collection
// iii. Search for a city name and display the code

import java.util.*;

public class slip4CityStdCodes {
    public static void main(String[] args) {
        // Create a HashMap to store city names and their STD codes
        Map<String, String> cityStdCodes = new HashMap<>();

        // i. Add a new city and its code (No duplicates)
        addCity(cityStdCodes, "New York", "212");
        addCity(cityStdCodes, "Los Angeles", "213");
        addCity(cityStdCodes, "Chicago", "312");
        addCity(cityStdCodes, "Houston", "713");

        // ii. Remove a city from the collection
        removeCity(cityStdCodes, "Chicago");

        // iii. Search for a city name and display the code
        searchCity(cityStdCodes, "Los Angeles");
        searchCity(cityStdCodes, "Chicago"); // This city is removed, so it should not be found
    }

    // Method to add a new city and its code
    public static void addCity(Map<String, String> cityStdCodes, String city, String stdCode) {
        if (!cityStdCodes.containsKey(city)) {
            cityStdCodes.put(city, stdCode);
            System.out.println("Added city: " + city + " (STD code: " + stdCode + ")");
        } else {
            System.out.println("City already exists: " + city);
        }
    }

    // Method to remove a city from the collection
    public static void removeCity(Map<String, String> cityStdCodes, String city) {
        if (cityStdCodes.containsKey(city)) {
            cityStdCodes.remove(city);
            System.out.println("Removed city: " + city);
        } else {
            System.out.println("City not found: " + city);
        }
    }

    // Method to search for a city and display its code
    public static void searchCity(Map<String, String> cityStdCodes, String city) {
        if (cityStdCodes.containsKey(city)) {
            System.out.println("STD code for " + city + ": " + cityStdCodes.get(city));
        } else {
            System.out.println("City not found: " + city);
        }
    }
}
