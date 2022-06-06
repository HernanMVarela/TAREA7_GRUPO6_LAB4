package dao;

import java.util.ArrayList;
import entidad.TipoSeguro;

public interface TipoDao {

	public ArrayList<TipoSeguro> ListarTodo();
	public TipoSeguro buscarTipo(int id);
}
