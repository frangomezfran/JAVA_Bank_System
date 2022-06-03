package dao;

import modelos.CuentaCorriente;

/**
 * Esta clase es la encargada de traerme los datos de CuentaCorriente de mi Base de datos
 * @author Franco Gomez
 */
public interface ICuentaCorrienteDAO {

    /**
     * Este metodo agrega una nueva Cuenta Corriente a mi BD
     * @param cuentaNueva cuenta nueva a agregar ami BD
     * @param idCliente id del cliente dueño de la cuenta nueva
     * @return
     */
    boolean agregarCuentaCorriente(CuentaCorriente cuentaNueva, Integer idCliente);

    /**
     * Este metodo me retorna el CBU de la ultima Cuenta corriente registrada en la BD
     * @return CBU de la ultima cuenta corriente registrada
     */
    Long ultimoCbuGeneradoCuentaCorriente();

    /**
     * Este metodo me retorna la Cuenta Corriente que busco por cbu
     * @param cbu cbu de la cuenta a buscar
     * @return cuenta corriente con cbu igual al pasado por parametro, si este es null
     * quiere decir que no se encontro
     */
    CuentaCorriente dameCuentaCorrientePorCbu(Long cbu);

    /**
     * Este metodo actualiza los datos de una cuenta de la BD, se busca por numero de cuenta
     * @param cuentaCorriente cuenta con datos actualizados
     */
    void actualizarCuenta (CuentaCorriente cuentaCorriente);

}
