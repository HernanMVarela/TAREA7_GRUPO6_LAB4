package negocioImpl;

import java.util.ArrayList;

import dao.SeguroDao;
import daoImpl.SeguroDaoImpl;
import entidad.Seguro;
import negocio.SeguroNegocio;

public class SeguroNegocioImpl implements SeguroNegocio{

	@Override
	public ArrayList<Seguro> ListarTodo() {
		ArrayList<Seguro> result = new ArrayList<Seguro>();
		SeguroDao seguroDao = new SeguroDaoImpl();
		result = seguroDao.ListarTodo();
		return result;
	}

	@Override
	public ArrayList<Seguro> ListarPorTipo(int tipoSeleccionado) {
		ArrayList<Seguro> result = new ArrayList<Seguro>();
		SeguroDao seguroDao = new SeguroDaoImpl();
		result = seguroDao.ListarPorTipo(tipoSeleccionado);
		return result;
	}

}
