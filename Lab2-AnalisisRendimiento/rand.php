<?php


function consultaDueno($tam)
{


for($i=0; $i < $tam ; $i++){
// aleatorio entre 1 y 1000000
$num1 = rand(1,1000);
$num2 = rand(1,1000000);

$consulta = "insert into dueno values($num1,$num2);";

echo $consulta."\n";
}

}

echo consultaDueno(500000);




?>
