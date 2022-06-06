package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.TipoDao;
import entidad.TipoSeguro;

public class TipoDaoImpl implements TipoDao {

	private String leerTodo = "SELECT * FROM TIPOSEGUROS";
	private String buscar = "SELECT t.idTipo, t.descripcion FROM segurosgroup.tiposeguros t where idTipo=?";
	
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

	@Override
	public TipoSeguro buscarTipo(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		TipoSeguro tipo = null;
		Conexion conexion = Conexion.getConexion();
		PreparedStatement st;
		ResultSet rs;
		
		try {
			st = conexion.getSQLConexion().prepareStatement(buscar);
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()) {
				tipo = getTiposSeguro(rs);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return tipo;
	}
	
	private TipoSeguro getTiposSeguro(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt(1);
		String descrip = resultSet.getString(2);
		return new TipoSeguro(id, descrip);
	}
}
