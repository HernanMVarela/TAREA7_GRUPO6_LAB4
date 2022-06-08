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
<body style='background-image: url("https://i.imgur.com/CujGJpf.jpg"); background-color: #FFFFFF; background-repeat: no-repeat; background-size: cover; max-width: 99%; max-height: 99%'>
<div style="padding: 10px">
	<a style="margin:15px" href="Inicio.jsp">Inicio</a><a style="margin:15px" href="Agregar.jsp">Agregar</a><a style="margin:15px" href="Listar.jsp">Listar</a>
</div>

<form action="ServletSeguro" method="get">

<%
	TipoNegocio tipoNegocio = new TipoNegocioImpl();
	ArrayList<TipoSeguro> listaTipo = tipoNegocio.ListarTodo();
	
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
<% }

	ArrayList<Seguro> listaSeguros = null;
	if(request.getAttribute("listaSeguros")!=null){
		listaSeguros = (ArrayList<Seguro>)request.getAttribute("listaSeguros");
		if(!listaSeguros.isEmpty()){
		%>
			<div style='background: rgba(200,200,200,0.5); border: solid; border-radius: 10px'><table border="1" style='border-radius:11px'>
			
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
		else{
			%><h3 style="color: rgba(0,0,153,1);">No se encontraron resultados</h3><%
		}
	}
 %>
	
</table></div>	


</form>

</body>
</html>
