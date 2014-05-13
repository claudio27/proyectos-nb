<?php


function RandomString($length=10,$uc=TRUE,$n=TRUE,$sc=FALSE)
{
    $source = 'abcdefghijklmnopqrstuvwxyz';
    if($uc==1) $source .= 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    if($n==1) $source .= '1234567890';
    if($sc==1) $source .= '|@#~$%()=^*+[]{}-_';
    if($length>0){
        $rstr = "";
        $source = str_split($source,1);
        for($i=1; $i<=$length; $i++){
            mt_srand((double)microtime() * 1000000);
            $num = mt_rand(1,count($source));
            $rstr .= $source[$num-1];
        }
 
    }
    return $rstr;
}



//echo RandomString(15,TRUE,TRUE,0)."\n";

function creaConsultas($tam){


for($i=0; $i < $tam ; $i++){

$str1 = RandomString(5,TRUE,TRUE,0);
$str2 = RandomString(5,TRUE,TRUE,0);

//$consulta1 = "insert into persona values(".$i.",'".$str1."','".$str2."');";
//echo $consulta1."\n";


//$consulta2 = "insert into auto values(".$i.",'".$str1."','".$str2."');";
//echo $consulta2."\n";

//$consulta = "insert into persona(nombre,apellido) values('$str1','$str2');";
//echo $consulta."\n";


$consulta = "insert into auto(marca,modelo) values('$str1','$str2');";
echo $consulta."\n";


}

}


echo creaConsultas(500000);

?>
