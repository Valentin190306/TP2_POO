package ar.edu.unlu.poo.ej4512;

import java.time.LocalDate;

public class CuentaCorriente extends Cuenta {
    private Double inversion = null;
    private LocalDate fechaDeRetiro = null;
    protected Double limiteDeGiro;

    public CuentaCorriente (Double limiteDeGiro) {
        super.saldo = 0.0;
        setLimiteDeGiro(limiteDeGiro);
        super.setCodigo();
    }

    public boolean invertir (LocalDate fechaDeRetiro, Double monto) {
        if (super.saldo - monto > limiteDeGiro) {
            if (fechaDeRetiro.isAfter(LocalDate.now()) && this.fechaDeRetiro == null && super.saldo > limiteDeGiro) {
                this.fechaDeRetiro = fechaDeRetiro;
                this.inversion = monto;
                return true;
            }
        }
        return false;
    }

    public void retirar (Transferencia transferencia) {
        if (super.saldo < limiteDeGiro) {
            System.out.println(" >> Cuenta fuera de limite de giro . . . ");
            return;
        }
        else if (super.saldo < 0)
            System.out.println(" >> Transferencia en deuda . . .");
        if (super.saldo - transferencia.getMonto() > limiteDeGiro)
            super.saldo -= transferencia.getMonto();
        if (inversion != null && super.saldo <= 0) {
            cancelarInversion();
        }
    }

    public void retirar (Compra compra, Double monto) {
        if (super.saldo < limiteDeGiro) {
            System.out.println(" >> Cuenta fuera de limite de giro . . . ");
            return;
        }

        if (super.saldo - compra.getMontoFinal() > limiteDeGiro && super.saldo - monto > limiteDeGiro) {
            if (compra.getMonto() > 0) {
                super.saldo -= monto;
                compra.pagar(monto);
                if (super.saldo <= 0) {
                    System.out.println(" >> Transferencia en deuda: " + compra.toString());
                }
                else System.out.println(" >> Transferencia realizada: " + compra.toString());
            }
        }

        if (inversion != null && super.saldo <= 0) {
            cancelarInversion();
        }
    }

    public void ingresar (Transferencia transferencia) {
        super.saldo += transferencia.getMonto();
    }

    public void cancelarInversion () {
        this.inversion = null;
        this.fechaDeRetiro = null;
    }

    public void cobrarInversion () {
        if (fechaDeRetiro != null && LocalDate.now().isAfter(fechaDeRetiro)) {
            if (LocalDate.now().isBefore(LocalDate.now().plusDays(30)) && fechaDeRetiro.isAfter(LocalDate.now().plusDays(30))) {
                super.saldo += inversion * 1.05;
            } else if (LocalDate.now().isAfter(fechaDeRetiro) || LocalDate.now().isEqual(fechaDeRetiro)) {
                super.saldo += inversion * 1.40;
            }
        }
    }

    public LocalDate getFechaDeRetiro () {
        return fechaDeRetiro;
    }

    public void setFechaDeRetiro (LocalDate fechaDeRetiro) {
        this.fechaDeRetiro = fechaDeRetiro;
    }

    public Double getLimiteDeGiro () {
        return limiteDeGiro;
    }

    public void setLimiteDeGiro (Double limiteDeGiro) {
        this.limiteDeGiro = limiteDeGiro;
    }

    @Override
    public String toString () {
        return "Cod: " + super.codigo.toString() + " - Saldo: " + saldo.toString() + " - Lim. de giro: " + limiteDeGiro + " - Invirtiendo: " + inversion;
    }
}
