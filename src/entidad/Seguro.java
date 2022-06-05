package entidad;

public class Seguro {
	private int id;
	static int cont=1;
	private String descripcion;
	private TipoSeguro tipo;
	private float costo;
	private float costoMaximo;
	
	public Seguro() {
		
	}
	
	public Seguro(String descripcion,float costo,float costoMaximo){
		id = devuelveProximoId();
		this.descripcion =descripcion;
		this.costo = costo;
		this.costoMaximo = costoMaximo;				
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

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public float getCostoMaximo() {
		return costoMaximo;
	}

	public void setCostoMaximo(float costoMaximo) {
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
