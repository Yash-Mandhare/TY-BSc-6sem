<?php
// PostgreSQL database connection parameters
$host = 'localhost';
$port = '5432';
$dbname = 'postgres';
$user = 'postgres';
$password = '6512';

// Connect to PostgreSQL database
$conn = pg_connect("host=$host port=$port dbname=$dbname user=$user password=$password");

// Check connection
if (!$conn) {
    echo "Failed to connect to PostgreSQL database!";
    exit;
}

// Retrieve selected teacher's details from the database
$teacherName = pg_escape_string($_POST['teacherName']);
$query = "SELECT * FROM TEACHER WHERE tname = '$teacherName'";
$result = pg_query($conn, $query);

// Display selected teacher's details
if ($result) {
    if (pg_num_rows($result) > 0) {
        $row = pg_fetch_assoc($result);
        echo "<h2>Teacher Details:</h2>";
        echo "<p>Teacher Number: " . $row['tno'] . "</p>";
        echo "<p>Name: " . $row['tname'] . "</p>";
        echo "<p>Qualification: " . $row['qualification'] . "</p>";
        echo "<p>Salary: " . $row['salary'] . "</p>";
    } else {
        echo "Teacher details not found!";
    }
} else {
    echo "Error executing query: " . pg_last_error($conn);
}

// Close connection
pg_close($conn);
?>

