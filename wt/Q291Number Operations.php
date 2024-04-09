<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Number Operations</title>
</head>
<body>

<h2>Number Operations</h2>

<form method="post">
  Enter a number: <input type="number" name="number" required><br><br>
  <input type="submit" name="submit" value="Submit">
</form>

<?php
if (isset($_POST['submit'])) {
    // Retrieve the number from the form
    $number = $_POST['number'];

    // Perform operations
    $square = $number * $number;
    $cube = $number * $number * $number;
    $squareRoot = sqrt($number);
    $cubeRoot = pow($number, 1/3);

    // Display results
    echo "<h3>Results:</h3>";
    echo "Number: $number<br>";
    echo "Square: $square<br>";
    echo "Cube: $cube<br>";
    echo "Square Root: $squareRoot<br>";
    echo "Cube Root: $cubeRoot<br>";
}
?>

</body>
</html>
