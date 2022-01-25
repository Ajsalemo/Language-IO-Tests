<?php

$id = uniqid(rand());
$content = "This logfile is appended with id: " . $id . PHP_EOL;
$filename = "log-append.txt";
$directory = getenv("FILE_PATH") ? getenv("FILE_PATH") : "files";
$appendFile = fopen($directory . $filename, "a") or die("Error in opening or creating file");

if ($appendFile) {
    fwrite($appendFile, $content);
    fclose($appendFile);
    echo "Appending to log-append.txt";
} else {
    echo "Something went wrong - Error in opening or creating file";
}
