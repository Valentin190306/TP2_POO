package ar.edu.unlu.poo.ej4512;

import java.time.LocalDate;

public class Compra extends Transferencia {
    private Double montoFinal;
    private LocalDate fecha;
    private String descripcion;

    public Compra (String descripcion, Double costo) {
        super(costo);
        setDescripcion(descripcion);
        setMontoFinal(costo);
    }

    public LocalDate getFecha () {
        return fecha;
    }

    public void pagar (Double monto) {
        super.monto -= monto;
    }

    private void setFecha (LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMontoFinal () {
        return montoFinal;
    }

    public void setMontoFinal (Double montoFinal) {
        this.montoFinal = montoFinal;
    }

    private Double deuda() {
        return (montoFinal - super.monto);
    }

    @Override
    public String toString () {
        return " - Descripcion: " + descripcion + " - Precio final: " + montoFinal.toString() + " - Deuda: " + deuda().toString();
    }
}
