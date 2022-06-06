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

	@Override
	public int ultimoId() {
		SeguroDao SegDao = new SeguroDaoImpl();
		return SegDao.ultimoId();
	}

	@Override
	public boolean agregarSeguro(Seguro agregar) {
		SeguroDao SegDao = new SeguroDaoImpl();
		// VALIDAR QUE EL ID NO EXISTA (REDUNDANTE POR SER AUTOINCREMENTAL, PERO IGUAL...)
		return SegDao.Agregar(agregar);
	}

}
