
package com.mycompany.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
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
}