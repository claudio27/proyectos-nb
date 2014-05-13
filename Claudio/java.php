<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>Claudio Serrano| Java Applet</title>

        <!-- Mobile viewport optimisation -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- (en) Add your meta data here -->
        <!-- (de) Fuegen Sie hier ihre Meta-Daten ein -->

        <link href="./css/flexible-columns.css" rel="stylesheet" type="text/css"/>

        <link rel="stylesheet" href="./add-ons/accessible-tabs/tabs.css" type="text/css"/>
         <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
        <!--[if lte IE 7]>
	<link href="./css/core/iehacks.css" rel="stylesheet" type="text/css" />
	<![endif]-->

        <!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
       
        <script type="text/javascript" src="js/scripts/shCore.js"></script>
        <script type="text/javascript" src="js/scripts/shBrushJava.js"></script>
        <script type="text/javascript" src="js/scripts/shBrushBash.js"></script>
        <link type="text/css" rel="stylesheet" href="js/styles/shCoreMidnight.css"/>
        <script type="text/javascript">SyntaxHighlighter.all();</script>
    </head>
    <body class="demo-2col">


        <ul class="ym-skiplinks">
            <li><a class="ym-skip" href="#nav">Saltarse al contenido principal (Enter)</a></li>
            <li><a class="ym-skip" href="#main">Saltarse al contenido principal (Enter)</a></li>
        </ul>

        <div class="ym-wrapper">
            <div class="ym-wbox">
                <header>
                    <h1>Muestra Java </h1>
                </header>
                <nav id="nav">
                    <div class="ym-hlist" >
                        <ul>
                            <li><a href="index.html">HOME</a></li>
                            <li><a href="muestraPhp.php">PHP Y MYSQL</a><li>
                            <li class="active"><strong>JAVA APPLET </strong></li>
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

								<section class="box info">
                                                    <h3>Fractales</h3>

                                                    <p>
 <applet CODE="koch.KochApplet.class" ARCHIVE="koch.jar" WIDTH="600" HEIGHT="405" HSPACE="0" VSPACE="0" ALIGN="middle">
Este Applet aparecerá en un explorador compatible con JDK 1.1.    </applet>
                                                    </p>

							
						</section>
								


                                <pre class="brush: java;">
<?php include"java/KochApplet.java"?>

                                </pre>






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
        <script src="js/yaml-focusfix.js"></script>
        <!-- este ya estaba  -->

    </body>
</html>
