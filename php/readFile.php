<?php

$filename = "log-append.txt";
$directory = getenv("FILE_PATH") ? getenv("FILE_PATH") : "files";
$fileToRead = $directory . "/" . $filename or die("Error in opening or creating file");

if (file_exists($fileToRead)) {
    readfile($fileToRead);
    exit;
} else {
    echo "Something went wrong - Error in opening or creating file";
}
