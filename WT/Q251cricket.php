<!-- Write a script to create “cricket.xml” file with multiple elements as shown below: <CricketTeam><Team country=”Australia”> <player>____</player><runs>______</runs><wicket>____</wicket></Team></CricketTeam>Write a script to add multiple elements in “cricket.xml” file of category, country=”India”. -->

<?php
// Function to create or append elements to cricket.xml
function updateCricketXML($teamData) {
    $xml = new SimpleXMLElement('<CricketTeam></CricketTeam>');

    // Load existing cricket.xml file if it exists
    if (file_exists('cricket.xml')) {
        $xml = simplexml_load_file('cricket.xml');
    }

    foreach ($teamData as $team) {
        $teamNode = $xml->addChild('Team');
        $teamNode->addAttribute('country', $team['country']);
        $teamNode->addChild('player', $team['player']);
        $teamNode->addChild('runs', $team['runs']);
        $teamNode->addChild('wicket', $team['wicket']);
    }

    $xml->asXML('cricket.xml');
}

// Data for new team elements
$newTeamData = array(
    array('country' => 'India', 'player' => 'Virat Kohli', 'runs' => '11000', 'wicket' => '20'),
    array('country' => 'India', 'player' => 'Rohit Sharma', 'runs' => '9000', 'wicket' => '10')
);

// Update cricket.xml with new team elements
updateCricketXML($newTeamData);

echo "Elements added successfully to cricket.xml";
?>
