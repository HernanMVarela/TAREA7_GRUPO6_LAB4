package negocio;

import java.util.ArrayList;
import entidad.TipoSeguro;

public interface TipoNegocio {
	public ArrayList<TipoSeguro> ListarTodo();
	public TipoSeguro buscarTipo(int id);
}
