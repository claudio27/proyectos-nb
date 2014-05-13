<?php

$con=mysql_connect("localhost","root","nube123");

mysql_select_db("lab2",$con);


$consulta = "(aqui pegar la consulta)";

$resp = mysql_query($consulta,$con ) or die(mysql_error());

echo "fin\n";





?>
