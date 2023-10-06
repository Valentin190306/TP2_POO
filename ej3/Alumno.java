package ar.edu.unlu.poo.ej3;

public class Alumno {
    private static Integer indice = 0;
    private String legajo;
    private String DNI;
    private String nombre;
    private String telefono;
    private String email;

    public Alumno (String DNI, String nombre, String telefono, String email) {
        setLegajo();
        setDNI(DNI);
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo() {
        int valor = indice + 10000;
        this.legajo = Integer.toString(valor);
        indice++;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString () {
        return legajo + " - " + nombre + " - " + telefono + " - " + email;
    }
}
