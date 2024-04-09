<?php
// Start the session
session_start();

// Store preferences in session
$_SESSION['font_style'] = $_POST['font_style'];
$_SESSION['font_size'] = $_POST['font_size'];
$_SESSION['font_color'] = $_POST['font_color'];
$_SESSION['bg_color'] = $_POST['bg_color'];

// Set preferences as cookies
setcookie('font_style', $_SESSION['font_style'], time() + (86400 * 30), "/");
setcookie('font_size', $_SESSION['font_size'], time() + (86400 * 30), "/");
setcookie('font_color', $_SESSION['font_color'], time() + (86400 * 30), "/");
setcookie('bg_color', $_SESSION['bg_color'], time() + (86400 * 30), "/");

// Redirect to display page
header("Location: Q21implementation.php");
exit;
?>
