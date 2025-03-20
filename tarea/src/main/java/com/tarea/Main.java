package com.tarea;

import java.util.Scanner;

import com.tarea.application.usecase.Equipo.EquipoUseCase;
import com.tarea.domain.repository.EquipoRepository;

public class Main {
    public static void main(String[] args) {
        EquipoRepository repositorio = new EquipoRepositoryImpl(ConnectionFactory.crearConexion());
        EquipoUseCase equipoUseCase = new EquipoUseCase(repositorio);
        try (Scanner sc = new Scanner(System.in)){
            String menu;
            do {
                String menuEquipos; 
                String menuProductos; 
                System.out.println("1.) Entrar a menu de Equipos");
                System.out.println("2.) Entrar a menu de Producto");
                System.out.println("3.) salir....");
                System.out.print("Elige una opcion = ");
                menu = sc.nextLine();
                System.out.println("");
                switch (menu) {
                    case "1":
                        do {
                            System.out.println("Menus de Equipos");
                            System.out.println("1.)Registrar equipos");
                            System.out.println("2.)Buscar equipos");
                            System.out.println("3.)Actualizar datos de un equipos");
                            System.out.println("4.)Listar todos los equipos ");
                            System.out.println("5.)Eliminar equipos");
                            System.out.println("6.)Salir");
                            System.out.print("Elige una opcion = ");
                            menuEquipos = sc.nextLine();
                            System.out.println("");
                            switch (menuEquipos) {
                                case "1":
                                    try {
                                        int id = 0;
                                        System.out.print("Ingrese Nombre del equipo: ");
                                        String name = sc.nextLine();
                                        System.out.print("Ingrese la fecha de creacion del equipo: ");
                                        int yearFoundation = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Ingrese el nombre del entrenador: ");
                                        String coach = sc.nextLine();
                                        clienteCasoUso.registrarEquipo(id, name, yearFoundation, coach);
                                        
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                    }

                                    break;
                                case "2":
                                    try {
                                        System.out.print("Ingrese el ID del equipo: ");
                                        int idBuscar = sc.nextInt();
                                        sc.nextLine();
                                        EquipoUseCase.obtenerEquipos(idBuscar);
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("Error vuelve a intentarlo.");
                                        System.out.println("");
                                    }

                                    break;
                                case "3":
                                    try {
                                        System.out.print("Ingrese el ID del equipo que deseas modificar: ");
                                        int idNuevo = sc.nextInt();
                                        sc.nextLine(); 
                                        System.out.print("Ingrese el nuevo nombre del equipo: ");
                                        String nameNuevo = sc.nextLine();
                                        System.out.print("Ingrese el nuevo año de fundación: ");
                                        int yearFoundationNuevo = sc.nextInt();
                                        sc.nextLine();  
                                        System.out.print("Ingrese el nuevo nombre del entrenador: ");
                                        String coachNuevo = sc.nextLine();
                                        System.out.println("");
                                        System.out.println("Datos anteriores:");
                                        EquipoUseCase.obtenerEquipos(idNuevo);
                                        EquipoUseCase.actualizarEquipos(idNuevo, nameNuevo, yearFoundationNuevo, coachNuevo);
                                        System.out.println("Datos actualizados:");
                                        EquipoUseCase.obtenerEquipos(idNuevo);
                                        System.out.println("");
                                          
                                    } catch (Exception e) {
                                        System.out.println("Error vuelve a intentarlo.");
                                        System.out.println("");
                                    }

                                    break;
                                case "4":
                                    try {
                                        EquipoUseCase.listarEquipo();
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }

                                    break;
                                case "5":
                                    try {
                                        System.out.print("Ingrese el ID del equipo que deseas eliminar: ");
                                        int idEliminar = sc.nextInt();
                                        sc.nextLine();
                                        EquipoUseCase.eliminarEquipo(idEliminar);
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
    
                                    break;
                                case "6":

                                    System.out.println("Saliendo.......");
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("La opción seleccionada no existe, volviendo al menú........");
                                    System.out.println();
                                    break;
                            }
                        } while (!menuEquipos.equals("6"));
                        break;

                    // productos

                    case "2":
                        do {
                            System.out.println("Menus de productos");
                            System.out.println("1.)Registrar Productos");
                            System.out.println("2.)Buscar producto");
                            System.out.println("3.)Actualizar datos de un producto");
                            System.out.println("4.)Mostrar todos los productos ");
                            System.out.println("5.)Eliminar producto");
                            System.out.println("6.)Salir");
                            System.out.print("Elige una opcion = ");
                            menuProductos = sc.nextLine();
                            System.out.println("");
                            switch (menuProductos) {
                                case "1":
                                    try {
                                        int id = 0;
                                        System.out.print("Ingrese Nombre: ");
                                        String nombre = sc.nextLine();
                                        System.out.print("Ingrese el stock: ");
                                        int stock = sc.nextInt();
                                        sc.nextLine();
                                        if (stock >= 0) {
                                            productoCasoUso.registrarProducto(id, nombre, stock);
                                            System.out.println("Producto registrado exitosamente.");     
                                            System.out.println("");
                                        }else{
                                            System.out.println("No esta permitido STOCK negativo");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
           
                                break;
                                case "2":
                                    try {
                                        System.out.print("Ingrese el Id del producto = ");
                                        int idBuscarProducto = sc.nextInt();
                                        sc.nextLine();
                                        productoCasoUso.obtenerProducto(idBuscarProducto);
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
                 
                                break;
                                case "3":
                                    try {
                                        System.out.print("Ingrese el Id del producto a editar = ");
                                        int idProductonuuevo = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Ingrese el nuevo nombre del Producto = ");
                                        String NuevoProducto = sc.nextLine();
                                        System.out.print("Ingrese el nuevo Stock = ");
                                        int NuevoStock = sc.nextInt();
                                        sc.nextLine();
                                        if (NuevoStock >= 0) {
                                            System.out.println("");
                                            System.out.println("Datos anteriores = ");
                                            productoCasoUso.obtenerProducto(idProductonuuevo);
                                            productoCasoUso.actualizarProducto(idProductonuuevo, NuevoProducto, NuevoStock);
                                            System.out.println("");
                                            System.out.println("Datos actualizados = ");
                                            productoCasoUso.obtenerProducto(idProductonuuevo);
                                            System.out.println("");
                                        }else{
                                            System.out.println("No esta permitido STOCK negativo");
                                        }
                                     

                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
                                    break;
                                case "4":
                                    try {
                                        productoCasoUso.listarProducts();
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }

                                    break;
                                case "5":
                                    try {
                                        System.out.print("Ingrese el Id del producto a eliminar = ");
                                        int idEliminarProducto = sc.nextInt();
                                        sc.nextLine();
                                        productoCasoUso.eliminarProducto(idEliminarProducto);
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
                         
                                    break;
                                case "6":
                                    System.out.println("Saliendo.......");
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("Dato seleccionado no existe, volviendo a menu........");
                                    System.out.println();
                                    break;
                            }
                        } while (!menuProductos.equals("6"));
                        break;

                    case "3":
                        System.out.println("Saliendo.......");
                        System.out.println();
                        break;
                    default:
                        System.out.println("Dato seleccionado no existe, volviendo a menu........");
                        System.out.println();
                    break;
                }   
            }while(!menu.equals("3"));
        }catch(Exception e) {
            System.out.println("Error por favor vuelve a iniciar el programa");
        }
    }
}