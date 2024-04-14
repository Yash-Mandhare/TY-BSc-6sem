<!-- Write a PHP script to accept username and password. If in the first three chances, username and password entered is correctthen display second form with “Welcome message” otherwise display errormessage. [Use Session] -->


<?php
session_start();

// Define correct username and password
$correct_username = "admin";
$correct_password = "password";

// Check if the form has been submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Increment the attempt counter
    if (!isset($_SESSION['attempts'])) {
        $_SESSION['attempts'] = 1;
    } else {
        $_SESSION['attempts']++;
    }

    // Check if maximum attempts reached
    if ($_SESSION['attempts'] <= 3) {
        // Check if username and password are correct
        if ($_POST["username"] == $correct_username && $_POST["password"] == $correct_password) {
            // Successful login, store username in session
            $_SESSION['logged_in'] = true;
            $_SESSION['username'] = $_POST['username'];
            header("Location: Q31welcome.php");
            exit;
        } else {
            $error_message = "Invalid username or password. Please try again.";
        }
    } else {
        $error_message = "Maximum attempts reached. Please try again later.";
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <?php if (isset($error_message)) {
        echo "<p>$error_message</p>";
    } ?>

    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
