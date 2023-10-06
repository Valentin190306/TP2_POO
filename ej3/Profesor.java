package ar.edu.unlu.poo.ej3;

public class Profesor {
    private static Integer indice = 0;
    private Integer legajo;
    private String nombre;
    private String disciplina;

    public Profesor (String nombre, String disciplina) {
        setNombre(nombre);
        setDisciplina(disciplina);
        setLegajo();
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo() {
        this.legajo = indice + 10000;
        indice++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
