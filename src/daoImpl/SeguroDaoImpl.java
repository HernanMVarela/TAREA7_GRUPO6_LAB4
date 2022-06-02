package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.SeguroDao;
import entidad.Seguro;

public class SeguroDaoImpl implements SeguroDao {

	private String aInsertar = "INSERT INTO SEGUROS (DESCRIPCION, IDTIPO, COSTOCONTRATACION, COSTOASEGURADO) VALUES (?,?,?,?)";
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
	
}
