<!-- Write a PHP script to keep track of number of times the web page has been accessed (Use SessionTracking). -->

<?php

session_start();

if (!isset($_SESSION['page_counter'])) {
    
    $_SESSION['page_counter'] = 1;
} else {
    
    $_SESSION['page_counter']++;
}

echo "Page accessed ".$_SESSION['page_counter']." times.";

session_write_close();
?>
