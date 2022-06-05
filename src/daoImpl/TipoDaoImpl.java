package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.TipoDao;
import entidad.TipoSeguro;

public class TipoDaoImpl implements TipoDao {

	private String leerTodo = "SELECT * FROM TIPOSEGUROS";
	
	@Override
	public ArrayList<TipoSeguro> ListarTodo() {
		
		ArrayList<TipoSeguro> result = new ArrayList<TipoSeguro>();
		Conexion conexion = Conexion.getConexion();
		PreparedStatement statement;
		ResultSet resultSet;
		
		try{
			
			statement = conexion.getSQLConexion().prepareStatement(leerTodo);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				TipoSeguro temporal = new TipoSeguro();
				temporal.setID(resultSet.getInt("idTipo"));
				temporal.setDescripcion(resultSet.getString("descripcion"));
				result.add(temporal);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{ }		
		return result;
	}
}
