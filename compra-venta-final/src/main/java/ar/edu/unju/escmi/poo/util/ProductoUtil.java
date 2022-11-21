package ar.edu.unju.escmi.poo.util;

import ar.edu.unju.escmi.poo.components.Producto;
import ar.edu.unju.escmi.poo.dao.imp.ProductoDaoIMP;

public class ProductoUtil {

	ProductoDaoIMP productoService =  new ProductoDaoIMP();
	public void inicializarProductos() {
		productoService.agregarProducto(new Producto("Aire Acondicionado Hisense", "Split On/Off 2750W FC", (long) 779696259, "China", (double) 116664, 25));
		productoService.agregarProducto(new Producto("Lavarropa Samsung", "Lavarropas Samsung WW90J5410GS 9.0Kg Silver Inverter", (long) 779696266, "Corea del Sur",(double)202299, 30));
		productoService.agregarProducto(new Producto("Celular Motorola", "Moto G41 Negro Onix", (long) 779089483,"Estados Unidos", (double) 116664, 25));
		productoService.agregarProducto(new Producto("Celular Motorola", "Moto G82 Negro Onix",(long) 779696294,"Estados Unidos", (double) 116664, 30));
//		productos.add(new Producto("Heladera", "Columbia", "Heladera con Freezer 317 lts Blanca", "Argentina", (long) 779703956, 116664));
//		productos.add(new Producto("Heladera", "Drean", "Heladera no frost R600", "Argentina", (long) 779710252, 116664));
//		productos.add(new Producto("Lavarropa", "Samsung", "Lavarropas Samsung WW90J5410GS 9.0Kg Silver Inverter", "Corea del Sur", (long) 880164323, 116664));
//		productos.add(new Producto("Lavarropa", "LG", "Lavarropas Blanco 8.5Kg", "Corea del Sur", (long) 779065394, 116664));
//		productos.add(new Producto("Televisor", "Noblex", "Smart TV 4k 50' SO Android TV", "Argentina", (long) 779696293, 116664));
//		productos.add(new Producto("Televisor", "Hitachi", "Android TV Hitachi 55' 4k CDH-LE554K Smart21 ", "Japon", (long) 779694110, 116664));
	}
public ProductoUtil() {
	// TODO Auto-generated constructor stub
}	
}
