// Write a Java Program to create the hash table that will maintain the mobile number and student name. Display the details of student using Enumeration interface

import java.util.*;

public class StudentDetails {
    public static void main(String[] args) {
        // Create a Hashtable to maintain mobile numbers and student names
        Hashtable<String, String> studentDetails = new Hashtable<>();

        // Add student details to the Hashtable
        studentDetails.put("9876543210", "John Doe");
        studentDetails.put("1234567890", "Jane Smith");
        studentDetails.put("4567891230", "Alice Johnson");

        // Display the details of students using Enumeration interface
        System.out.println("Details of Students:");
        Enumeration<String> mobileNumbers = studentDetails.keys();
        while (mobileNumbers.hasMoreElements()) {
            String mobileNumber = mobileNumbers.nextElement();
            String studentName = studentDetails.get(mobileNumber);
            System.out.println("Mobile Number: " + mobileNumber + ", Student Name: " + studentName);
        }
    }
}
