package ar.edu.unlu.poo.ej4512;

public abstract class Cuenta {
    private static Integer indice = 10000;
    protected Integer codigo;
    protected Double saldo = 0.0;

    public abstract void retirar (Transferencia transferencia);

    public abstract void retirar (Compra compra, Double monto);

    public Integer getCodigo () {
        return codigo;
    }

    protected void setCodigo () {
        this.codigo = indice;
        indice++;
    }

    public Double getSaldo () {
        return saldo;
    }

    public void setSaldo (Double saldo) {
        this.saldo += saldo;
    }

    @Override
    public abstract String toString ();
}
