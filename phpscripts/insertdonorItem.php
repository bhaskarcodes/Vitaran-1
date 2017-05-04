<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){
require 'connection.php';
insertdonorItem();
}

function insertdonorItem()
{
global $connect;
$name  = $_POST["name"];
$category = $_POST["category"];
$quantity = $_POST["quantity"];
$unit = $_POST["unit"];

$query = "Insert into donoritem(name,category,quantity,unit) values ('$name','$category','$quantity','$unit');";
mysqli_query($connect, $query) or die (mysqli_error($connect));
mysqli_close($connect);
}

?>