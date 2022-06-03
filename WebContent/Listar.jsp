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
<title>Insert title here</title>
</head>
<body>
<a href="Inicio.jsp">Inicio</a> - <a href="Agregar.jsp">Agregar</a> - <a href="Listar.jsp">Listar</a><br><br>

<h2>Tipo de seguro de la base de datos</h2>

<form action="ServletSeguro" method="get">

<%
	TipoNegocio TipoNeg = new TipoNegocioImpl();
	List<TipoSeguro> listatipo= TipoNeg.listar();
%>

<p>Busqueda por tipo de seguro:
<select name="slcTipo">
	<option value="0">Listar todos</option>
	<%if(listatipo!=null){
		for(TipoSeguro tipo : listatipo){ 
		%><option value="<%=tipo.getID()%>"><%=tipo.getDescripcion().toString()%></option>
	<%}}%>	
</select> <input type="submit" name="btnListar" value="Listar"> </p> 


<table border="1">
<tr><th> ID Seguro </th><th> Descripción </th><th> Descripción Tipo </th><th> Costo Contratación </th><th> Costo Asegurado </th> </tr>
<%
	ArrayList<Seguro> lista = null;
	if(request.getAttribute("listaseguros")!=null){
		lista = (ArrayList<Seguro>)request.getAttribute("listaseguros");
		for (Seguro seg : lista){
			if(seg.getTipo().getID() == (int)request.getAttribute("idtipo") || (int)request.getAttribute("idtipo") == 0){
				%>
					<tr><td> <%=seg.getId()%> </td><td> <%=seg.getDescripcion() %> </td> <td> <%=seg.getTipo().getDescripcion()%> </td> 
					<td> <%=seg.getCosto()%> </td> <td> <%=seg.getCosto() %> </td></tr>
				<%
			}
		}
	}
 %>
	
</table>	


</form>

</body>
</html>