package ar.edu.unlu.poo.ej4512;

public class CuentaCredito extends Cuenta {
    private final Double recargo = 1.05;

    public CuentaCredito (Double saldo) {
        super.setSaldo(saldo);
    }

    public void retirar (Transferencia transferencia) {
        if (transferencia.getMonto() <= super.saldo)
            super.saldo -= transferencia.getMonto();
    }

    public void retirar (Compra compra, Double monto) {
        if (compra.getMonto() <= super.saldo && compra.getMonto() > 0) {
            super.saldo -= monto * recargo;
            compra.pagar(monto);
        }
        if (compra.getMontoFinal() == 0)
            super.saldo += compra.getMontoFinal();
    }

    public Double getRecargo () {
        return recargo;
    }

    @Override
    public String toString () {
        return "Cod: " + codigo.toString() + " - Saldo: " + saldo.toString() + " - Recargo: " + recargo;
    }
}
