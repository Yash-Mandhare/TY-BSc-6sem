<!-- Create XML file named “Item.xml”with item-name, item-rate, item quantity Store the details of 5Items of different Types -->

<?php
// Create a SimpleXML object
$xml = new SimpleXMLElement('<items></items>');

// Function to add an item to the XML
function addItem($xml, $name, $rate, $quantity) {
    $item = $xml->addChild('item');
    $item->addChild('item-name', $name);
    $item->addChild('item-rate', $rate);
    $item->addChild('item-quantity', $quantity);
}

// Add items to the XML
addItem($xml, 'Item 1', 10.99, 20);
addItem($xml, 'Item 2', 15.50, 15);
addItem($xml, 'Item 3', 8.75, 30);
addItem($xml, 'Item 4', 25.00, 10);
addItem($xml, 'Item 5', 12.25, 25);

// Save the XML to a file
$xml->asXML('Q51Item.xml');

echo "XML file created successfully!";
?>
