package negocio;

import java.util.ArrayList;

import entidad.Seguro;

public interface SeguroNegocio {
	public ArrayList<Seguro> ListarTodo();
	public ArrayList<Seguro> ListarPorTipo(int tipoSeleccionado);

}
