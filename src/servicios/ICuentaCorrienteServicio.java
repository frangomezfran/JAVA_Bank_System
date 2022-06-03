package servicios;

import modelos.CuentaCorriente;

/**
 * Esta clase es la encargada de manipular los datos de la Base de datos de Cuenta Corriente
 * y los datos que llegan del main
 * @author Franco Gomez
 */
public interface ICuentaCorrienteServicio {

    /**
     * Este metodo se comunica con la BD para generar una nueva Cuenta Corriente para la BD
     * @param cuentaCorrienteNueva Cuenta Corriente nueva a agregar a la BD
     * @param idCliente id del cliente dueño de la cuenta
     * @return mensaje con la resolucion del guardado
     */
    String generaCuentaCorriente(CuentaCorriente cuentaCorrienteNueva, Integer idCliente);

    /**
     * Este metodo construye un String con la cuenta pasada por parametro y la retorna
     * @param cuentaAImprimir cuenta con la que se construye el string
     * @return String con los atributos de cuentaAImprimir enlistadas
     */
    String imprimeCuenta(CuentaCorriente cuentaAImprimir);

    /**
     * Este metodo extrae dinero de la cuenta pasada por parametro, se fija si el monto a extraer
     * es menor o igual al maximo de dinero total que puedo sacar, se fija si se extrae dinero
     * del balance en pesos o el saldo deudor y luego se persiste en la BD
     * @param cuentaParaExtraer Cuenta en la cual se extraera dinero
     * @param aExtraer monto a extraer
     * @return Me retorna un true si la extraccion fue exitosa, caso contrario un false
     */
    boolean extraerDinero(CuentaCorriente cuentaParaExtraer,Double aExtraer);

    /**
     * Este metodo deposita dinero, en balance de pesos o saldo deudor, en la cuenta pasada por
     * parametro y luego se persiste en la BD
     * @param cuentaADepositar cuenta a cual depositar
     * @param aDepositar monto a depositar
     */
    void depositarDinero(CuentaCorriente cuentaADepositar, Double aDepositar);
}
