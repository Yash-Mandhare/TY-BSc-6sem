<!-- Write a PHP script to accept Employee details (Eno, Ename, Address) on first page. On second page accept earning (Basic, DA, HRA). On third page print Employee information (Eno, Ename, Address,Basic, DA, HRA, Total) [ Use Session] -->
<?php
session_start();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $_SESSION['employee_details'] = $_POST;
    header("Location: Q41earnings.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
</head>
<body>
    <h2>Enter Employee Details</h2>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
        Employee Number: <input type="text" name="eno"><br>
        Employee Name: <input type="text" name="ename"><br>
        Address: <input type="text" name="address"><br>
        <input type="submit" value="Next">
    </form>
</body>
</html>
