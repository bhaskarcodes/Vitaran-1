<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){
require 'connection.php';
insertdonation();
}

function insertdonation()
{
global $connect;
$date = $_POST["Date"];
$donorID = $_POST["DonorID"];
$itemID  = $_POST["ItemID"];
$categoryID = $_POST["CategoryID"];
$details = $_POST["Details"];
$location = $_POST["Location"];

$query = "Insert into donation(date,donorID,location,itemID,details,categoryID) values ('$Date','$DonorID','$Location','$ItemID','$Details','$CategoryID');";
mysqli_query($connect, $query) or die (mysqli_error($connect));
mysqli_close($connect);
}

?>