package dao;

import java.util.ArrayList;

import entidad.Seguro;

public interface SeguroDao {
	
	public boolean Agregar(Seguro poliza);
	public ArrayList<Seguro> ListarTodo();
	public ArrayList<Seguro> ListarPorTipo(int tipoSeleccionado);
	public int ultimoId();
	
}
