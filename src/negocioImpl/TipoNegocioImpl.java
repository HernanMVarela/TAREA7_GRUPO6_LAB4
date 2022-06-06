package negocioImpl;

import java.util.ArrayList;
import dao.TipoDao;
import daoImpl.TipoDaoImpl;
import entidad.TipoSeguro;
import negocio.TipoNegocio;

public class TipoNegocioImpl implements TipoNegocio{

	@Override
	public ArrayList<TipoSeguro> ListarTodo() {
		TipoDao Tdao = new TipoDaoImpl();
		return Tdao.ListarTodo();
	}

	@Override
	public TipoSeguro buscarTipo(int id) {
		TipoDao Tdao = new TipoDaoImpl();
		return Tdao.buscarTipo(id);
	}

}
