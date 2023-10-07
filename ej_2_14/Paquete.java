package ar.edu.unlu.poo.ej214;

import java.util.ArrayList;
import java.util.List;

public class Paquete {
    private String codigo;
    private String nombre;
    private String destino;
    private Transporte medioDeTransporte;
    private Hospedaje hospedaje;
    private List<GuiaTuristico> excursiones;
    private Double precio = 0.0;
    private Double precioFinal;
    private Integer MaxPaq;
    private static Integer indice = 100;

    public Paquete (String nombre, String destino, Transporte medioDeTransporte, Hospedaje hospedaje, List<GuiaTuristico> excursiones, Double precio, Integer MaxPaq) {
        setNombre(nombre);
        setDestino(destino);
        setMedioDeTransporte(medioDeTransporte);
        setHospedaje(hospedaje);
        setExcursiones(excursiones);
        setPrecio(precio);
        setMaxPaq(MaxPaq);
    }

    public Paquete (String nombre, String destino, Transporte medioDeTransporte, Hospedaje hospedaje, GuiaTuristico excursion, Double precio, Integer MaxPaq) {
        setNombre(nombre);
        setDestino(destino);
        setMedioDeTransporte(medioDeTransporte);
        setHospedaje(hospedaje);
        this.excursiones = new ArrayList<>();
        addExcursiones(excursion);
        setPrecio(precio);
        setMaxPaq(MaxPaq);
    }

    public String getCodigo () {
        return codigo;
    }

    private void setCodigo () {
        this.codigo = indice.toString();
        indice++;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getDestino () {
        return destino;
    }

    public void setDestino (String destino) {
        this.destino = destino;
    }

    public Proveedor getMedioDeTransporte() {
        return medioDeTransporte;
    }

    public void setMedioDeTransporte (Transporte medioDeTransporte) {
        this.medioDeTransporte = medioDeTransporte;
    }

    public Proveedor getHospedaje () {
        return hospedaje;
    }

    public void setHospedaje (Hospedaje hospedaje) {
        this.hospedaje = hospedaje;
    }

    public List<GuiaTuristico> getExcursiones () {
        return excursiones;
    }

    public void setExcursiones (List<GuiaTuristico> excursiones) {
        this.excursiones.addAll(excursiones);
    }

    public void addExcursiones (GuiaTuristico excursion) {
        excursiones.add(excursion);
    }

    @Override
    public String toString () {
        return codigo + " - " + nombre + " - Destino: " + destino + " - Medios de transporte: " + medioDeTransporte.getNombre()
                + " - Hospedaje: " + hospedaje.getNombre() + " - Cantidad de excursiones: " + excursiones.size();
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio (Double precio) {
        this.precio = precio;
    }

    public Double calcularPrecioFinal () {
        this.precioFinal = precio + medioDeTransporte.calcularValorExtra(precio, MaxPaq) + hospedaje.calcularValorExtra(precio, MaxPaq);
        for (GuiaTuristico guia : excursiones) {
            this.precioFinal += guia.calcularValorExtra(MaxPaq);
        }
        return precioFinal;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setMaxPaq(Integer maxPaq) {
        MaxPaq = maxPaq;
    }

    public Integer setMaxPaq() {
        return MaxPaq;
    }
}
