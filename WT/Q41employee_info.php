<?php
session_start();

// Get employee details and earnings from session
$employee_details = $_SESSION['employee_details'];
$earnings = $_SESSION['earnings'];

// Calculate total earnings
$total_earnings = $earnings['basic'] + $earnings['da'] + $earnings['hra'];

// Display employee information
echo "<h2>Employee Information</h2>";
echo "<p>Employee Number: " . $employee_details['eno'] . "</p>";
echo "<p>Employee Name: " . $employee_details['ename'] . "</p>";
echo "<p>Address: " . $employee_details['address'] . "</p>";
echo "<p>Basic: " . $earnings['basic'] . "</p>";
echo "<p>DA: " . $earnings['da'] . "</p>";
echo "<p>HRA: " . $earnings['hra'] . "</p>";
echo "<p>Total Earnings: " . $total_earnings . "</p>";

// Clear session variables
session_unset();
session_destroy();
?>
