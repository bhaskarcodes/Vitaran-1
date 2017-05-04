<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){
require 'connection.php';
createItems();
}

function createItems()
{
global $connect;
$name  = $_POST["Name"];
    $quant = $_POST["Quantity"];
    $unit = $_POST["Unit"];

$query = "Insert into items(Name,Quantity,Unit) values ('$name','$quant','$unit');";
mysqli_query($connect, $query) or die (mysqli_error($connect));
mysqli_close($connect);
}

?>