package ar.edu.unlu.poo.ej214;

import java.util.ArrayList;
import java.util.List;

public class Paquete {
    private String codigo;
    private String nombre;
    private String destino;
    private Proveedor medioDeTransporte;
    private Proveedor hospedaje;
    private List<Proveedor> excursiones;
    private Double precio = 0.0;
    private static Integer indice = 100;

    public Paquete (String nombre, String destino, Proveedor medioDeTransporte, Proveedor hospedaje, List<Proveedor> excursiones, Double precio) {
        setNombre(nombre);
        setDestino(destino);
        setMedioDeTransporte(medioDeTransporte);
        setHospedaje(hospedaje);
        setExcursiones(excursiones);
        setPrecio(precio);
    }

    public Paquete (String nombre, String destino, Proveedor medioDeTransporte, Proveedor hospedaje, Proveedor excursion, Double precio) {
        setNombre(nombre);
        setDestino(destino);
        setMedioDeTransporte(medioDeTransporte);
        setHospedaje(hospedaje);
        this.excursiones = new ArrayList<>();
        addExcursiones(excursion);
        setPrecio(precio);
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

    public void setMedioDeTransporte (Proveedor medioDeTransporte) {
        if (medioDeTransporte.getClasificacion().equals(Proveedor.Clasificacion.MEDIOS_DE_TRANSPORTE))
            this.medioDeTransporte = medioDeTransporte;
    }

    public Proveedor getHospedaje () {
        return hospedaje;
    }

    public void setHospedaje (Proveedor hospedaje) {
        if (hospedaje.getClasificacion().equals(Proveedor.Clasificacion.HOSPEDAJES))
            this.hospedaje = hospedaje;
    }

    public List<Proveedor> getExcursiones () {
        return excursiones;
    }

    public void setExcursiones (List<Proveedor> excursiones) {
        for (Proveedor auxiliar : excursiones)
            if (auxiliar.getClasificacion().equals(Proveedor.Clasificacion.EXCURSIONES))
                this.excursiones.add(auxiliar);
    }

    public void addExcursiones (Proveedor excursion) {
        if (excursion.getClasificacion().equals(Proveedor.Clasificacion.EXCURSIONES))
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
        this.precio = precio;           //
    }
}
