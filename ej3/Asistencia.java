package ar.edu.unlu.poo.ej3;

import java.time.LocalDateTime;

public class Asistencia {
    private static Integer indice = 0;
    private Integer codigo;
    private Alumno alumno;
    private Clase clase;
    private final LocalDateTime fechaDeAsistencia;

    public Asistencia (Alumno alumno, Clase clase) {
        setAlumno(alumno);
        setClase(clase);
        setCodigo();
        this.fechaDeAsistencia = LocalDateTime.now();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo () {
        this.codigo = indice;
        indice++;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public LocalDateTime getFechaDeAsistencia() {
        return fechaDeAsistencia;
    }

    @Override
    public String toString () {
        return "Asistencia " + codigo.toString() + " - " + alumno.getNombre() + " - " + clase.getDisciplina();
    }
}
