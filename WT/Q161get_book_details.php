<?php
$selectedBook = $_POST['selectedBook'];

// Load the XML file
$xml = simplexml_load_file('Q161books.xml');

// Find the selected book in the XML data
$book = $xml->xpath("//book[title='$selectedBook']");

// Display book details
if ($book) {
    $title = $book[0]->title;
    $author = $book[0]->author;
    $year = $book[0]->year;
    $price = $book[0]->price;
    echo "<h2>Book Details:</h2>";
    echo "<p>Title: $title</p>";
    echo "<p>Author: $author</p>";
    echo "<p>Year: $year</p>";
    echo "<p>Price: $price</p>";
} else {
    echo "Book details not found.";
}
?>
