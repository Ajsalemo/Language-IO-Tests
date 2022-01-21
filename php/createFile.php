<?php

$id = uniqid(rand());
$content = "This is a log file written with id: " . $id;
$filename = "log-" . $id . ".txt";
$randomFile = fopen("./files/" . $filename, "w") or die("Error in opening or creating file");

if ($randomFile) {
    fwrite($randomFile, $content);
    fclose($randomFile);
    echo "Creating log file with id: " . $id;
} else {
    echo "Something went wrong - Error in opening or creating file";
}
