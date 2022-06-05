package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.SeguroDao;
import entidad.Seguro;
import entidad.TipoSeguro;

public class SeguroDaoImpl implements SeguroDao {

	private String aInsertar = "INSERT INTO SEGUROS (DESCRIPCION, IDTIPO, COSTOCONTRATACION, COSTOASEGURADO) VALUES (?,?,?,?)";
	private String leerTodo = "SELECT * FROM SEGUROS";
	private String leerPorTipo = "SELECT * FROM SEGUROS WHERE idTipo = ?";
	
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Seguro> result = new ArrayList<Seguro>();
		Connection connection = null;
		try{
			connection = Conexion.getConexion().getSQLConexion();
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(leerTodo);
			
			while(resultSet.next()){
				
				Seguro seguroTemporal = new Seguro();
				seguroTemporal.setId(resultSet.getInt("idSeguro"));
				seguroTemporal.setDescripcion(resultSet.getString("descripcion"));
				TipoSeguro tipoSeguroTemporal = new TipoSeguro();
				tipoSeguroTemporal.setID(resultSet.getInt("idTipo"));
				//agregar una busqueda de tipos de seguros
				//tipoSeguroTemporal.setDescripcion(descripción);				
				seguroTemporal.setTipo(tipoSeguroTemporal);
				seguroTemporal.setCosto(resultSet.getFloat("costoContratacion"));
				seguroTemporal.setCostoMaximo(resultSet.getFloat("costoAsegurado"));
				result.add(seguroTemporal);
			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{ }		
		return result;
	}
	
}
