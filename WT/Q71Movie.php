<!-- Write a PHP script to read “Movie.xml” file and print all MovieTitle and ActorName of file usingDOMDocument Parser. “Movie.xml” file should contain following information with at least 5 recordswith values. MovieInfoMovieNo, MovieTitle, ActorName ,ReleaseYear  -->

<?php
// Load the XML file
$xml = simplexml_load_file('Q71Movie.xml');

// Check if XML is loaded successfully
if ($xml === false) {
    exit('Failed to load XML file.');
}

// Print movie titles and actor names
echo "<h2>Movie Titles and Actor Names:</h2>";
foreach ($xml->MovieInfo as $movieInfo) {
    $movieTitle = $movieInfo->MovieTitle;
    $actorName = $movieInfo->ActorName;
    echo "<p>Movie Title: $movieTitle, Actor Name: $actorName</p>";
}
?>

