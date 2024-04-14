<!-- Write a PHP script to create student.xml file which contains student roll no, name, address, collegeand course. Print students detail of specific course in tabular format after accepting course as input. -->

<?php
// Create a SimpleXML object
$xml = new SimpleXMLElement('<students></students>');

// Function to add a student to the XML
function addStudent($xml, $roll_no, $name, $address, $college, $course) {
    $student = $xml->addChild('student');
    $student->addChild('roll_no', $roll_no);
    $student->addChild('name', $name);
    $student->addChild('address', $address);
    $student->addChild('college', $college);
    $student->addChild('course', $course);
}

// Add students to the XML
addStudent($xml, '101', 'John Doe', '123 Main St', 'ABC College', 'Engineering');
addStudent($xml, '102', 'Jane Smith', '456 Oak Ave', 'XYZ College', 'Medicine');
addStudent($xml, '103', 'Alice Johnson', '789 Elm Blvd', 'PQR College', 'Engineering');
addStudent($xml, '104', 'Bob Johnson', '789 Elm Blvd', 'PQR College', 'Medicine');
// Add more students as needed

// Save the XML to a file
$xml->asXML('student.xml');

echo "XML file created successfully!";
?>

<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>

<form method="get">
    <label for="course">Enter Course:</label>
    <input type="text" id="course" name="course">
    <input type="submit" value="Submit">
</form>

<?php
// Check if course input is provided
if (isset($_GET['course'])) {
    $course = $_GET['course'];

    // Load the student.xml file
    $xml = simplexml_load_file('student.xml');

    // Print student details of specific course in tabular format
    echo '<h2>Students Details for Course: ' . $course . '</h2>';
    echo '<table border="1">';
    echo '<tr><th>Roll No</th><th>Name</th><th>Address</th><th>College</th><th>Course</th></tr>';
    foreach ($xml->student as $student) {
        if ($student->course == $course) {
            echo '<tr>';
            echo '<td>' . $student->roll_no . '</td>';
            echo '<td>' . $student->name . '</td>';
            echo '<td>' . $student->address . '</td>';
            echo '<td>' . $student->college . '</td>';
            echo '<td>' . $student->course . '</td>';
            echo '</tr>';
        }
    }
    echo '</table>';
} elseif (isset($_GET['course']) && $_GET['course'] == "") {
    echo "Please provide a course.";
}
?>

</body>
</html>
