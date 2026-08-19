package com.mycompany.biblioteca;

public class Persona {
    private String id;
    private String name;
    private String phoneNumb;

    public Persona(String id, String name, String phoneNumb) {
        this.id = id;
        this.name = name;
        this.phoneNumb = phoneNumb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + name + " | Teléfono: " + phoneNumb;
    }
}
