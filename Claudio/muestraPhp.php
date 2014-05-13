<!DOCTYPE html>
<html lang="en">
<head>

	<meta charset="utf-8"/>
	<title>Claudio Serrano| Muestra PHP y MYSQL</title>

	<!-- Mobile viewport optimisation -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- (en) Add your meta data here -->
	<!-- (de) Fuegen Sie hier ihre Meta-Daten ein -->

	<link href="./css/flexible-columns.css" rel="stylesheet" type="text/css"/>
         <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
	<!--[if lte IE 7]>
	<link href="./css/core/iehacks.css" rel="stylesheet" type="text/css" />
	<![endif]-->

	<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>
<body class="demo-2col">
<ul class="ym-skiplinks">
	<li><a class="ym-skip" href="#nav">Saltarse al contenido principal (Enter)</a></li>
	<li><a class="ym-skip" href="#main">Saltarse al contenido principal (Enter)</a></li>
</ul>

<div class="ym-wrapper">
	<div class="ym-wbox">
		<header>
			<h1>Muestra PHP y MYSQL</h1>
		</header>
		<nav id="nav">
			<div class="ym-hlist" >
				<ul>
					<li><a href="index.html">HOME</a></li>
					<li class="active"><strong>PHP Y MYSQL</strong></li>
					<li><a href="java.php">JAVA APPLET</a></li>
					<li><a href="galeria.html">GALERIA</a></li>
					<li><a href="webForm.php">GRAFICOS PHPLOT</a></li>
				</ul>
				<form class="ym-searchform">
					<a href="curriculum.html"target="_blank" onclick="window.open(this.href, this.target,'width=800,height=600'); return false;">CURRICULUM</a>
				</form>
			</div>
		</nav>
		<div id="main">
			<div class="ym-column linearize-level-1">
				<div class="ym-col1">
					<div class="ym-cbox">

 

       <?php
       //insertar en base de datos
       //luego imprimir base de datos con nueva informacion
           
       
       $con = mysql_connect("localhost","root","nube123");
if (!$con)
  {
  die('No pudo conectar: ' . mysql_error());
  }

mysql_select_db("muestra", $con);



$name= @htmlspecialchars($_POST['nombre']);
$lastname = @htmlspecialchars($_POST['apellido']);
$phone = @htmlspecialchars($_POST['telefono']);

$sql="INSERT INTO persona (nombre, apellido, telefono,personacol)
VALUES
('$name','$lastname','$phone',CURRENT_TIMESTAMP)";

if($name <> ""){
if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  }
  //aca deberia imprimir la tabla de la base de datos
echo "1 Fila agregada";}
$result = mysql_query("select nombre, apellido, telefono from persona order by personacol desc limit 5");

echo "  <table class='bordertable'>
<tr>
<th>Nombre</th>
<th>Apellido</th>
<th>Telefono</th>
</tr>";

while($row = mysql_fetch_array($result))
  {
  echo "<tr>";
  echo "<td>" . $row['nombre'] . "</td>";
  echo "<td>" . $row['apellido'] . "</td>";
  echo "<td>" . $row['telefono'] . "</td>";
  echo "</tr>";
  }
echo "</table>";


mysql_close($con);
       ?>
 
    

   <form class="ym-form" action="muestraPhp.php" method="post">

  <div class="ym-fbox-text">
  <label for="your-id">Nombre</label>
  <input type="text" name="nombre" id="nombre" size="20" />
</div>
  <div class="ym-fbox-text">
  <label for="your-id">Apellido</label>
  <input type="text" name="apellido" id="apellido" size="20" />
</div>
  <div class="ym-fbox-text">
  <label for="your-id">Telefono</label>
  <input type="text" name="telefono" id="telefono" size="20" />
</div>
<div class="ym-fbox-button">
  <input type="submit" class="ym-button" value="Enviar" id="submit" name="submit" />
  <input type="reset" class="ym-button" value="Borrar" id="reset" name="reset" />
 </div>


                                            </form>

					</div>
				</div>
				<aside class="ym-col3">
					<div class="ym-cbox">
						
		</div>
				</aside>
			</div>
		</div>
		<footer>
			<p>© Claudio Serrano, Santiago 2012. |<a href="mailto:claudio.serrano@alumnos.ucentral.cl">claudio.serrano@alumnos.ucentral.cl</a> | Cel: 90958345</p>
		</footer>
	</div>
</div>

<!-- full skip link functionality in webkit browsers -->
<script src="./js/yaml-focusfix.js"></script>
</body>
</html>
