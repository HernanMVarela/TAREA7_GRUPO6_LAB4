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
<body>
<a href="Inicio.jsp">Inicio</a> - <a href="Agregar.jsp">Agregar</a> - <a href="Listar.jsp">Listar</a><br><br>
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
	<select name="tipo" style="width: 138px; ">  
	
     <option value=null selected disabled hidden>Elegir una</option>
     <%for(TipoSeguro t : listatipo){
     	 
    	 %>
		<option value="<%=t.getID()%>"><%=t.getDescripcion().toString()%></option>
		<%} %>
		
	</select>
	
	<br><br>
	
	Costo de contratacion:<input type="text"  onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="txtContratacion" required> <br><br>
	
	Costo maximo asegurado: <input type="text"  onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="txtMaximo" required> <br><br>
		
	<input type="submit" name="btnAceptar" value="Aceptar">
	
</form>

<%
	int filas=0;
	if(request.getAttribute("fila") != null)
		filas = (int)request.getAttribute("fila");
%>
<% if(filas == 1){ %>
			<b>�Seguro agregado con exito! </b>
			<%} %>

</body>
</html>