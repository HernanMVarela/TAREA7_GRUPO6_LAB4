package entidad;

public class Seguro {
	private int id;
	static int cont=1;
	private String descripcion;
	private TipoSeguro tipo;
	private String costo;
	private String costoMaximo;
	
	public Seguro() {
		
	}
	
	public Seguro(String descripcion,String costo,String costoMaximo){
		id = devuelveProximoId();
		this.descripcion =descripcion;
		this.costo = costo;
		this.costoMaximo = costo;				
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoSeguro getTipo() {
		return tipo;
	}

	public void setTipo(TipoSeguro tipo) {
		this.tipo = tipo;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getCostoMaximo() {
		return costoMaximo;
	}

	public void setCostoMaximo(String costoMaximo) {
		this.costoMaximo = costoMaximo;
	}

	public static int devuelveProximoId() {
		return cont++;

		}
	
	public int getTipoid() {
		return tipo.getID();
	}
	
	public String getTipoDesc() {
		return tipo.getDescripcion();
	}
	

}
