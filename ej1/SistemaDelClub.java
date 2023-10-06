package ar.edu.unlu.poo.ej1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaDelClub {
    private static SistemaDelClub instancia = null;
    private final List<Socio> listaDeSocios = new ArrayList<>();
    private final List<Actividad> listaDeActividades = new ArrayList<>();
    private Integer indice = 0;

    public static SistemaDelClub obtenerInstancia () {
        if (instancia == null)
            instancia = new SistemaDelClub();
        return instancia;
    }

    public static enum Subscripcion {BASICA, INTERMEDIA, DESTACADA}

    public void altaDeSocio (String nombre, String email, String direccion, Enum<Subscripcion> subscripcion) {
        Socio nuevoSocio = new Socio((indice + 1000), nombre, email, direccion, subscripcion);
        if (buscarSocio(nuevoSocio) == null) {
            listaDeSocios.add(nuevoSocio);
            this.indice++;
        }
    }

    public void altaDeSocio (Socio nuevoSocio) {
        if (buscarSocio(nuevoSocio) == null)
            listaDeSocios.add(nuevoSocio);
    }

    public void bajaDeSocio (int nroSocio) {
        if (nroSocio > indice || nroSocio < 0)
            return;
        else
            listaDeSocios.remove(nroSocio);
    }

    public void modificarSocio (int nroSocio, String nombre, String email, String direccion, Enum<Subscripcion> subscripcion) {
        if (nroSocio > indice || nroSocio < 0)
            return;
        else {
            Socio socio = listaDeSocios.get(nroSocio - 1000);
            socio.setNombre(nombre);
            socio.setEmail(email);
            socio.setDireccion(direccion);
            socio.setSubscripcion(subscripcion);
        }
    }

    public Socio buscarSocio (int nroSocio) {
        if ((nroSocio - 1000) > indice || (nroSocio - 1000) < 0)
            return null;
        else
            return listaDeSocios.get(nroSocio);
    }

    public Socio buscarSocio (Socio socio) {
        if (listaDeSocios.isEmpty())
            return null;
        Socio socioEncontrado = null;
        for (Socio socioAuxiliar : listaDeSocios) {
            if (socioAuxiliar.getNombre().equals(socio.getNombre()) &&
            socioAuxiliar.getDireccion().equals(socio.getDireccion()) &&
            socioAuxiliar.getEmail().equals(socio.getEmail())) {
               socioEncontrado = socioAuxiliar;
               break;
            }
        }
        return socioEncontrado;
    }

    public void altaDeActividad (String nombre, String descripcion, Enum<Subscripcion> categoria) {
        Actividad nuevaActividad = new Actividad(nombre, descripcion, categoria);
        if (buscarActividad(nuevaActividad) == null) {
            listaDeActividades.add(nuevaActividad);
            return;
        }
    }

    public void altaDeActividad (Actividad nuavaActividad) {
        if (buscarActividad(nuavaActividad) == null)
            listaDeActividades.add(nuavaActividad);
    }

    public void bajaDeActividad (Actividad actividad) {
        if (listaDeActividades.isEmpty())
            return;
        Actividad actividadAuxiliar = buscarActividad(actividad);
        if (actividadAuxiliar != null)
            listaDeActividades.remove(actividadAuxiliar);
    }

    public Actividad buscarActividad (Actividad actividad) {
        if (listaDeActividades.isEmpty())
            return null;
        Actividad actividadEncontrada = null;
        for (Actividad actividadAuxiliar : listaDeActividades) {
            if (actividadAuxiliar.getNombre().equals(actividad.getNombre()) &&
            actividadAuxiliar.getDescripcion().equals(actividad.getDescripcion()) &&
            actividadAuxiliar.getCategoria().equals(actividad.getCategoria())) {
                actividadEncontrada = actividadAuxiliar;
                break;
            }
        }
        return actividadEncontrada;
    }

    public List<Actividad> actividadesPorSubscripcion (Enum<Subscripcion> categoria) {
        return listaDeActividades.stream().filter(actividad -> actividad.getCategoria().equals(categoria)).toList();
    }

    public List<Socio> sociosPorSubscripcion (Enum<Subscripcion> subscripcion) {
        return listaDeSocios.stream().filter(socio -> socio.getSubscripcion().equals(subscripcion)).toList();
    }

    public List<Socio> sociosNuevosMensuales () {
        return listaDeSocios.stream().filter(socio -> socio.getFechaDeSubscripcion().getMonth().equals(LocalDate.now().getMonth())).toList();
    }


}
