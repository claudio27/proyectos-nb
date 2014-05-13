<?php
/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

require 'php/phplot.php';
$plot = new PHPlot();
$data = array(array('', 0, 0), array('', 1, 9));
$plot->SetDataValues($data);
$plot->SetDataType('data-data');
$plot->DrawGraph();

?>
