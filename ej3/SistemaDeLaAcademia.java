package ar.edu.unlu.poo.ej3;

import java.time.LocalDate;
import java.util.*;

public class SistemaDeLaAcademia {
    private static SistemaDeLaAcademia instancia = null;
    private final List<Asistencia> asistencias;

    private SistemaDeLaAcademia (List<Asistencia> listaDeAsistencias) {
        this.asistencias = listaDeAsistencias;
    }

    public static SistemaDeLaAcademia obtenerInstancia (List<Asistencia> listaDeAsistencias) {
        if (instancia == null)
            instancia = new SistemaDeLaAcademia(listaDeAsistencias);
        return instancia;
    }

    public void altaDeAsistencia (Asistencia asistencia) {
        asistencias.add(asistencia);
    }

    public void bajaDeAsistencia (Asistencia asistencia) {
        asistencias.remove(asistencia);
    }

    public List<Asistencia> listaDeAsistenciasMensual (Profesor profesor) {
        List<Asistencia> asistenciasDelPRofesor = asistencias.stream().filter(asistencia -> asistencia.getClase().getProfesor().equals(profesor)).toList();
        List<Asistencia> asistenciasDelMes = new ArrayList<>(asistenciasDelPRofesor.stream().filter(asistencia -> asistencia.getFechaDeAsistencia().getMonth().equals(LocalDate.now().getMonth())).toList());
        asistenciasDelMes.sort(new AsistenciasComparator());
        return asistenciasDelMes;
    }

    public Long calcularSueldo (Profesor profesor) {
        long cantidadDeAsistencias = listaDeAsistenciasMensual(profesor).size();
        return cantidadDeAsistencias * 10;
    }

    public String disciplinaMasPopular () {
        Map<String, Integer> contadorDeDisciplinas = new HashMap<>();
        for (Asistencia auxiliar : asistencias) {
            String disciplina = auxiliar.getClase().getDisciplina();
            if (contadorDeDisciplinas.containsKey(disciplina))
                contadorDeDisciplinas.put(disciplina, contadorDeDisciplinas.get(disciplina) + 1);
            else
                contadorDeDisciplinas.put(disciplina, 1);
        }

        String disciplinaMasPopular = null;
        int mayorRepeticion = 0;

        for (Map.Entry<String, Integer> entrada : contadorDeDisciplinas.entrySet()) {
            if (entrada.getValue() > mayorRepeticion) {
                disciplinaMasPopular = entrada.getKey();
                mayorRepeticion = entrada.getValue();
            }
        }
        return disciplinaMasPopular;
    }

    private static class AsistenciasComparator implements Comparator<Asistencia> {
        @Override
        public int compare (Asistencia asistencia1, Asistencia asistencia2) {
            int resultado = asistencia2.getFechaDeAsistencia().compareTo(asistencia2.getFechaDeAsistencia());
            if (resultado == 0)
                resultado = asistencia1.getAlumno().getLegajo().compareTo(asistencia2.getAlumno().getLegajo());
            return resultado;
        }
    }
}
