
<?php
$name = isset($_POST['name']) ? $_POST['name'] : '';

if (empty($name)) {
    echo "Stranger, please tell me your name!";
} elseif (in_array($name, array('Rohit', 'Virat', 'Dhoni', 'Ashwin', 'Harbhajan'))) {
    echo "Hello, master!";
} else {
    echo "I don't know you!";
}
?>
