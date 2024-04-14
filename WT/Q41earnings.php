

<?php
session_start();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $_SESSION['earnings'] = $_POST;
    header("Location: Q41employee_info.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Earnings</title>
</head>
<body>
    <h2>Enter Earnings</h2>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
        Basic: <input type="text" name="basic"><br>
        DA: <input type="text" name="da"><br>
        HRA: <input type="text" name="hra"><br>
        <input type="submit" value="Next">
    </form>
</body>
</html>
