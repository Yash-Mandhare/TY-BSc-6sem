<?php
// Start the session
session_start();

// Check if cookies are set, if not use default values
$font_style = isset($_COOKIE['font_style']) ? $_COOKIE['font_style'] : 'Arial';
$font_size = isset($_COOKIE['font_size']) ? $_COOKIE['font_size'] : '16px';
$font_color = isset($_COOKIE['font_color']) ? $_COOKIE['font_color'] : '#000000';
$bg_color = isset($_COOKIE['bg_color']) ? $_COOKIE['bg_color'] : '#ffffff';
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Page with Preferences</title>
    <style>
        body {
            font-family: <?php echo $font_style; ?>;
            font-size: <?php echo $font_size; ?>;
            color: <?php echo $font_color; ?>;
            background-color: <?php echo $bg_color; ?>;
        }
    </style>
</head>
<body>
    <h2>Your Preferences</h2>
    <p>Font Style: <?php echo $font_style; ?></p>
    <p>Font Size: <?php echo $font_size; ?></p>
    <p>Font Color: <span style="color:<?php echo $font_color; ?>"><?php echo $font_color; ?></span></p>
    <p>Background Color: <span style="background-color:<?php echo $bg_color; ?>"><?php echo $bg_color; ?></span></p>
</body>
</html>
