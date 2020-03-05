package src;
import java.io.IOException;
import java.lang.System;

/**
 * 
 * Clase TestAlmacen, donde se realiza la comunicación con el usuario 
 *  (mostrar menú y recuperar opción del menú, mostrar errores, listar)
 *   y se  manipula el almacén.  Debes organizarla en métodos que deleguen
 *    en la clase almacén (
 *    listar, 
 *    annadir, 
 *    eliminar... al menos uno por cada 
 *    una de las opciones del menú).
 * 
 * @author Sillero
 *
 */
public class TestAlmacen {

	public static void main(String[] args) {
		Almacen almacen = new Almacen();
		
		String desc;
		int codigo;
		int precCompra;
		int precVent;
		int cantidad;
		boolean loop = true;
		
		///Creacion de los dos menus que se usarán.
		String menu1[]= {"Listar","Annadir","Borrar","Administrar Stock","Editar articulo","Salir"};
		Menu menuprincipal = new Menu("GESTISIMAL",menu1);
		
		String menu2[]= {"Editar descripcion","Editar precio de venta","Editar precio de compra","Salir"};
		Menu menueditar = new Menu("MENU DE EDICION",menu2);
		
		
		while(loop) {
		
			int respuesta=menuprincipal.gestionar();
			switch (respuesta) {
				case 1:
					System.out.println(almacen);
					break;
				case 2:
					desc = Teclado.leerCadena("Introduzca la descripcion del artculo");
					precCompra = Teclado.leerEntero("Introduzca el precio de compra");
					precVent = Teclado.leerEntero("Introduzca el precio de venta");
					cantidad= Teclado.leerEntero("Introduzca la candidad de producto");
					almacen.annadir(desc, precCompra, precVent, cantidad);
					break;
				case 3:
					codigo = Teclado.leerEntero("Introduzca el codigo del articulo a eliminar");
					almacen.borrar(codigo);
					break;
				case 4:
					codigo = Teclado.leerEntero("Introduzca el codigo del articulo a modificar");
					respuesta = menueditar.gestionar();
					switch(respuesta) {
					case 1:
						System.out.println("Descripcion original: "+ almacen.mostrarArticulo(codigo).getDescripcion());
						desc = Teclado.leerCadena("Introduce la nueva descripcion:");
						almacen.mostrarArticulo(codigo).setDescripcion(desc);
						break;
					case 2:
						System.out.println("Precio compra original: "+ almacen.mostrarArticulo(codigo).getPrecCompra());
						precCompra = Teclado.leerEntero("Introduce el nuevo precio de compra");
						almacen.mostrarArticulo(codigo).setPrecCompra(precCompra);
						break;
					case 3:
						System.out.println("Precio venta original: "+ almacen.mostrarArticulo(codigo).getPrecVenta());
						precVent = Teclado.leerEntero("Introduce el nuevo precio de venta");
						almacen.mostrarArticulo(codigo).setPrecVenta(precVent);
						break;
					default:
						break;
					}	
					
					break;
				case 5:
					codigo = Teclado.leerEntero("Introduzca el codigo del articulo a modificar");
					cantidad = Teclado.leerEntero("Introduzca la cantidad a añadir, si es negativo se le restarán.");
					almacen.modificarCantidad(codigo, cantidad);
					break;
					
				default:
					loop = false;
					break;
			}
		}

		
	}

}
