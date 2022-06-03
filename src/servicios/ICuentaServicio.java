package servicios;

import modelos.Cuenta;

/**
 * Esta clase es la encargada de manipular los datos de la Base de datos de Cuenta Corriente
 * y Caja de Ahorro y los datos que llegan del main
 * @author Franco Gomez
 */
public interface ICuentaServicio {

    /**
     * Este metodo genera un nuevo Cbu, de esta forma los cbu's son siempre diferentes
     * siendo una CuentaCorriente o CajaDeAhorro
     * @return nuevoCbu para una nueva cuenta
     * */
    Long generaNuevoCbu();

    /**
     * Este metodo se fija si existe una cuenta con cbu y clave iguales a alguna de la BD
     * si esto sucede me la retorna, la uso para un loggin de una cuenta
     * @param cbu cbu de la cuenta a buscar
     * @param clave clave de la cuenta con cbu igual al pasado por parametro
     * @return cuenta a la que ingresé, si esta es null no se encontro la cuenta
     * o el cbu y la clave no matchearon
     */
    Cuenta entrandoACuenta(Long cbu, String clave);

    /**
     * Este metodo transfiere dinero de cualquier tipo de cuenta a otra, contempla todos los tipos de
     * situaciones que existen ( CC->CA, CC->CC, CA(pesos)->CC(pesos), CA(pesos)->CA(pesos),
     * CA(dolares)->CA(dolares), CA(dolares)!->CC ), se llama a la extraccion y deposito segun
     * corresponda y se persiste en la BD
     *
     * @param cuentaEmisora Cuenta que emitira la transaccion
     * @param cbuRecibidor cbu de la cuenta a hacerle la transaccion
     * @param moneda tipo de moneda a transferir
     * @param aTransferir monto a transferir
     * @return Si la transferencia fue exitosa me retorna un true, caso contrario un false
     */
    boolean transferirDinero(Cuenta cuentaEmisora, Long cbuRecibidor, String moneda, Double aTransferir);

}
