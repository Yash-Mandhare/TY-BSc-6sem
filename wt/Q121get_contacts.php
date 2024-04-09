<?php
$contactFile = 'Q121contact.dat';
$contacts = array();

// Read contents of the contact.dat file
$lines = file($contactFile, FILE_IGNORE_NEW_LINES);

// Parse each line and store in an array
foreach ($lines as $line) {
    $fields = explode(',', $line);
    $contacts[] = array(
        'srno' => trim($fields[0]),
        'name' => trim($fields[1]),
        'residence_number' => trim($fields[2]),
        'mobile_number' => trim($fields[3]),
        'address' => trim($fields[4])
    );
}

// Convert array to JSON and output
echo json_encode($contacts);
?>
