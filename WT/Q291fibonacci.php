<!-- Write a PHP script for the following: Design a form to accept a number from the user.
Perform the operations and show the results.
1) Fibonacci Series.
2) To find sum of the digits of that number.
(Use the concept of self processing page.) -->

<!DOCTYPE html>
<html>
<head>
    <title>Number Operations</title>
</head>
<body>

<h2>Number Operations</h2>

<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
    Enter a number: <input type="number" name="number" required><br><br>
    <input type="submit" name="submit" value="Submit">
</form>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Function to generate Fibonacci series
    function fibonacci($n) {
        $fib = [];
        $fib[0] = 0;
        $fib[1] = 1;
        for ($i = 2; $i < $n; $i++) {
            $fib[$i] = $fib[$i - 1] + $fib[$i - 2];
        }
        return $fib;
    }

    // Function to find sum of digits
    function sumOfDigits($number) {
        $sum = 0;
        while ($number != 0) {
            $digit = $number % 10;
            $sum += $digit;
            $number = $number / 10;
        }
        return $sum;
    }

    $number = $_POST['number'];

    echo "<h3>Results:</h3>";
    echo "<p>Fibonacci Series: ";
    $fibonacciSeries = fibonacci($number);
    echo implode(", ", $fibonacciSeries);
    echo "</p>";

    echo "<p>Sum of Digits: ";
    $sum = sumOfDigits($number);
    echo $sum;
    echo "</p>";
}
?>

</body>
</html>

