<!-- Create TEACHER table as follows TEACHER(tno, tname, qualification, salary). Write Ajax program to select a teachers name and print the selected teachers details -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Teacher Details</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#teacherName").change(function() {
        var selectedTeacher = $(this).val();
        $.ajax({
            url: 'Q141get_teacher_details.php',
            method: 'POST',
            data: { teacherName: selectedTeacher },
            success: function(response) {
                $("#teacherDetails").html(response);
            }
        });
    });

    // Function to handle errors
    function handleError(xhr, status, error) {
        console.error(xhr.responseText);
        $("#teacherDetails").text("Error fetching teacher names. Please try again later.");
    }
});
</script>
</head>
<body>

<h2>Select Teacher:</h2>

<select id="teacherName">
    <option value="">Select Teacher</option>
    <!-- Populate the dropdown options dynamically -->
    <?php
    // Establish connection to the database
    $conn = pg_connect("host=localhost dbname=postgres user=postgres password=6512");

    // Check connection
    if (!$conn) {
        die("Connection failed: " . pg_last_error());
    }

    // Fetch teachers' names from the database
    $sql = "SELECT tname FROM TEACHER";
    $result = pg_query($conn, $sql);

    // Populate the dropdown options
    if ($result) {
        while($row = pg_fetch_assoc($result)) {
            echo "<option value='" . $row['tname'] . "'>" . $row['tname'] . "</option>";
        }
        pg_free_result($result);
    } else {
        echo "Error executing query: " . pg_last_error($conn);
    }

    // Close connection
    pg_close($conn);
    ?>
</select>

<div id="teacherDetails"></div>

</body>
</html>
