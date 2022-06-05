package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.TipoDao;
import entidad.TipoSeguro;

public class TipoDaoImpl implements TipoDao {

	private String leerTodo = "SELECT * FROM TIPOSEGUROS";
	
	@Override
	public ArrayList<TipoSeguro> ListarTodo() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<TipoSeguro> result = new ArrayList<TipoSeguro>();
		Connection connection = null;
		try{
			
			connection = Conexion.getConexion().getSQLConexion();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(leerTodo);
			
			while(resultSet.next()){
				TipoSeguro temporal = new TipoSeguro();
				temporal.setID(resultSet.getInt("idTipo"));
				temporal.setDescripcion(resultSet.getString("descripcion"));
				result.add(temporal);
			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{ }		
		return result;
	}
}
