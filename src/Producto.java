import java.util.ArrayList;

public class Producto {
	private int id;
	private String nombre;
	private String descripcion;
	private Proveedor proveedor;
	private ArrayList<Proveedor> listadoProveedores = new ArrayList<Proveedor>();
	
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public ArrayList<Proveedor> getListadoProveedores() {
		return listadoProveedores;
	}
	public void setListadoProveedores(ArrayList<Proveedor> listadoProveedores) {
		this.listadoProveedores = listadoProveedores;
	}
	
	public void aniadirProveedor(Proveedor proveedor) {
		this.listadoProveedores.add(proveedor);
	}
	
	
	
	
	
}
