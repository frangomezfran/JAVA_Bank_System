package servicios;

import modelos.CajaDeAhorro;

/**
 * Esta clase es la encargada de manipular los datos de la Base de datos de Caja de Ahorro
 * y los datos que llegan del main
 * @author Franco Gomez
 */
public interface ICajaDeAhorroServicio {

    /**
     * Este metodo se comunica con la BD para generar una nueva Caja de Ahorro para la BD
     * @param cajaDeAhorroNueva Caja de Ahorro a agregar a la BD
     * @param idCliente id del cliente dueño de la cuenta
     * @return mensaje con la resolucion del guardado
     */
    String generaCajaDeAhorro(CajaDeAhorro cajaDeAhorroNueva, Integer idCliente);

    /**
     * Este metodo construye un String con la cuenta pasada por parametro y la retorna
     * @param cuentaAImprimir cuenta con la que se construye el string
     * @return String con los atributos de cuentaAImprimir enlistadas
     */
    String imprimeCuenta(CajaDeAhorro cuentaAImprimir);

    /**
     * Este metodo extrae dinero de la cuenta pasada por parametro, dependiendo de la moneda
     * se extraera en el balance de pesos o dolares y ademas se fija si el monto a extraer es
     * menor o igual al balance elegido, luego se persiste en la BD
     * @param cuentaParaExtraer Cuenta en la cual se extraera dinero
     * @param moneda tipo de moneda (pesos o dolares)
     * @param aExtraer monto a extraer
     * @return Me retorna un true si la extraccion fue exitosa, caso contrario un false
     */
    boolean extraerDinero(CajaDeAhorro cuentaParaExtraer, String moneda, Double aExtraer );

    /**
     * Este metodo deposita dinero, en balance de pesos o dolares, en la cuenta pasada por
     * parametro y luego se persiste en la BD
     * @param cuentaADepositar cuenta a cual depositar
     * @param moneda tipo de moneda (pesos o dolares)
     * @param aDepositar monto a depositar
     */
    void depositarDinero(CajaDeAhorro cuentaADepositar, String moneda, Double aDepositar);

}
