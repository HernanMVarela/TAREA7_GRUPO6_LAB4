<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.TipoSeguro"%>
<%@page import="negocio.TipoNegocio"%>
<%@page import="negocioImpl.TipoNegocioImpl"%>
<%@page import="entidad.Seguro"%>
<%@page import="servlets.ServletTipoSeguro"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seguros Group - Listar Seguros</title>
</head>
<body>
<a href="Inicio.jsp">Inicio</a> - <a href="Agregar.jsp">Agregar</a> - <a href="Listar.jsp">Listar</a><br><br>

<form action="ServletSeguro" method="get">

<%
	TipoNegocio tipoNegocio = new TipoNegocioImpl();
	ArrayList<TipoSeguro> listaTipo = tipoNegocio.ListarTodo();
%>

<%
if(!listaTipo.isEmpty()){ %>
	<h2>Tipo de seguro de la base de datos</h2>
	<p>Busqueda por tipo de seguro:
	<select name="opc">
	<option value="0">Listar todos</option>
	<%
	for(TipoSeguro tipo : listaTipo){
		%><option value="<%=tipo.getID()%>"><%=tipo.getDescripcion().toString()%></option>
	<%}%>	
	</select> <input type="submit" name="btnListar" value="Listar"> </p> 
<% } %>

<!--
<p>Busqueda por tipo de seguro:
<select name="slcTipo">
	<option value="0">Listar todos</option>
-->
<%-- 	<%if(listatipo!=null){ --%>
<!--  		for(TipoSeguro tipo : listatipo){ -->
<%-- 		%><option value="<%=tipo.getID()%>"><%=tipo.getDescripcion().toString()%></option> --%>
<%-- 	<%}}%>	 --%>
<!--
</select> <input type="submit" name="btnListar" value="Listar"> </p> 
-->
<%
	ArrayList<Seguro> listaSeguros = null;
	if(request.getAttribute("listaSeguros")!=null){
		listaSeguros = (ArrayList<Seguro>)request.getAttribute("listaSeguros");
		%>
		<table border="1">
		<tr><th> ID Seguro </th><th> Descripción </th><th> Descripción Tipo </th><th> Costo Contratación </th><th> Costo Asegurado </th> </tr>
		<%
		
		for (Seguro seg : listaSeguros){				
				%>
				
					<tr>
						<td> <%=seg.getId()%> </td>
						<td> <%=seg.getDescripcion() %> </td>
 						<td> <%=seg.getTipo().getDescripcion()%> </td>
						<td> <%=seg.getCosto()%> </td>
						<td> <%=seg.getCostoMaximo() %> </td>
					</tr>
				
				<%
		}
	}
 %>
	
</table>	


</form>

</body>
</html>
