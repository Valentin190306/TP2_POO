package ar.edu.unlu.poo.ej1;

import ar.edu.unlu.poo.ej1.SistemaDelClub;

import java.time.LocalDate;

public class Socio {
    private String nombre;
    private Integer nroSocio;
    private final LocalDate fechaDeSubscripcion;
    private String email;
    private String direccion;
    private Enum<SistemaDelClub.Subscripcion> subscripcion;

    public Socio (Integer nroSocio, String nombre, String email, String direccion, Enum<SistemaDelClub.Subscripcion> subscripcion) {
        setNroSocio(nroSocio);
        setNombre(nombre);
        setEmail(email);
        setDireccion(direccion);
        setSubscripcion(subscripcion);
        this.fechaDeSubscripcion = LocalDate.now();
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNroSocio(int nroScio) {
        this.nroSocio = nroScio;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    protected void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    protected void setSubscripcion(Enum subscripcion) {
        this.subscripcion = subscripcion;
    }

    public Enum getSubscripcion () {
        return subscripcion;
    }

    public LocalDate getFechaDeSubscripcion() {
        return fechaDeSubscripcion;
    }

    public String credencial () {
        return nroSocio.toString() + " - " + nombre + " - " + subscripcion.toString();
    }
}
