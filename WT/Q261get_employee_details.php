<?php
$host = 'localhost';
$port = '5432';
$dbname = 'postgres';
$user = 'postgres';
$password = '6512';

// Connect to PostgreSQL database
$conn = pg_connect("host=$host port=$port dbname=$dbname user=$user password=$password");

// Fetch employee details based on selected name
$ename = $_GET['ename'];
$sql = "SELECT * FROM EMP WHERE ename='$ename'";
$result = pg_query($conn, $sql);

// Display employee details
if ($row = pg_fetch_assoc($result)) {
  echo '<h2>Employee Details:</h2>';
  echo '<p>Employee Number: ' . $row['eno'] . '</p>';
  echo '<p>Name: ' . $row['ename'] . '</p>';
  echo '<p>Designation: ' . $row['designation'] . '</p>';
  echo '<p>Salary: $' . $row['salary'] . '</p>';
} else {
  echo 'No details found for selected employee.';
}
?>
