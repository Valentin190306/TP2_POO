package ar.edu.unlu.poo.ej4512;

import java.time.LocalDate;

public class Billetera {
    private static Integer indice = 10000;
    private Usuario dueno;
    private Integer nroDeCuenta;
    private CuentaCorriente corriente = null;
    private CuentaCredito credito = null;
    private CajaDeAhorro deAhorro = null;

    public Billetera (Usuario dueno, CuentaCorriente cuentaCorriente, CuentaCredito cuentaCredito, CajaDeAhorro cajaDeAhorro) {
        setDueno(dueno);
        setCorriente(cuentaCorriente);
        setCredito(cuentaCredito);
        setDeAhorro(cajaDeAhorro);
        setNroDeCuenta();
    }

    public Integer getNroDeCuenta () {
        return nroDeCuenta;
    }

    private void setNroDeCuenta () {
        this.nroDeCuenta = indice;
        indice++;
    }

    public CuentaCorriente getCorriente() {
        return corriente;
    }

    public void setCorriente(CuentaCorriente corriente) {
        this.corriente = corriente;
    }

    public CuentaCredito getCredito () {
        return credito;
    }

    public void setCredito (CuentaCredito credito) {
        this.credito = credito;
    }

    public CajaDeAhorro getDeAhorro() {
        return deAhorro;
    }

    public void setDeAhorro(CajaDeAhorro deAhorro) {
        this.deAhorro = deAhorro;
    }

    public void pagarConCuentaCorriente (Compra compra, Double monto) {
        corriente.retirar(compra, monto);
    }

    public void pagarConCuentaCredito (Compra compra, Double monto) {
        if (credito != null)
            credito.retirar(compra, monto);
        else
            System.out.println(" >> La billetera no tiene una cuenta de credito . . .");
    }

    public void pagarConCajaDeAhorro (Compra compra, Double monto) {
        if (deAhorro != null)
            deAhorro.retirar(compra, monto);
        else
            System.out.println(" >> La billetera no tiene una caja de ahorro . . .");
    }

    public void ingresarACuentaCorriente (Transferencia transferencia) {
        corriente.ingresar(transferencia);
    }

    public void ingresarACajaDeAhorro (Transferencia transferencia) {
        if (deAhorro != null)
            deAhorro.ingresar(transferencia);
        else
            System.out.println(" >> La billetera no tiene una caja de ahorro . . .");
    }

    public void invertir (LocalDate fecha, double monto) {
        corriente.invertir(fecha, monto);
    }

    @Override
    public String toString () {
        String retorno = " > Nro. de billetera: " + nroDeCuenta.toString() + "\n";
        if (corriente != null) retorno += " - " + corriente.toString() + "\n";
        if (credito != null) retorno += " - " + credito.toString() + "\n";
        if (deAhorro != null) retorno += " - " + deAhorro.toString() + "\n";
        return retorno;
    }

    public Usuario getDueno () {
        return dueno;
    }

    public void setDueno (Usuario dueno) {
        this.dueno = dueno;
    }
}
