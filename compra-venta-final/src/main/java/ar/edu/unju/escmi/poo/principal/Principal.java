package ar.edu.unju.escmi.poo.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.hibernate.exception.ConstraintViolationException;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Detalle;
import ar.edu.unju.escmi.poo.components.Factura;
import ar.edu.unju.escmi.poo.components.Producto;
import ar.edu.unju.escmi.poo.components.Rol;
import ar.edu.unju.escmi.poo.components.Stock;
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

	public static void main(String[] args) throws Exception {
		ProductoUtil productoUtil = new ProductoUtil();
		StockUtil stockUtil = new StockUtil();
		productoUtil.inicializarProductos();
		stockUtil.inicializarStock();
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
		rolService.agregarRol(rol);
		rolService.agregarRol(rol2);
		Usuario usuario = new Usuario("ddd","aaaa", (long)5151, LocalDate.now(),"aasss", "123", rolService.buscarRol(1));
		usuarioService.agregarUsuario(usuario);
		//ClienteService.agregarCliente(cliente);
		//ClienteService.agregarUsuarioACliente(cliente, usuario);
		//System.out.println(ClienteService.buscarCliente((long)5151).getApellido());
		//ClienteService.obtenerClientes().stream().forEach(c-> System.out.println(c.getApellido()));
		String fecha2;
		Optional<Usuario> comprobarCliente = Optional.empty();
		Optional<Factura> comprobarFactura = Optional.empty();
		Optional<Usuario> comprobarUsuario = Optional.empty();
		Optional<Stock> comprobarStock = Optional.empty();
		Optional<Detalle> comprobarDetalle = Optional.empty();
		Usuario user = null;
		Cliente client = null;
		boolean band=false, tiempoActivo = false;
		int op=0,op1=0, opPrimigenio=0;
		LocalDate date = null;
		Long doc=null;
		String correo, contrasena="";
		Scanner scan = new Scanner( System.in);
		stockService.mostrarStocks().stream().forEach(s-> System.out.println(s.toString()));
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
					try {
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
						System.out.println(user.getDni());
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
									LocalDate date1=null;
									DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
										System.out.println("Ingrese el nombre del cliente");
										nm = scan.next();
										System.out.println("Ingrese el apellido del cliente");
										ap = scan.next();
										while(!band) {
										System.out.println("Ingrese el dni del cliente");
										try {
											dn = scan.nextLong();
											comprobarCliente = usuarioService.comprobarExistenciaDNI(dn);
											if(comprobarCliente.isEmpty()) {
												band=true;
												System.out.println("Ingrese la fecha de nacimiento del cliente [dd/MM/yyyy]");
												fdn = scan.next();
												band=false;
												while(!band) {
												System.out.println("Ingrese el email del usuario del cliente");
												em = scan.next();
												
												comprobarUsuario = usuarioService.comprobarExistenciaEmail(em);
												if(comprobarUsuario.isEmpty()) {
													band=true;
													band=false;
													while(!band) {
													System.out.println("Ingrese la contrasena del usuario del cliente");
													ps = scan.next();
													Optional<Usuario> comprobarContrasena = Optional.empty();
													comprobarContrasena = usuarioService.comprobarExistenciaContrasena(ps);
													if(comprobarContrasena.isEmpty()) {
														band=true;
														//DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
														date1 = LocalDate.parse(fdn, formato);
														System.out.println("Seleccione el rol del usuario");
														rolService.mostrarRoles().stream().forEach(r -> System.out.println(r.getIdRol() + r.getDescripcion()));
														op=0;
														try {
															op =scan.nextInt();
															
															Usuario usuarioNuevo = new Usuario(nm, ap, dn, date1,em, ps, rolService.buscarRol(op));
															usuarioService.agregarUsuario(usuarioNuevo);
															System.out.println(usuarioService);
														}catch(Exception ime) {
															if(ime instanceof InputMismatchException) {
																System.out.println("\nIngrese el tipo correcto de dato\n");
																scan.next();
															}else {
															System.out.println(ime);
															}
														}
													}else {
														System.out.println(" Esta contrasena ya fue cargada\n");
													}
												}
												}else {
													System.out.println("Este email ya fue cargado\n");
												}
												}
											}else {
												System.out.println("Este DNI ya fue cargado\n");
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
									boolean band1=false,band2=false,band3=false, bandFinal=false;
									Integer answer=0;
									System.out.println("Ingrese el dni del cliente");
									while(!bandFinal) {
									try {
										dni =scan.nextLong();
										Usuario clienteFactura = usuarioService.buscarUsuarioDni(dni);
										if(clienteFactura.getDni()>0 || clienteFactura.getDni()!=null) {
											while(!band1) {
											System.out.println("Ingrese el numero de factura");
											try {
												while(!bandFinal) {
												nFac = scan.nextLong();
												comprobarFactura = facturaService.comprobarExistenciaNroFactura(nFac);
												if(comprobarFactura.isEmpty()) {
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
													do{
														while(band2 == false) {
															band=false;
															while(!band) {
														System.out.println("Ingrese el codigo de producto");
														try {
															Producto productoDetalle = new Producto();
															cPro = scan.nextLong();
															band2=true;comprobarStock = stockService.comprobarExistenciaProducto(cPro);
															comprobarDetalle = facturaService.comprobarExistenciaDetalle(cPro, FacturaNueva);
															if(comprobarStock.isPresent() && comprobarDetalle.isEmpty()) {
																band=true;
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
																		facturaService.agregarDetalle(detalleNuevo, FacturaNueva);
																		System.out.println("Quiere agregar otro detalle? no=2");
																		answer =  scan.nextInt();
																		if(answer==2) {
																		System.out.println(answer);
																		facturaService.calcularSubtotal(FacturaNueva);
																		facturaService.calcularTotal(FacturaNueva);
																		facturaService.mostrarFactura(FacturaNueva);
																		bandFinal=true;
																		}else {
																			System.out.println(answer);
																			return;
																		}
																		
																		}else {
																		System.out.println("\n El stock de producto no satisface la cantidad solicitada\n");
																		
																	}
																}catch(Exception e) {
																	if(e instanceof InputMismatchException) {
																		System.out.println("\nIngrese el tipo correcto de dato");
																	}
																	System.out.println(e);
																}
															}
															}else {
																System.out.println("\nEl producto ya no tiene stock\n");
																
															}
															}else {
																if(comprobarStock.isEmpty()) {
																System.out.println("No existe un producto con ese codigo\n");
																}else if(comprobarDetalle.isPresent()) {
																	System.out.println("Ya esta el producto registrado en el detalle\n");
																}
															}
														}catch(Exception e) {
															if(e instanceof InputMismatchException) {
																System.out.println("\nIngrese el tipo correcto de dato");
															}else if(e instanceof NonUniqueResultException) {
																System.out.println("\n Ya existe una factura con ese codigo2\n");}
															else if(e instanceof NullPointerException) {
																System.out.println("No existe producto con ese codigo\n");
															}else if(e instanceof RollbackException) {
																System.out.println("Ya existe factura con ese codigo5\n");
															}else if(e instanceof PersistenceException) {
																System.out.println("aaaaaaaaa");
															}else if(e instanceof ConstraintViolationException) {
																System.out.println("bbbbbbbbbbbbbbbbbbb");
															}
															System.out.println(e);
														}
													}
														}
													}while(answer!=2);
												}else {
													System.out.println("Este codigo de factura ya fue usado\n");
												}
												}
											}catch(Exception e) {
												if(e instanceof InputMismatchException) {
													System.out.println("\nIngrese el tipo correcto de dato");
												}else if(e instanceof NonUniqueResultException) {
													System.out.println("\n Ya existe una factura con ese codigo3\n");
												}else if(e instanceof RollbackException) {
													System.out.println("Ya existe factura con ese codigo4\n");
												}else if(e instanceof PersistenceException) {
													System.out.println("aaaaaaaaa");
												}else if(e instanceof ConstraintViolationException) {
													System.out.println("bbbbbbbbbbbbbbbbbbb");
												}
											}
										}
										}
									}catch(Exception e) {
										if(e instanceof InputMismatchException) {
											System.out.println("\nIngrese el tipo correcto de dato");
										}else if(e instanceof NullPointerException) {
											System.out.println("No existe un cliente con ese dni\n");
										}else if(e instanceof RollbackException) {
											System.out.println("Ya existe factura con ese codigo8\n");
											bandFinal=true;
										}
										System.out.println(e);
									}
									}
									break;
								case 3:
									usuarioService.obtenerUsuarios().stream().forEach(u-> System.out.println(u.toString()));
									break;
								case 4:
									dni=(long)0;
									band=false;
									while(!band) {
									System.out.println("Ingrese el numero de dni del cliente");
									try {
										dni = scan.nextLong();
										band=true;
										comprobarCliente = Optional.empty();
										comprobarCliente = usuarioService.comprobarExistenciaDNI(dni);
										if(comprobarCliente.isPresent()) {
										facturaService.retornarFacturaPorCliente(dni).stream().forEach(f-> facturaService.mostrarFactura(f));
										}else {
											System.out.println("  No existe cliente con ese dni\n");
										}
										}catch(Exception e){
										System.out.println(e);
									}
									}
									
									break;
								case 5:
									Long codeTicket=(long)0;
									band=false;
											while(!band) {
									System.out.println("Ingrese el codigo de factura");
									try {
										codeTicket = scan.nextLong();
										band=true;
										comprobarFactura = Optional.empty();
										comprobarFactura = facturaService.comprobarExistenciaNroFactura(codeTicket);
										if(comprobarFactura.isPresent()) {
										facturaService.mostrarFactura(facturaService.buscarFacturaPorId(codeTicket));
										}else {
											System.out.println("  No existe factura con ese codigo\n");
										}
									}catch(Exception e) {
										System.out.println(e);
										if(e instanceof NullPointerException) {
											System.out.println("\nLa factura no existe");
										}
									}
											}
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
											Long codeTicket=(long)0;
											band=false;
											while(!band) {
											System.out.println("Ingrese el codigo de factura");
											try {
												codeTicket = scan.nextLong();
												band=true;
												comprobarFactura = Optional.empty();
												comprobarFactura = facturaService.comprobarExistenciaNroFactura(codeTicket);
												if(comprobarFactura.isPresent()) {
												facturaService.mostrarFactura(facturaService.mostrarFacturasPorCliente(client.getDni(), codeTicket));
												}else {
													System.out.println("  No existe factura con ese codigo\n");
												}
											}catch(Exception e) {
												System.out.println(e);
												if(e instanceof NullPointerException) {
													System.out.println("\nLa factura no existe");
												}else if(e instanceof NoResultException) {
													System.out.println("\n El cliente no tiene registrada una factura con ese codigo");
												}
											}
											}
											break;
										case 2:
											facturaService.retornarFacturaPorCliente(user.getDni()).stream().forEach(f-> facturaService.mostrarFactura(f));
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
						}else if(e instanceof NoResultException) {
							System.out.println("\nNo existe el usuario\n");
						}
						System.out.println(e);
					}
				
				}
				}catch(Exception e) {
					if(e instanceof NoResultException) {
						System.out.println("aaaaa");
					}else if(e instanceof NullPointerException) {
						System.out.println("No existe el cliente");
					}else {
						System.out.println(e);
					}
				}
					break;
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
