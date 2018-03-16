/**
 * 
 */
package cine;

import java.util.Calendar;


/**
 * @author eps
 *
 */
public class EntradaDiaEspectador extends Entrada {
	private static Float descuento = (float) 0.3;
	
	public EntradaDiaEspectador(Sesion sesion, Float precio) {
		super(sesion, precio);
	}
	public Float getPrecio() {
		return super.getPrecio() * (1 - descuento);
	}
	
	public static void setDiscount (Float descuento_) {
		descuento = descuento_;
	}
	
	
	public static Boolean isFechaEspectador (Calendar fecha) {
		
		int dayOfWeek = fecha.get(Calendar.DAY_OF_WEEK);
		
		if (dayOfWeek == Calendar.WEDNESDAY) {
			return true;
		} else {
			return false;
		}
		
		
	}
}
