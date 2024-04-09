<?php
// Database connection
$host = 'localhost';
$port = '5432';
$dbname = 'postgres';
$user = 'postgres';
$password = '6512';

// Connect to PostgreSQL database
$conn = pg_connect("host=$host port=$port dbname=$dbname user=$user password=$password");


// Fetch employee names
$sql = "SELECT ename FROM EMP";
$result = pg_query($conn, $sql);

// Generate dropdown options
$options = '<option value="">Select Employee</option>';
while ($row = pg_fetch_assoc($result)) {
  $options .= '<option value="'.$row['ename'].'">'.$row['ename'].'</option>';
}

echo $options;
?>
