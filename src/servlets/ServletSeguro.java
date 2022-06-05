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
import negocio.SeguroNegocio;
import negocioImpl.SeguroNegocioImpl;


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
			//request.setAttribute("listaTipoSeguros", listaTipoSeguros);
			request.setAttribute("idtipo", tipoSeleccionado);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Listar.jsp");   
	        rd.forward(request, response);
			
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
