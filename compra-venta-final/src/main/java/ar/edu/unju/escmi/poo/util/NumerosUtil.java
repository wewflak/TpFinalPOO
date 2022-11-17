package ar.edu.unju.escmi.poo.util;

import java.text.DecimalFormat;

public class NumerosUtil {

	public static String limitarPrecisionDouble(double numero) {
		String nuevoNumero;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		nuevoNumero = numberFormat.format(numero);
		return nuevoNumero;
	}
	public static boolean controlarCvv(int numero) {
		if(numero <100 || numero>999) {
			System.out.println("Ingrese un numero de tres digitos");
			return true;
		}
		return false;
		
	}
	
}
