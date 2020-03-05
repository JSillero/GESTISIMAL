package src;

import java.util.ArrayList;



/**
 * Clase Almacen que realice el alta, baja, modificación, entrada de  mercancía (incrementa
 *  unidades), salida de mercancía (decrementa unidades) 
 *  
El estado será un ArrayList de artículos. Esta clase es un envoltorio de un ArrrayList,
 pero su diseño es distinto al de GESTISIMAL. No te copies, sencillamente entiéndelo.
 
Su comportamiento será: añadir  artículos (no puede haber dos artículos iguales), eliminar
 artículos,  incrementar las existencias de un artículo (se delega en la clase artículo),
   decrementar las existencias de un artículo (nunca por debajo de cero, se  delega en la clase
    artículo), devolver un artículo (para mostrarlo). Para  listar el almacén podría devolverse
     una cadena con todos los artículos del almacén (toString)
 * 
 * 
 * @author Sillero
 *
 */
public class Almacen {
	private ArrayList<Articulo> almacen = new ArrayList<Articulo>();///debería de ser estatico?
	
	public void annadir(String desc, int precComp, int precVent, int cantidad) {
		
		this.almacen.add(new Articulo( desc , precComp , precVent , cantidad ));
	}
	
	
	/**
	 * Devuelve el index de un objeto identificado por un codigo pasado por parametro.
	 * 
	 * @param codigo identificador unico de cada articulo
	 * @return index en almacen, si el numero no existe devuelve -1
	 */
	public int getArticulo(int codigo) {
		
		for (Articulo x : almacen) {
			if(x.getCodigo() == codigo) {
				return(this.almacen.indexOf(x));
			}
		}
		return -1;
	}
	
	public void borrar(int codigo) {
		this.almacen.removeIf(n -> (n.equals(new Articulo(codigo))));
		
	}
	
	/**
	 * 
	 * 
	 * @param codigo codigo identificador unico de cada articulo
	 * @param cantidad cantidad que se sumará a la actual, puede ser negativa si se desea restar.
	 */
	public void modificarCantidad(int codigo, int cantidad) {
		int index=this.getArticulo(codigo);

		if(index == -1)
			System.out.println("No hay ningun objeto con el codigo expecificado");
		else {
			int unidades= this.almacen.get(index).getUnidades();
			this.almacen.get(index).setUnidades(unidades + cantidad);
		}
		
	}
	
	public Articulo mostrarArticulo(int codigo) {
		
		 int index=this.getArticulo(codigo);
		 return almacen.get(index);
		 
	}
	
	public String toString() {
		String cadena="";
		for ( Articulo x : almacen) {
			cadena += x.toString()+"\n"; 
		}
		
		
		return cadena;
	}

}
