<?php
/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
echo "hola claudio como estas\n";


function suma($a,$b){

    $c = $a + $b;
    echo $c ."\n";

}

suma(2,3);

function factorial($a){

    if($a == 0){ return 1;}
 else {
        return $a * factorial($a - 1);
    }



}



class claudio{



    function exp($a,$b){

    if($b == 0){return 1;}
    else{


        return $a * exp($a,$b - 1);

    }

}

}

$cla = new claudio();
$c = $cla->exp($a, $b);



$cads ="fadf";
echo  factorial(1000)."\n";
echo exp(2,0)."\n";


?>
