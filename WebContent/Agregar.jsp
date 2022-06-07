<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.TipoSeguro"%>
<%@page import="negocio.TipoNegocio"%>
<%@page import="negocio.SeguroNegocio"%>
<%@page import="negocioImpl.SeguroNegocioImpl"%>
<%@page import="negocioImpl.TipoNegocioImpl"%>
<%@page import="entidad.Seguro"%>
<%@page import="servlets.ServletTipoSeguro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seguros Group - Agregar Seguro</title>
</head>
<body style='background-image: url("https://i.imgur.com/CujGJpf.jpg"); background-color: #FFFFFF; background-repeat: no-repeat; background-size: cover; max-width: 99%; max-height: 99%'>
<div style="padding: 10px">
	<a style="margin:15px" href="Inicio.jsp">Inicio</a><a style="margin:15px" href="Agregar.jsp">Agregar</a><a style="margin:15px" href="Listar.jsp">Listar</a>
</div>

<h3>Agregar seguros</h3><br>

<% 
	SeguroNegocio SegNeg = new SeguroNegocioImpl();
	int id = SegNeg.ultimoId()+1;

	TipoNegocio TipoNeg = new TipoNegocioImpl();
	List<TipoSeguro> listatipo= TipoNeg.ListarTodo();
%>

<form action="ServletSeguro" method="get">

Id Seguro: <%=id%>
<br><br>

Descripcion:<input type="text" name="txtDescripcion"required> <br><br>
	
	Tipo de seguro: 
	<select name="slcTipo" style="width: 138px; ">  
	
     <option value="0" selected disabled>Elegir una</option>
     <%for(TipoSeguro t : listatipo){
     	 
    	 %>
		<option value="<%=t.getID()%>"><%=t.getDescripcion().toString()%></option>
		<%} %>
		
	</select>
	
	<br><br>
	
	Costo de contratacion:<input type="text" onkeyup="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1').replace(/^0[^.]/, '0');" name="txtContratacion" required> <br><br>
	
	Costo maximo asegurado: <input type="text" onkeyup="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1').replace(/^0[^.]/, '0');" name="txtMaximo" required> <br><br>
		
	<input type="submit" name="btnAgregar" value="Agregar">
	
	<h4 style="color: rgba(0,0,153,1);"><%
if(request.getAttribute("Mensaje")!=null){
	%><%=request.getAttribute("Mensaje") %><%
}
 %></h4>
</form>
</body>
</html>