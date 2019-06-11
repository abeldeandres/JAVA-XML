import java.util.Scanner;

public class main {
	public static Gestor  gestor = new Gestor();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		boolean flag=true;
		while(flag) {
			System.out.println("1. Añadir Productos \n");
			System.out.println("2. Eliminar Productos \n");
			System.out.println("3. Buscar producto \n");
			System.out.println("4. Listar productos \n");
			System.out.println("5. Exportar XML \n");
			System.out.println("0. Salir \n");
			
			System.out.println("Introduzca seleccion \n");
			int c=sc.nextInt();
			
			switch(c) {
			case 1:
				añadirProductos();
				break;
			case 2:
				System.out.println("Introduzca la ID del producto \n");
				int id=sc.nextInt();
				gestor.eliminarProducto(id);
				break;
			case 3:
				System.out.println("Introduzca la ID del producto \n");
				int id2=sc.nextInt();
				Producto prod=gestor.buscarProducto(id2);
				if(prod==null) {
					System.out.println("No existe el producto");
				}else {
					System.out.println("La ID del producto es: "
							+ prod.getId() +"\n"
							+ "El nombre del producto es "+prod.getNombre()+ "\n"
							+ "La descripcion del producto es "+ prod.getDescripcion()
				);
				}
				break;
			case 4:
				System.out.println(gestor.listarProductos());
				break;
			case 5:
				gestor.imprimirXML();
				break;
			case 0:
				flag=false;
				break;
			default: break;
			}
		}
	}
	
	public static void añadirProductos() {
		System.out.println("Introduzca el numero de productos a añadir \n");
		int numProd=sc.nextInt();
		for(int j=0;j<numProd;j++) {
			Producto prod1 = new Producto();
			sc.nextLine();
			System.out.println("Introduce la descripcion del producto");
			String descProd = sc.nextLine();
			prod1.setDescripcion(descProd);
			sc.nextLine();
			System.out.println("Introduce el nombre del producto");
			String nomProd=sc.nextLine(); 
			prod1.setNombre(nomProd);
			System.out.println("Indique el numero de proveedores");
			int numProvee=sc.nextInt();
			for(int i=0; i< numProvee;i++) {
				System.out.println("Introduzca el nombre del proveedor " + i);
				sc.nextLine();
				String nombreProvee=sc.nextLine();
				sc.nextLine();
				System.out.println("Introduzca el apellido del proveedor " + i);
				String apellidoProvee=sc.nextLine();
				Proveedor prov1 = new Proveedor(nombreProvee, apellidoProvee);
				prod1.aniadirProveedor(prov1);
			}
			gestor.aniadirProducto(prod1);
		}
		
	}

}
