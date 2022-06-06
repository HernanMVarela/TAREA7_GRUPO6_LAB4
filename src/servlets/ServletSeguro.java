package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Seguro;
import entidad.TipoSeguro;
import negocio.SeguroNegocio;
import negocio.TipoNegocio;
import negocioImpl.SeguroNegocioImpl;
import negocioImpl.TipoNegocioImpl;


@WebServlet("/ServletSeguro")
public class ServletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletSeguro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnListar")!=null) {
			
			int tipoSeleccionado = Integer.parseInt(request.getParameter("opc"));
			ArrayList<Seguro> listaSeguros = null;
						
			if( tipoSeleccionado==0) {
				System.out.println("Opcion 0");
				SeguroNegocio seguroNegocio = new SeguroNegocioImpl();
				listaSeguros = seguroNegocio.ListarTodo();
			} else {
				SeguroNegocio seguroNegocio = new SeguroNegocioImpl();
				System.out.println("Opcion "+tipoSeleccionado);
				//listar por idtipo
				listaSeguros = seguroNegocio.ListarPorTipo(tipoSeleccionado);
			}
			
			// DEVOLVER LISTA E ID TIPO SEGURO
			request.setAttribute("listaSeguros", listaSeguros);
			request.setAttribute("idtipo", tipoSeleccionado);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Listar.jsp");   
	        rd.forward(request, response);
			
		}
		
		if(request.getParameter("btnAgregar")!=null) {
			String mensaje = "Error - Datos incompletos, faltante:";
			boolean flag = true;
			String descrip = "";
			float costo =0, costoaseg = 0;
			TipoSeguro nuevo = new TipoSeguro();
			TipoNegocio TiNeg = new TipoNegocioImpl();
			
			if(!request.getParameter("txtDescripcion").isEmpty()) {
				descrip = request.getParameter("txtDescripcion").toString();
			}else {
				mensaje += " Descripción |";
				flag = false;
			}
			
			if(request.getParameter("slcTipo")!= null) {
				if(Integer.parseInt(request.getParameter("slcTipo"))!=0) {
					nuevo = TiNeg.buscarTipo(Integer.parseInt(request.getParameter("slcTipo")));
				}else {
					mensaje += " Tipo de seguro |";
					flag = false;
				}
			}
			
			if(!request.getParameter("txtContratacion").isEmpty()) {		
				costo = Float.parseFloat(request.getParameter("txtContratacion").toString());
			}else {
				mensaje += " Costo de contratación |";
				flag = false;
			}
		
			if(!request.getParameter("txtMaximo").isEmpty()) {		
				costoaseg = Float.parseFloat(request.getParameter("txtMaximo").toString());
			}else {
				mensaje += " Costo asegurado |";
				flag = false;
			}
			
			if(flag) {
				mensaje ="Seguro agregado: " + descrip + " - " + nuevo.getDescripcion() + " - $" + costo + " - $" + costoaseg;
				SeguroNegocio segNeg = new SeguroNegocioImpl();
				Seguro nuevoSeg = new Seguro(descrip, costo, costoaseg);
				nuevoSeg.setTipo(nuevo);
				segNeg.agregarSeguro(nuevoSeg);
			}
			
			request.setAttribute("Mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("/Agregar.jsp");
			rd.forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
