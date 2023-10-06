package ar.edu.unlu.poo.ej214;

import java.time.LocalDate;

public class Venta {
    private Integer nro;
    private Cliente cliente;
    private Paquete paquete;
    private Double abono;
    private final LocalDate fecha = LocalDate.now();
    private static Integer indice = 0;

    public Venta (Cliente cliente, Paquete paquete) {
        setCliente(cliente);
        setPaquete(paquete);
        setNro();
        setAbono();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente (Cliente cliente) {
        this.cliente = cliente;
    }

    public Paquete getPaquete () {
        return paquete;
    }

    public void setPaquete (Paquete paquete) {
        this.paquete = paquete;
    }

    public Double getAbono () {
        return abono;
    }

    private void setAbono () {
        this.abono = paquete.getPrecio();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Integer getNro () {
        return nro;
    }

    public void setNro () {
        this.nro = indice;
        indice++;
    }

    @Override
    public String toString () {
        return nro.toString() + " - " + cliente.getDNI() + " - " + paquete.getNombre() + " - " + abono.toString() + " - " + fecha.toString();
    }
}
