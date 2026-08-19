
package com.mycompany.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Libro> libros = new ArrayList<>();
    
    public static void main(String[] args) {
            
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
    
}