
public class Proveedor {
	private static int contador = 0;
	private int identificador = 0;
	private String nombre;
	private String apellidos;
	
	public Proveedor(String nombre, String apellidos) {
		this.identificador = ++contador;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public int getId() {
		return identificador;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
}
