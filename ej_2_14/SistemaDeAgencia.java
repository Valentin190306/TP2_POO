package ar.edu.unlu.poo.ej214;

import java.time.LocalDate;
import java.util.*;

public class SistemaDeAgencia {
    private static SistemaDeAgencia instancia = null;
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Paquete> paquetesDeTurismo = new ArrayList<>();
    private final List<Proveedor> proveedores = new ArrayList<>();
    private final List<Venta> ventas = new ArrayList<>();
    public static SistemaDeAgencia obtenerInstancia () {
        if (instancia == null)
            instancia = new SistemaDeAgencia();
        return instancia;
    }

    public void altaDeVenta (Venta nuevaVenta) {
        if (buscarVenta(nuevaVenta) == null)
            ventas.add(nuevaVenta);
    }

    public void bajaDeVenta (Venta venta) {
        Venta ventaBorrada = buscarVenta(venta);
        if (ventaBorrada != null)
            ventas.remove(ventaBorrada);
    }

    public Venta buscarVenta (Venta venta) {
        if (ventas.isEmpty())
            return null;
        Venta ventaEncontrada = null;
        for (Venta auxiliar : ventas) {
            if (auxiliar.getNro().equals(venta.getNro())) {
                ventaEncontrada = auxiliar;
                break;
            }
        }
        return ventaEncontrada;
    }

    public void altaDePaquete (Paquete nuevoPaquete) {
        if (buscarPaquete(nuevoPaquete) == null)
            paquetesDeTurismo.add(nuevoPaquete);
    }

    public void bajaDePaquete (Paquete paquete) {
        Paquete paqueteBorrado = buscarPaquete(paquete);
        if (paqueteBorrado != null)
            paquetesDeTurismo.remove(paqueteBorrado);
    }

    public Paquete buscarPaquete (Paquete paquete) {
        if (paquetesDeTurismo.isEmpty())
            return null;
        Paquete paqueteEncontrado = null;
        for (Paquete auxiliar : paquetesDeTurismo) {
            if (auxiliar.getCodigo().equals(paquete.getCodigo())) {
                paqueteEncontrado = auxiliar;
                break;
            }
        }
        return paqueteEncontrado;
    }

    public void altaDeProveedor (Proveedor nuevoProveedor) {
        if (buscarProveedor(nuevoProveedor) == null)
            proveedores.add(nuevoProveedor);
    }

    public void bajaDeProveedor (Proveedor proveedor) {
        Proveedor proveedorBorrado = buscarProveedor(proveedor);
        if (proveedorBorrado != null)
            proveedores.remove(proveedorBorrado);
    }

    public Proveedor buscarProveedor (Proveedor proveedor) {
        if (proveedores.isEmpty())
            return null;
        Proveedor proveedorEncontrado = null;
        for (Proveedor auxiliar : proveedores) {
            if (auxiliar.getCUIT().equals(proveedor.getCUIT())) {
                proveedorEncontrado = auxiliar;
                break;
            }
        }
        return proveedorEncontrado;
    }

    public List<Venta> ventasDelMes () {
        ventas.sort(new VentasComparator());
        List<Venta> ventasDelMes = new ArrayList<>();
        for (Venta auxiliar : ventas) {
            if (auxiliar.getFecha().getMonth().equals(LocalDate.now().getMonth()))
                ventasDelMes.add(auxiliar);
        }
        return ventasDelMes;
    }

    public String destinoPopular () {
        Map<String, Integer> contadorDeDestinos = new HashMap<>();
        for (Venta venta : ventas) {
            String destino = venta.getPaquete().getDestino();
            if (contadorDeDestinos.containsKey(destino))
                contadorDeDestinos.put(destino, contadorDeDestinos.get(destino) + 1);
            else
                contadorDeDestinos.put(destino, 1);
        }

        String destinoConMayorRepeticion = null;
        int mayorRepeticion = 0;

        for (Map.Entry<String, Integer> entrada : contadorDeDestinos.entrySet()) {
            if (entrada.getValue() > mayorRepeticion) {
                destinoConMayorRepeticion = entrada.getKey();
                mayorRepeticion = entrada.getValue();
            }
        }
        return destinoConMayorRepeticion;
    }

    public String resumenDeProveedores () {
        if (proveedores.isEmpty())
            return "> Lista de proveedores vacia . . .";
        StringBuilder retorno = new StringBuilder("> Lista de proveedores : \n");
        for (Proveedor actual : proveedores) {
            retorno.append(" - ").append(actual.toString()).append("\n");
        }
        return retorno.toString();
    }

    private static class VentasComparator implements Comparator<Venta> {
        @Override
        public int compare (Venta venta1, Venta venta2) {
            return venta1.getPaquete().getDestino().compareTo(venta2.getPaquete().getDestino());
        }
    }
}
