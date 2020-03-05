package src;
/**
 * 
 * Necesito una clase Articulo que representa a los artículos del almacén.   
Su estado será: código, descripción, precio de compra, precio de venta y 
 número de unidades (nunca negativas). 
Como comportamiento: Considero que el código va a  generarse de forma automática
 en el constructor, así no puede haber dos  artículos con el mismo código. Esto implica
  que no puede modificarse el  código de un artículo. Sí el resto de las propiedades.
   Podremos mostrar el  artículo, por lo que necesito una representación del artículo
    en forma de  cadena (toString) 
 * 
 * @author Sillero
 *
 */


public class Articulo {
	static private int currentCode=1;
	private int codigo;
	private String descripcion;
	private int precCompra;
	private int precVenta;
	private int unidades;

	/**
	 * 
	 * @param descripcion 
	 * @param precCompra no puede ser menor que 1, si lo es se le asignara 1 por defecto
	 * @param precVenta no puede ser menor que 1, si lo es se le asignara 1 por defecto
	 * @param unidades no puede ser menor que 1, si lo es se le asignara 1 por defecto
	 */
	public Articulo(String descripcion, int precCompra, int precVenta, int unidades) {
		this.codigo = currentCode;
		currentCode += 1;
		
		this.setDescripcion(descripcion);
		this.setPrecCompra(precCompra);
		this.setPrecVenta(precVenta);
		this.setUnidades(unidades);
	}
	
	public Articulo(int codigo) {
		this.codigo=codigo;
	}
	

	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecCompra() {
		return this.precCompra;
	}

	public void setPrecCompra(int precCompra) {
		if(precCompra > 0)
			this.precCompra = precCompra;
		else {
			System.err.println("El precio de compra no puede ser menor de 0, se le ha asinado el valor 0");
			this.precCompra = 0;
		}
	}

	public int getPrecVenta() {
		return this.precVenta;
	}

	public void setPrecVenta(int precVenta) {
		if(precVenta > 0)
			this.precVenta = precVenta;
		else {
			System.err.println("El precio de venta no puede ser menor de 0, se le ha asinado el valor 0");
			this.precVenta = 0;
		}
	}

	public int getUnidades() {
		return this.unidades;
	}

	public void setUnidades(int unidades) {
		if(unidades > 0)
			this.unidades = unidades;
		else {
			System.err.println("El numero de unidades no puede ser menor de 0, se le ha asinado el valor 0");
			this.unidades = 0;
		}
	}
	
	@Override
	public String toString() {
		
		return "Codigo: "+this.getCodigo()+" Descripción: "+this.getDescripcion()+
				" Precio compra: "+this.getPrecCompra()+" Precio venta: "+this.getPrecVenta()
				+" Inventario: "+this.getUnidades() ;
	}
	
	/**
	 * Compara con un objeto, si es articulo y tiene el mismo codigo es igual.
	 * 
	 *  @param obj 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}
