package servicios;

import modelos.CuentaCorriente;

public interface ICuentaCorrienteServicio {

    String generaCuentaCorriente(CuentaCorriente cuentaCorrienteNueva, Integer idCliente);

    String imprimeCuenta(CuentaCorriente cuentaAImprimir);

    boolean extraerDinero(CuentaCorriente cuentaParaExtraer,Double aExtraer);

    void depositarDinero(CuentaCorriente cuentaADepositar, Double aDepositar);
}
