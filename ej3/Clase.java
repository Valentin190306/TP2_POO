package ar.edu.unlu.poo.ej3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class Clase {
    private static Integer indice = 0;
    private String codigo;
    private String disciplina;
    private Profesor profesor;
    private LocalDateTime horario;
    private Enum<Nivel> nivel;

    private Clase (String disciplina, LocalDateTime horario, Profesor profesor, Enum<Nivel> nivel) {
        setCodigo();
        setDisciplina(disciplina);
        setHorario(horario);
        setProfesor(profesor);
        setNivel(nivel);
    }

    public static Clase crearClase (String disciplina, LocalDateTime horario, Profesor profesor, Enum<Nivel> nivel) {
        Clase nuevaClase = new Clase(disciplina, horario, profesor, nivel);
        if (nuevaClase.setHorario(horario))
            return nuevaClase;
        else return null;
    }

    public enum Nivel {INICIAL, INTERMEDIO, AVANZADO}

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        int valor = indice + 10000;
        this.codigo = Integer.toString(valor);
        indice++;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public boolean setHorario(LocalDateTime horario) {
        if (!(horario.getDayOfWeek().toString().equals("SATURDAY") && horario.getDayOfWeek().toString().equals("SUNDAY"))) {
            this.horario = horario;
            return true;
        }
        else return false;
    }

    public Enum<Nivel> getNivel() {
        return nivel;
    }

    public void setNivel(Enum<Nivel> nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString () {
        return codigo + " - " + disciplina + " - " + " - " + nivel.toString() + " - " + horario.getDayOfWeek().toString() + " - " + horario.getLong(ChronoField.HOUR_OF_DAY);
    }
}
