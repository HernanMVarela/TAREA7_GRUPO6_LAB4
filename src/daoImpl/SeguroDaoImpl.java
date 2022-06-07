package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.SeguroDao;
import entidad.Seguro;
import entidad.TipoSeguro;

public class SeguroDaoImpl implements SeguroDao {

	private String aInsertar = "INSERT INTO SEGUROS (DESCRIPCION, IDTIPO, COSTOCONTRATACION, COSTOASEGURADO) VALUES (?,?,?,?)";
	private String leerTodo =
		"SELECT s.idSeguro, s.descripcion, s.idTipo, t.descripcion tipoDescripcion, s.costoContratacion, s.costoAsegurado FROM SEGUROS s LEFT JOIN tiposeguros t on s.idTipo = t.idTipo";
	private String leerPorTipo =
		"SELECT s.idSeguro, s.descripcion, s.idTipo, t.descripcion tipoDescripcion, s.costoContratacion, s.costoAsegurado FROM SEGUROS s LEFT JOIN tiposeguros t on s.idTipo = t.idTipo WHERE s.idTipo = ?";
	private String lastid = "SELECT MAX(s.idSeguro) FROM segurosgroup.seguros s order by s.idSeguro";
	
	@Override
	public boolean Agregar(Seguro poliza) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		PreparedStatement Stat;
		Connection Conex = Conexion.getConexion().getSQLConexion();
		
		boolean InsertState = false;
		
		try {
			Stat = Conex.prepareStatement(aInsertar);
			Stat.setString(1, poliza.getDescripcion());
			Stat.setInt(2, poliza.getTipo().getID());
			Stat.setFloat(3, poliza.getCosto());
			Stat.setFloat(4, poliza.getCostoMaximo());
			
			if (Stat.executeUpdate()>0) {
				Conex.commit();
				InsertState=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				Conex.rollback();
				
			} catch (Exception e2) {
				e.printStackTrace();
			}
		}
		
		return InsertState;
	}

	@Override
	public ArrayList<Seguro> ListarTodo() {
		
		ArrayList<Seguro> result = new ArrayList<Seguro>();
		Conexion conexion = Conexion.getConexion();
		PreparedStatement statement;
		ResultSet resultSet;
		try{
			
			statement = conexion.getSQLConexion().prepareStatement(leerTodo);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				
				Seguro temporal = new Seguro();
				temporal.setId(resultSet.getInt("idSeguro"));
				temporal.setDescripcion(resultSet.getString("descripcion"));
				TipoSeguro tipoSeguroTemporal = new TipoSeguro();
				tipoSeguroTemporal.setID(resultSet.getInt("idTipo"));
				tipoSeguroTemporal.setDescripcion(resultSet.getString("tipoDescripcion"));
				temporal.setTipo(tipoSeguroTemporal);
				temporal.setCosto(resultSet.getFloat("costoContratacion"));
				temporal.setCostoMaximo(resultSet.getFloat("costoAsegurado"));
				result.add(temporal);
			}
			//connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{ }		
		return result;
	}

	@Override
	public ArrayList<Seguro> ListarPorTipo(int tipoSeleccionado) {
				
		ArrayList<Seguro> result = new ArrayList<Seguro>();
		Connection connection = null;
		try{
			connection = Conexion.getConexion().getSQLConexion();
			PreparedStatement statement = connection.prepareStatement(leerPorTipo);
			statement.setInt(1, tipoSeleccionado);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				
				Seguro temporal = new Seguro();
				temporal.setId(resultSet.getInt("idSeguro"));
				temporal.setDescripcion(resultSet.getString("descripcion"));
				TipoSeguro tipoSeguroTemporal = new TipoSeguro();
				tipoSeguroTemporal.setID(resultSet.getInt("idTipo"));
				tipoSeguroTemporal.setDescripcion(resultSet.getString("tipoDescripcion"));
				temporal.setTipo(tipoSeguroTemporal);
				temporal.setCosto(resultSet.getFloat("costoContratacion"));
				temporal.setCostoMaximo(resultSet.getFloat("costoAsegurado"));
				result.add(temporal);
			}
			//connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{ }		
		return result;
	}

	@Override
	public int ultimoId() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		int last=0;
		Conexion conexion = Conexion.getConexion();
		PreparedStatement st;
		ResultSet rs;
		
		try {
			st = conexion.getSQLConexion().prepareStatement(lastid);
			rs = st.executeQuery();
			while(rs.next()) {
				last = rs.getInt(1);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return last;
	}
	
}
