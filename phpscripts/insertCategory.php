<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){
require 'connection.php';
createCategory();
}

function createCategory()
{
global $connect;
$name  = $_POST["name"];

$query = "Insert into category(name) values ('$name');";
mysqli_query($connect, $query) or die (mysqli_error($connect));
mysqli_close($connect);
}

?>