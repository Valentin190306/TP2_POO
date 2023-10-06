package ar.edu.unlu.poo.ej214;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String DNI;
    private String nombre;
    private List<Paquete> paquetesDeTurismo = new ArrayList<>();
    private Double abono = 0.0;

    public Cliente (String DNI, String nombre, Paquete paqueteDeTurismo) {
        setDNI(DNI);
        setNombre(nombre);
        agregarPaqueteDeTurismo(paqueteDeTurismo);
    }

    public Cliente (String DNI, String nombre, List<Paquete> paquetesDeTurismo) {
        setDNI(DNI);
        setNombre(nombre);
        setPaquetesDeTurismo(paquetesDeTurismo);
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

    public List<Paquete> getPaqueteDeTurismo() {
        return paquetesDeTurismo;
    }

    public void agregarPaqueteDeTurismo(Paquete paquete) {
        paquetesDeTurismo.add(paquete);
        abono += paquete.getPrecio();
    }

    public void setPaquetesDeTurismo (List<Paquete> paquetesDeTurismo) {
        this.paquetesDeTurismo = paquetesDeTurismo;
        for (Paquete paquete : paquetesDeTurismo)
            abono += paquete.getPrecio();
    }

    public Double getAbono() {
        return abono;
    }

    @Override
    public String toString () {
        return DNI + " - " + nombre + " - " + " - Cantidad de paquetes comprados: " + paquetesDeTurismo.size() + " - Abono total: " + abono;
    }
}
