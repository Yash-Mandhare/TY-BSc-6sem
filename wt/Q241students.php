<!-- Write a PHP script to create student.xml file which contains student roll no, name, address, collegeand course. Print students detail of specific course in tabular format after accepting course as input. -->

<?php
// Sample student data
$students = array(
    array('rollno' => '101', 'name' => 'John Doe', 'address' => '123 Main St', 'college' => 'ABC College', 'course' => 'Engineering'),
    array('rollno' => '102', 'name' => 'Jane Smith', 'address' => '456 Elm St', 'college' => 'XYZ College', 'course' => 'Medicine'),
    array('rollno' => '103', 'name' => 'Alice Johnson', 'address' => '789 Oak St', 'college' => 'PQR College', 'course' => 'Business'),
    array('rollno' => '104', 'name' => 'Bob Williams', 'address' => '321 Pine St', 'college' => 'LMN College', 'course' => 'Engineering'),
    array('rollno' => '105', 'name' => 'Emma Brown', 'address' => '654 Cedar St', 'college' => 'JKL College', 'course' => 'Medicine')
);

// Function to create XML file
function createXMLFile($students) {
    $xml = new SimpleXMLElement('<students></students>');

    foreach ($students as $student) {
        $studentNode = $xml->addChild('student');
        $studentNode->addChild('rollno', $student['rollno']);
        $studentNode->addChild('name', $student['name']);
        $studentNode->addChild('address', $student['address']);
        $studentNode->addChild('college', $student['college']);
        $studentNode->addChild('course', $student['course']);
    }

    $xml->asXML('students.xml');
}

// Function to print students of specific course
function printStudentsByCourse($students, $course) {
    echo "<h2>Students Enrolled in $course</h2>";
    echo "<table border='1'><tr><th>Roll No</th><th>Name</th><th>Address</th><th>College</th><th>Course</th></tr>";

    foreach ($students as $student) {
        if ($student['course'] == $course) {
            echo "<tr>";
            echo "<td>{$student['rollno']}</td>";
            echo "<td>{$student['name']}</td>";
            echo "<td>{$student['address']}</td>";
            echo "<td>{$student['college']}</td>";
            echo "<td>{$student['course']}</td>";
            echo "</tr>";
        }
    }

    echo "</table>";
}

// Create XML file
createXMLFile($students);

// Accept course as input
$course = isset($_GET['course']) ? $_GET['course'] : '';

// Print students of specific course
if (!empty($course)) {
    printStudentsByCourse($students, $course);
}
?>
