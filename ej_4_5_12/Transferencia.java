package ar.edu.unlu.poo.ej4512;

public class Transferencia {
    private static Integer indice = 10000;
    private Integer codigo;
    protected Double monto;

    public Transferencia (Double monto) {
        setCodigo();
        setMonto(monto);
    }

    public Integer getCodigo () {
        return codigo;
    }

    public void setCodigo () {
        this.codigo = indice;
        indice++;
    }

    public Double getMonto () {
        return monto;
    }

    public void setMonto (Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString () {
        return " > Cod. de Transferencia: " + codigo + " - " + monto;
    }
}
