import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Gestor {
	private ArrayList<Producto> listadoProductos = new ArrayList<Producto>();
	private int contadorID=0;
	
	
	public void aniadirProducto(Producto producto) {
		producto.setId(contadorID);
		listadoProductos.add(producto);
		contadorID++;
	}
	
	public void eliminarProducto(int id) {
		Producto prod = buscarProducto(id);
		if(prod!=null) {
			listadoProductos.remove(prod);
		}
	}
	
	public String listarProductos() {
		String listado="";
		for(int i=0;i<listadoProductos.size();i++) {
		  listado+="ID del producto: " + listadoProductos.get(i).getId() + "\n"
				  + "Nombre del producto: " +listadoProductos.get(i).getNombre() + "\n"
				  + "Descripcion del producto "+listadoProductos.get(i).getDescripcion() + "\n";
		  for(int j=0; j<listadoProductos.get(i).getListadoProveedores().size();j++) {
			  listado+="ID del proveedor: " + listadoProductos.get(i).getListadoProveedores().get(j).getId() + "\n"
					  + "Nombre del proveedor: " +listadoProductos.get(i).getListadoProveedores().get(j).getNombre() + "\n"
					  + "Apellidos del producto "+listadoProductos.get(i).getListadoProveedores().get(j).getApellidos() + "\n";
		  }
		}
		return listado;
	}
	
	public Producto buscarProducto(int id) {
		int i=0;
		Producto producto = null;
		boolean encontrado=false;
		while(i<listadoProductos.size() && !encontrado) {
			if(listadoProductos.get(i).getId()==id) {
				encontrado=true;
				producto=listadoProductos.get(i);
			}
			i++;
		}
			
		return producto;
	}
	
	public void imprimirXML() {
            
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// elemento raiz -> Empresa
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("almacen");
		doc.appendChild(rootElement);
		
		for(int i=0;i<listadoProductos.size(); i++) {
			Element producto = doc.createElement("producto");
			rootElement.appendChild(producto);
			
			// atributo del elemento producto
			Attr attr = doc.createAttribute("id");
			attr.setValue(""+listadoProductos.get(i).getId());
			producto.setAttributeNode(attr);
			
			// nombre
			Element nombre = doc.createElement("nombre");
			nombre.appendChild(doc.createTextNode(listadoProductos.get(i).getNombre()));
			producto.appendChild(nombre);
			
			// Descripcion
			Element descripcion = doc.createElement("descripcion");
			descripcion.appendChild(doc.createTextNode(listadoProductos.get(i).getDescripcion()));
			producto.appendChild(descripcion);
			
			
			for(int j=0; j<listadoProductos.get(i).getListadoProveedores().size();j++) {
				Element proveedor = doc.createElement("proveedor");
				producto.appendChild(proveedor);
				
				Attr attr1 = doc.createAttribute("idProveedor");
				attr1.setValue(""+listadoProductos.get(i).getListadoProveedores().get(j).getId());
				proveedor.setAttributeNode(attr1);
				
				Element nombreProveedor = doc.createElement("nombreProveedor");
				nombreProveedor.appendChild(doc.createTextNode(listadoProductos.get(i).getListadoProveedores().get(j).getNombre()));
				proveedor.appendChild(nombreProveedor);
				
				Element apellidosProveedor = doc.createElement("apellidosProveedor");
				apellidosProveedor.appendChild(doc.createTextNode(listadoProductos.get(i).getListadoProveedores().get(j).getApellidos()));
				proveedor.appendChild(apellidosProveedor);
			}

		}
 
		// escribimos el contenido en un archivo .xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("archivo.xml"));
		//StreamResult result = new StreamResult(new File("archivo.xml"));
 
		// Si se quiere mostrar por la consola...
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("XML guardado");
 
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	
	}
	
	
	
	
	
	
}
