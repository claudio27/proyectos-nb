<form action="ejephp.php" method="post">
 <p>Su nombre: <input type="text" name="nombre" /></p>
 <p>Su edad: <input type="text" name="edad" /></p>
 <p><input type="submit" /></p>
</form>
<?php



date_default_timezone_set('America/Santiago');

$timestamp = date('Y-m-d H:i:s');

$today = date("F j, Y, g:i a");
$new = htmlspecialchars("<a href='test'>Test</a>");
$dos = "<a href='test'>Test</a>";

//echo "EL timestamp es : ".$timestamp. " otra forma ". $today;
echo $new.$dos;





?>

Hola <?php echo htmlspecialchars($_POST['nombre']); ?>.
Usted tiene <?php echo (int)$_POST['edad']; ?> años de edad.
