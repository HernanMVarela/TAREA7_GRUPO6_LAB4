package entidad;

public class TipoSeguro {
	private int ID=0;
	private String descripcion="";
	
	public TipoSeguro(int ID, String descripcion) {
		this.ID=ID;
		this.descripcion=descripcion;		
	}

	public TipoSeguro() {
	
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripción) {
		this.descripcion = descripción;
	}

	@Override
	public String toString() {
		return "ID: " + ID + " - " + descripcion;
	}

}
