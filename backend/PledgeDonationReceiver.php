<?php
	$DB_USER="test";
	$DB_PASS="test";
	DB_HOST="localhost";
	$DB_NAME="vitaran";
	$mysqli=new mysqli($DB_HOST,$DB_USER,$DB_PASS,$DB_NAME);
	if(mysqli_connect_error()){
	printf("Connection Failed : %s\n",,mysqli_connect_error());
	exit();
	}
	$mysqli->query("SET NAMES 'utf8'");
	$sql="SELECT name FROM items";
	$result = $mysqli->query($sql);
	while($e=mysqli_fetch_assoc($result)){
		$output[]=$e;
	}
	print(json_encode($output));
	$mysqli->close();
?>
