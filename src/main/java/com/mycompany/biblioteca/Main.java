
package com.mycompany.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Crear libro");
            System.out.println("7. Listar libros");
            System.out.println("8. Buscar libro");
            System.out.println("9. Actualizar libro");
            System.out.println("10. Eliminar libro");
            System.out.println("11. Registrar préstamo");
            System.out.println("12. Registrar devolución");
            System.out.println("13. Listar préstamos activos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1: crearCliente(); break;
                case 2: listarClientes(); break;
                case 3:
                    System.out.print("ID a buscar: ");
                    Cliente c = buscarCliente(br.readLine());
                    System.out.println(c != null ? c : "Cliente no encontrado.");
                    break;
                case 4: actualizarCliente(); break;
                case 5: eliminarCliente(); break;
                case 6: crearLibro(); break;
                case 7: listarLibros(); break;
                case 8:
                    System.out.print("Código a buscar: ");
                    Libro l = buscarLibro(br.readLine());
                    System.out.println(l != null ? l : "Libro no encontrado.");
                    break;
                case 9: actualizarLibro(); break;
                case 10: eliminarLibro(); break;
                case 11: crearPrestamo(); break;
                case 12: devolucion(); break;
                case 13: listarPrestamos(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
    
    static void crearCliente() throws IOException {
        System.out.print("ID: ");
        String id = br.readLine();
        System.out.print("Nombre: ");
        String name = br.readLine();
        System.out.print("Telefono: ");
        String phoneNumb = br.readLine();
        System.out.print("Email: ");
        String email = br.readLine();
        
        Cliente c = new Cliente(id, name, phoneNumb, email);
        clientes.add(c);
        System.out.println("Cliente creado correctamente. ");
    }
    
    static void listarClientes(){
        if (clientes.isEmpty()){
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);  
        }
    }
    
    static Cliente buscarCliente(String id){
        for (Cliente c: clientes){
            if (c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }
    
    static void actualizarCliente() throws IOException {
        
        System.out.print("ID del cliente a actualizar: ");
        String id = br.readLine();
        Cliente c = buscarCliente(id);
        
        if (c == null){
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.print("Nuevo nombre (" + c.getName() + "):");
        String name = br.readLine();
        System.out.print("Nuevo telefono (" + c.getName() + "):");
        String phoneNumb = br.readLine();
        System.out.print("Nuevo email (" + c.getEmail() + "): ");
        String email = br.readLine();
        
        c.setName(name);
        c.setPhoneNumb(phoneNumb);
        c.setEmail(email);
        
        System.out.println("Cliente actualizado correctamente.");
    }
    
    static void eliminarCliente() throws IOException {
    System.out.print("ID del cliente a eliminar: ");
    String id = br.readLine();
    Cliente c = buscarCliente(id);

    if (c == null) {
        System.out.println("Cliente no encontrado.");
        return;
    }
    clientes.remove(c);
    System.out.println("Cliente eliminado correctamente.");
    }
    
    static void crearLibro() throws IOException {
    System.out.print("Código: ");
    String codigo = br.readLine();
    System.out.print("Título: ");
    String titulo = br.readLine();
    System.out.print("Año de publicación: ");
    String anio = br.readLine();
    System.out.print("Autor: ");
    String autor = br.readLine();

    Libro l = new Libro(codigo, titulo, anio, autor);
    libros.add(l);
    System.out.println("Libro creado correctamente.");
   }
    
    static void listarLibros() {
    if (libros.isEmpty()) {
        System.out.println("No hay libros registrados.");
        return;
    }
    for (Libro l : libros) {
        System.out.println(l);
    }
   }
    
    static Libro buscarLibro(String codigo) {
    for (Libro l : libros) {
        if (l.getCodigo().equals(codigo)) {
            return l;
        }
    }
    return null;
   }
    
   static void actualizarLibro() throws IOException {
    System.out.print("Código del libro a actualizar: ");
    String codigo = br.readLine();
    Libro l = buscarLibro(codigo);

    if (l == null) {
        System.out.println("Libro no encontrado.");
        return;
    }

    System.out.print("Nuevo título (" + l.getTitulo() + "): ");
    String titulo = br.readLine();
    System.out.print("Nuevo año (" + l.getAnioPublicacion() + "): ");
    String anio = br.readLine();
    System.out.print("Nuevo autor (" + l.getAutor() + "): ");
    String autor = br.readLine();

    l.setTitulo(titulo);
    l.setAnioPublicacion(anio);
    l.setAutor(autor);

    System.out.println("Libro actualizado correctamente.");
   } 
   
   static void eliminarLibro() throws IOException {
    System.out.print("Código del libro a eliminar: ");
    String codigo = br.readLine();
    Libro l = buscarLibro(codigo);

    if (l == null) {
        System.out.println("Libro no encontrado.");
        return;
    }

    libros.remove(l);
    System.out.println("Libro eliminado correctamente.");
   }
   
   static void crearPrestamo() throws IOException {
    System.out.print("ID del préstamo: ");
    String idPrestamo = br.readLine();
    System.out.print("ID del cliente: ");
    String idCliente = br.readLine();
    System.out.print("Código del libro: ");
    String codigoLibro = br.readLine();

    Cliente c = buscarCliente(idCliente);
    Libro l = buscarLibro(codigoLibro);

    if (c == null) {
        System.out.println("Cliente no encontrado.");
        return;
    }
    if (l == null) {
        System.out.println("Libro no encontrado.");
        return;
    }
    if (!l.isDisponible()) {
        System.out.println("El libro no está disponible.");
        return;
    }

    Prestamo p = new Prestamo(idPrestamo, c, l, LocalDate.now());
    prestamos.add(p);
    l.setDisponible(false);
    System.out.println("Préstamo registrado correctamente.");
  }
   
    static void devolucion() throws IOException {
    System.out.print("ID del préstamo a devolver: ");
    String idPrestamo = br.readLine();

    for (Prestamo p : prestamos) {
        if (p.getIdPrestamo().equals(idPrestamo) && p.getEstado().equals("ACTIVO")) {
            p.setEstado("DEVUELTO");
            p.getLibro().setDisponible(true);
            System.out.println("Devolución registrada correctamente.");
            return;
        }
    }
    System.out.println("Préstamo activo no encontrado.");
   }
    
    static void listarPrestamos() {
    boolean hayActivos = false;
    for (Prestamo p : prestamos) {
        if (p.getEstado().equals("ACTIVO")) {
            System.out.println(p);
            hayActivos = true;
        }
    }
    if (!hayActivos) {
        System.out.println("No hay préstamos activos.");
    }
   }
}