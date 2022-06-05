package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletAgregar")
public class ServletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletSeguro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnListar")!=null) {
			
			
			// DEVOLVER LISTA E ID TIPO SEGURO
			//request.setAttribute("listaSeguros", listaSeguros);
			//request.setAttribute("listaTipoSeguros", listaTipoSeguros);
			//request.setAttribute("idtipo", id);
			
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
