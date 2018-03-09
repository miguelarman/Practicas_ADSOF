/**
 * 
 */
package cine;


/**
 * @author eps
 *
 */
public class EntradaDiaEspectador extends Entrada {

	
	public EntradaDiaEspectador(Sesion sesion, Float precio) {
		super(sesion, precio);
		// TODO Auto-generated constructor stub
	}
	public Float getPrecio() {
		return super.getPrecio() * 70/100;
	}

}
