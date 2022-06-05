package negocioImpl;

import java.util.List;

import dao.TipoDao;
import daoImpl.TipoDaoImpl;
import entidad.TipoSeguro;
import negocio.TipoNegocio;

public class TipoNegocioImpl implements TipoNegocio{

	@Override
	public List<TipoSeguro> ListarTodo() {
		TipoDao Tdao = new TipoDaoImpl();
		return Tdao.ListarTodo();
	}

}
