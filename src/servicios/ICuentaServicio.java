package servicios;

import modelos.Cuenta;

public interface ICuentaServicio {

    /** Este metodo genera un nuevo Cbu, de esta forma los cbu's son siempre diferentes
     * siendo una CuentaCorriente o CajaDeAhorro
     * @return nuevoCbu */
    Long generaNuevoCbu();

    Cuenta entrandoACuenta(Long cbu, String clave);

    boolean transferirDinero(Cuenta cuentaEmisora, Long cbuRecibidor, String moneda, Double aTransferir);

}
