<?php
// Database connection
$host = 'localhost';
$port = '5432';
$dbname = 'postgres';
$username = 'postgres';
$password = '6512';


try {
    $conn = new PDO("pgsql:host=$host;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Retrieve username and password from form
    $username = $_POST['username'];
    $password = $_POST['password'];

    // Prepare SQL query to check username and password
    $stmt = $conn->prepare("SELECT * FROM users WHERE username = :username AND password = :password");
    $stmt->bindParam(':username', $username);
    $stmt->bindParam(':password', $password);
    $stmt->execute();

    // Check if a row is returned
    if ($stmt->rowCount() > 0) {
        echo "Login successful!";
    } else {
        echo "Invalid username or password.";
    }
} catch(PDOException $e) {
    echo "Error: " . $e->getMessage();
}
?>
