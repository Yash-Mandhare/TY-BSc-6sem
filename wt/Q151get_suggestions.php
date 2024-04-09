<?php
// Array of suggestions
$suggestions = array(
    "apple",
    "banana",
    "cherry",
    "grape",
    "kiwi",
    "orange",
    "peach",
    "pear",
    "pineapple",
    "strawberry"
);

// Get input from POST request
$input = $_POST['input'];

// Filter suggestions based on input
$filteredSuggestions = array_filter($suggestions, function($value) use ($input) {
    return stripos($value, $input) !== false;
});

// Output suggestions
if (!empty($filteredSuggestions)) {
    echo "<ul>";
    foreach ($filteredSuggestions as $suggestion) {
        echo "<li>" . $suggestion . "</li>";
    }
    echo "</ul>";
} else {
    echo "No suggestions found.";
}
?>
