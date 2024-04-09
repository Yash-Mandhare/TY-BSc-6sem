<!-- Write PHP scriptto read “book.xml” file into simpleXML object. Display attributes and elements . ( simple_xml_load_file() function ) -->

<?php
// Load the XML file into a SimpleXML object
$xml = simplexml_load_file('Q61book.xml');

// Check if loading the file was successful
if ($xml === false) {
    die('Failed to load XML file: ' . error_get_last()['message']);
}

// Display attributes and elements
echo "<h2>Attributes and Elements:</h2>";
echo "<ul>";

// Display attributes
foreach ($xml->attributes() as $key => $value) {
    echo "<li>Attribute: $key = $value</li>";
}

// Display elements
foreach ($xml->children() as $child) {
    echo "<li>Element: " . $child->getName() . " = " . $child . "</li>";
}

echo "</ul>";
?>
