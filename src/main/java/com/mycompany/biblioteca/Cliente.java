
package com.mycompany.biblioteca;

public class Cliente extends Persona {
    private String email;
    public Cliente(String id, String name, String phoneNumb, String email) {
        super(id, name, phoneNumb);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     @Override
    public String toString() {
        return super.toString() + " | Email: " + email;
    }
}
