<?php
session_start();

// Check if user is logged in
if (!isset($_SESSION['logged_in']) || $_SESSION['logged_in'] !== true) {
    header("Location: Q31login.php");
    exit;
}

// Display welcome message
echo "Welcome, " . $_SESSION["username"] . "!";
?>
