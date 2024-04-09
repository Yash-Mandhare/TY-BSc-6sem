<?php
$name = strtoupper($_POST['name']);
$age = $_POST['age'];
$nationality = strtoupper($_POST['nationality']);
$response = "";

// Name validation: should be in upper case letters only
if (!ctype_upper($name)) {
  $response .= "Name should be in upper case letters only. ";
}

// Age validation: should be 18 years or older
if ($age < 18) {
  $response .= "Age should be 18 years or older. ";
}

// Nationality validation: should be Indian
if ($nationality !== "INDIAN") {
  $response .= "Nationality should be Indian. ";
}

// If there are no validation errors, save the voter details
if (empty($response)) {
  // Save voter details to database or perform other actions
  $response = "Voter registered successfully!";
}

echo $response;
?>
