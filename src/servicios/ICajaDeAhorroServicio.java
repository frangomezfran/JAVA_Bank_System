package servicios;

import modelos.CajaDeAhorro;

public interface ICajaDeAhorroServicio {

    String generaCajaDeAhorro(CajaDeAhorro cajaDeAhorroNueva, Integer idCliente);

    String imprimeCuenta(CajaDeAhorro cuentaAImprimir);

    boolean extraerDinero(CajaDeAhorro cuentaParaExtraer, String moneda, Double aExtraer );

    void depositarDinero(CajaDeAhorro cuentaADepositar, String moneda, Double aDepositar);

}
