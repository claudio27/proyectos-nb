<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="org.tresenraya.*" %>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tres en Raya</title>
        <style type="text/css">
            body{color: #880000; text-align: center;}
            a{color: #FF8800; font-size: 20px;}
            a.casilla{color: #FFFFFF; font-family: courier new; font-size: 70px;}
            a.ficha0{color: #FF0000; font-family: courier new; font-size: 70px;}
            a.ficha1{color: #0000FF; font-family: courier new; font-size: 70px}
            h5{color: #008800; font-size: 50px;}
        </style>
    </head>
    <body>

    <h1>Tres en Raya</h1>
    <%
       TresEnRaya ter=(TresEnRaya)session.getAttribute("juego");
       if (ter==null){
           ter=new TresEnRaya();
           session.setAttribute("juego", ter);
       }
       
       String accion=request.getParameter("accion");
       if (accion!=null){
           try{
               if (accion.equals("pulsa")){
                    int n=Integer.parseInt(request.getParameter("fil"));
                    int m=Integer.parseInt(request.getParameter("col"));
                    ter.pulsaBoton(n,m);
               }else if (accion.equals("empezar")){
                   ter.empezarPartida();
               }
           }catch(Exception e){
           }
       }
       
       int nTablero[][]=ter.getTablero();
       String sFiguras[]={"O", "0", "X"};
       
       out.println("<table border='1' width='500'>");
       for (int n=0;n<3;n++){
           out.println("<tr>");
           for (int m=0;m<3;m++){
               out.println("<td align=center>");
               if (nTablero[n][m]==-1)
                    out.println("<a class='casilla' href='index.jsp?accion=pulsa&fil="+n+"&col="+m+"'>");
               else
                    out.println("<a class='ficha" + nTablero[n][m] + "'>");
               out.println(sFiguras[nTablero[n][m]+1]);
               out.println("</a>");
               out.println("</td>");
           }
           out.println("</tr>");
       }
       out.println("</table>");

       out.println("<a href='index.jsp?accion=empezar'>Empezar partida</a>");
       
       int nGanador=ter.getGanador();
       if (nGanador==0)out.println("<h5>Has ganado</h5>");
       if (nGanador==1)out.println("<h5>Has perdido</h5>");
       
    %>
    </body>
</html>
