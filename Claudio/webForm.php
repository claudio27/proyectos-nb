<?php

/* PHPlot web form example
Parameter names and parameter array keys:
'deposit' = Amount deposited per month.
'intrate' = Interest rate as a percentage (e.g. 4 means 4% or 0.04)
*/
# Name of script which generates the actual plot:
define('GRAPH_SCRIPT', 'webform_img.php');
# Image size. It isn't really necessary that this script know this image
# size, but it improves page rendering.
define('GRAPH_WIDTH', 600);
define('GRAPH_HEIGHT', 400);
# Default values for the form parameters:
$param = array('deposit' => 100.00, 'intrate' => 4.0);

# Build a URL with escaped parameters:
#   $url - The part of the URL up through the script name
#   $param - Associative array of parameter names and values
# Returns a URL with parameters. Note this must be HTML-escaped if it is
# used e.g. as an href value. (The & between parameters is not pre-escaped.)

function build_url($url, $param)
{
$sep = '?'; // Separator between URL script name and first parameter
foreach ($param as $name => $value) {
$url .= $sep . urlencode($name) . '=' . urlencode($value);
$sep = '&';
// Separator between subsequent parameters
}
return $url;
}

# Output the start of the HTML page:
function begin_page($title)
{
echo <<<END
<!DOCTYPE html>
<html lang="en">
<head>

	<meta charset="utf-8"/>
	<title>Claudio Serrano| $title</title>

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
			<h1>$title</h1>
		</header>
		<nav id="nav">
			<div class="ym-hlist" >
				<ul>
					<li><a href="index.html">HOME</a></li>
					<li><a href="muestraPhp.php">PHP Y MYSQL</li>
					<li><a href="java.php">JAVA APPLET</a></li>
					<li><a href="galeria.html">GALERIA</a></li>
					<li class="active"><a href="webForm.php">GRAFICOS PHPLOT</a></li>
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
END;
}

# Output the bottom of the HTML page:
function end_page()
{
echo <<<END
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

END;
}

# Output text which describes the form.
function show_descriptive_text()
{
echo <<<END
<p>
Esta página calcula el balance en el tiempo de un ahorro, que genera intereses
para la cuenta cuando ajusta los depósitos mensuales correspondientes al mes y no hay retiros.
</p>
<p>
Rellene los valores siguientes y haga click en el botón para mostrar una
gráfica del balance de la cuenta a través del tiempo.
</p>
END;
}

# Output the web form.
# The form resubmits to this same script for processing.
# The $param array contains default values for the form.
# The values have already been validated as containing numbers and
# do not need escaping for HTML.
function show_form($param)
{
$action = htmlspecialchars($_SERVER['SCRIPT_NAME']);
echo <<<END
<form name="f1" id="f1" method="get" action="$action">
<table cellpadding="5" summary="Entry form for balance calculation">
<tr>
<td align="right"><label for="deposit">Cantidad Mensual deposito:</label></td>
<td><input type="text" size="10" name="deposit" id="deposit"
value="{$param['deposit']}">
</tr>
<tr>
<td align="right"><label for="intrate">Razon del Interes:</label></td>
<td><input type="text" size="10" name="intrate" id="intrate"
value="{$param['intrate']}">%
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Mostrar Gr&aacute;fico"></td>
</tr>
</table>
</form>
END;
}

# Check for parameters supplied to this web page.
# If there are valid parameters, store them in the array argument and
# return True.
# If there are no parameters, or the parameters are not valid, return False.
function check_form_params(&$param)
{
$valid = True;
if (empty($_GET['deposit']) || !is_numeric($_GET['deposit'])
|| ($deposit = floatval($_GET['deposit'])) < 0)
$valid = False;
if (empty($_GET['intrate']) || !is_numeric($_GET['intrate'])
|| ($intrate = floatval($_GET['intrate'])) < 0 || $intrate > 100)
$valid = False;
if ($valid) $param = compact('deposit', 'intrate');
return $valid;
}

# Display a graph.
# The param array contains the validated values: deposit and intrate.
# This function creates the portion of the page that contains the
# graph, but the actual graph is generated by the $GRAPH_SCRIPT script.
function show_graph($param)
{
# Include the width and height as parameters:
$param['w'] = GRAPH_WIDTH;
$param['h'] = GRAPH_HEIGHT;
# URL to the graphing script, with parameters, escaped for HTML:
$img_url = htmlspecialchars(build_url(GRAPH_SCRIPT, $param));
echo <<<END
<hr>
<p>
Gráfico que muestra el saldo de la cuenta a través del tiempo, con depósitos mensuales de
{$param['deposit']} y la ganancia de interés anual de {$param['intrate']}%:
<p><img src="$img_url" width="{$param['w']}" height="{$param['h']}"
alt="Account balance graph.">
END;
}

# This is the main processing code.
begin_page("PHPlot: Ejemplo de Gr&aacute;fica con Formulario");
$params_supplied = check_form_params($param);
show_descriptive_text();
show_form($param);
if ($params_supplied) show_graph($param);
end_page();



?>
