package ar.edu.unju.escmi.poo.principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Detalle;
import ar.edu.unju.escmi.poo.components.Factura;
import ar.edu.unju.escmi.poo.components.Producto;
import ar.edu.unju.escmi.poo.components.Rol;
import ar.edu.unju.escmi.poo.components.Usuario;
import ar.edu.unju.escmi.poo.dao.imp.ClienteDaoIMP;
import ar.edu.unju.escmi.poo.dao.imp.DetalleDaoIMP;
import ar.edu.unju.escmi.poo.dao.imp.FacturaDaoIMP;
import ar.edu.unju.escmi.poo.dao.imp.ProductoDaoIMP;
import ar.edu.unju.escmi.poo.dao.imp.RolDaoIMP;
import ar.edu.unju.escmi.poo.dao.imp.StockDaoIMP;
import ar.edu.unju.escmi.poo.dao.imp.UsuarioDaoIMP;
import ar.edu.unju.escmi.poo.util.ClienteUtil;
import ar.edu.unju.escmi.poo.util.FechaUtil;
import ar.edu.unju.escmi.poo.util.ProductoUtil;
import ar.edu.unju.escmi.poo.util.StockUtil;

public class Principal {

	public static void main(String[] args) {
		ProductoUtil productoUtil = new ProductoUtil();
		StockUtil stockUtil = new StockUtil();
		//productoUtil.inicializarProductos();
		//stockUtil.inicializarStock();
		//ClienteUtil.cargarCliente();
		ProductoDaoIMP productoService = new ProductoDaoIMP();
		ClienteDaoIMP ClienteService = new ClienteDaoIMP();
		UsuarioDaoIMP usuarioService = new UsuarioDaoIMP();
		StockDaoIMP stockService = new StockDaoIMP();
		FacturaDaoIMP facturaService =  new FacturaDaoIMP();
		DetalleDaoIMP detalleService = new DetalleDaoIMP();
		RolDaoIMP rolService = new RolDaoIMP();
		Rol rol = new Rol("vendedor");
		Rol rol2 = new Rol("cliente");
		//rolService.agregarRol(rol);
		//rolService.agregarRol(rol2);
		Usuario usuario = new Usuario("aasss", "123", rolService.buscarRol(1));
		Cliente cliente = new Cliente("ddd","aaaa", (long)5151, LocalDate.now(), usuario);
		//ClienteService.agregarCliente(cliente, usuario);
		Cliente clientBuscado= new Cliente();
		//System.out.println(ClienteService.buscarCliente((long)5151).getApellido());
		//ClienteService.obtenerClientes().stream().forEach(c-> System.out.println(c.getApellido()));
		String fecha2;
		Usuario user = null;
		Cliente client = null;
		boolean band=false, tiempoActivo = false;
		int op=0,op1=0, opPrimigenio=0;
		LocalDate date = null;
		Long doc=null;
		String correo, contrasena="";
		Scanner scan = new Scanner( System.in);
		//stockService.mostrarStocks().stream().forEach(s-> System.out.println(s.toString()));
		System.out.println(stockService.buscarStockPorProducto((long)779696259).getCantidad());
			do {
				System.out.println("\n1. Iniciar Sesión");
				System.out.println("2. Salir");
				
				band=true;

				try {
					opPrimigenio=0;
				opPrimigenio = scan.nextInt();
				}catch(InputMismatchException ime) {
					scan.next();
					System.out.println("Ingrese el tipo correcto de dato");
				}
				switch(opPrimigenio) {
				case 1:
					band=false;
					while(!band) {
						System.out.println("\n*/*/*/**/*/   Menu   /*/*/*/*/*");
						System.out.println("Ingrese su email");
						//doc = scan.nextLong();
						correo = scan.next();
						System.out.println("Ingrese su contraseña");
						contrasena = scan.next();
						try {
						band=true;
						user = usuarioService.buscarUsuario(correo, contrasena);
						System.out.println(user.getEmail());
						if(user.getRol().getDescripcion().equals("vendedor")) {
							do {
								System.out.println("\n+++--- Menu de Vendedor ---+++");
								System.out.println("1. Alta de cliente");
								System.out.println("2. Realizar Venta");
								System.out.println("3. Listado de Clientes");
								System.out.println("4. Listado de Facturas");
								System.out.println("5. Buscar factura por nro de Factura");
								System.out.println("6. Cerrar Sesion");
								try {
									op = scan.nextInt();
								switch(op) {
								
								case 1:
									band=false;
									
									try {
									String nm, ap, em, ps, fdn;
									Long dn;
									LocalDate date1;
										System.out.println("Ingrese el nombre del cliente");
										nm = scan.next();
										System.out.println("Ingrese el apellido del cliente");
										ap = scan.next();
										while(!band) {
										System.out.println("Ingrese el dni del cliente");
										try {
											dn = scan.nextLong();
											band=true;
											System.out.println("Ingrese el email del usuario del cliente");
											em = scan.next();
											System.out.println("Ingrese la contrasena del usuario del cliente");
											ps = scan.next();
											System.out.println("Ingrese la fecha de nacimiento del cliente [dd/MM/yyyy]");
											fdn = scan.next();
											date1 = FechaUtil.convertirFecha(fdn);
											System.out.println("Seleccione el rol del usuario");
											rolService.mostrarRoles().stream().forEach(r -> System.out.println(r.getIdRol() + r.getDescripcion()));
											op=0;
											try {
												op =scan.nextInt();
												
												Usuario usuarioNuevo = new Usuario(em, ps, rolService.buscarRol(op));
												Cliente clienteNuevo =  new Cliente(nm, ap, dn, date1, usuarioNuevo);
												ClienteService.agregarCliente(clienteNuevo, usuarioNuevo);
												System.out.println(ClienteService.buscarCliente(dn).getApellido());
											}catch(Exception ime) {
												if(ime instanceof InputMismatchException) {
													System.out.println("\nIngrese el tipo correcto de dato\n");
													scan.next();
												}else {
												System.out.println(ime);
												}
											}
											
										}catch(Exception ime) {
											if(ime instanceof InputMismatchException) {
												System.out.println("\nIngrese el tipo correcto de dato\n");
												scan.next();
											}else {
											System.out.println(ime);
											}
										}
										}
									}catch(Exception e) {
										System.out.println(" ");
									}
									
									break;
								case 2:
									Long nFac, dni, cPro;
									Integer cant;
									boolean band1=false,band2=false,band3=false;
									String answer="s";
									System.out.println("Ingrese el dni del cliente");
									try {
										dni =scan.nextLong();
										Cliente clienteFactura = ClienteService.buscarCliente(dni);
										if(clienteFactura.getDni()>0 || clienteFactura.getDni()!=null) {
											while(!band1) {
											System.out.println("Ingrese el numero de factura");
											try {
												nFac = scan.nextLong();
												Factura FacturaNueva = new Factura();
												band1=true;
												List<Detalle> detallesFactura = new ArrayList<Detalle>();
												Double tot = null,subTot = null;
												FacturaNueva.setClienteFactura(clienteFactura);
												FacturaNueva.setCodFactura(nFac);
												FacturaNueva.setFechaFactura(LocalDate.now());
												FacturaNueva.setDetalles(detallesFactura);
												FacturaNueva.setTotal(tot);
												FacturaNueva.setSubtotal(subTot);
												facturaService.agregarFactura(FacturaNueva);
												while(answer.equals("s")) {
													while(!band2) {
													System.out.println("Ingrese el codigo de producto");
													try {
														Producto productoDetalle = new Producto();
														cPro = scan.nextLong();
														band2=true;
														productoDetalle = productoService.buscarProductoPorCodigo(cPro);
														if(stockService.buscarStockPorProducto(productoDetalle.getCodigoProducto()).getCantidad()>0) {
															while(!band3) {
															System.out.println("Ingrese la cantidad a comprar del producto");
															try {
																cant = scan.nextInt();
																band3=true;
																if(stockService.buscarStockPorProducto(productoDetalle.getCodigoProducto()).getCantidad()>cant) {
																	stockService.decrementarStockProducto(stockService.buscarStockPorProducto(productoDetalle.getCodigoProducto()), cant);
																	System.out.println(stockService.buscarStockPorProducto((long)779696259).getCantidad());
																	Double importe=(double) 0;
																	importe = productoDetalle.getPrecioUnitario()*cant;
																	Detalle detalleNuevo = new Detalle(productoDetalle, productoDetalle.getDescuento(), cant, importe, FacturaNueva);
																	detalleService.crearDetalle(detalleNuevo);
																	}else {
																	System.out.println("\n El stock de producto no satisface la cantidad solicitada\n");
																	answer="n";
																}
															}catch(Exception e) {
																if(e instanceof InputMismatchException) {
																	System.out.println("\nIngrese el tipo correcto de dato");
																}
															}
														}
														}else {
															System.out.println("\nEl producto ya no tiene stock\n");
															answer="n";
														}
													}catch(Exception e) {
														if(e instanceof InputMismatchException) {
															System.out.println("\nIngrese el tipo correcto de dato");
														}
													}
												}
												}
											}catch(Exception e) {
												if(e instanceof InputMismatchException) {
													System.out.println("\nIngrese el tipo correcto de dato");
												}
											}
										}
										}
									}catch(Exception e) {
										if(e instanceof InputMismatchException) {
											System.out.println("\nIngrese el tipo correcto de dato");
										}
									}
									
									break;
								case 3:
									ClienteService.obtenerClientes().stream().forEach(c-> System.out.println(c.toString()));
									break;
								case 4:
									break;
								case 5:
									break;
								case 6:
									System.out.println("Sesion cerrada...");
									break;
								default:
									System.out.println("Ingrese alguna de las opciones presentadas");
									break;
								
								}
								}catch(Exception ime) {
									System.out.println(ime);
									if(ime instanceof InputMismatchException) {
										System.out.println("\n Ingrese el tipo correcto de dato");
									}
								}
							}while(op!=6);
						}else {
							if(user.getRol().getDescripcion().equals("cliente")) {
								op1=0;
								do {
									System.out.println("1. Buscar Factura por Numero");
									System.out.println("2. Listar Facturas del Cliente");
									System.out.println("3. Cerrar Sesion");
									op1 = scan.nextInt();
									try {
										switch(op1) {
									
										case 1:
											
											break;
										case 2:
											break;
										case 3:
											break;
										default:
											break;
										
									}
									}catch(Exception ime) {
										System.out.println(ime);
										if(ime instanceof InputMismatchException) {
											System.out.println("\n Ingrese el tipo correcto de dato");
										}
									}
									
									
								}while(op1!=3);
							}
						}
					}catch(Exception e) {
						if(e instanceof NullPointerException) {
							System.out.println("No existe el cliente");
						}
					}
				
				}
				case 2:
					System.out.println("Programa Finalizado...");
					break;
				default:
					System.out.println("Ingrese una de las opciones presentadas");
					break;
				}
				
				
			}while(opPrimigenio!=2);
	
	}
}
