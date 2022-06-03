package dao;

import modelos.CajaDeAhorro;

/**
 * Esta clase es la encargada de traerme los datos de CajaDeAhorro de mi Base de datos
 * @author Franco Gomez
 */
public interface ICajaDeAhorroDAO {

    /**
     * Este metodo me retora el ultimo Cbu generado del ultimo registro de una Caja de Ahorro
     * @return Ultimo Cbu generado
     */
    Long ultimoCbuGeneradoCajaDeAhorro();

    /**
     * Este metodo registra una nueva CajaDeAhorro a la BD
     * @param cuentaNueva cajaDeAhorro nueva a registrar
     * @param idCliente el id del cliente dueño de la nueva cuenta
     * @return si fue exitoso el guardado, me retorna un true, caso contrario un false
     */
    boolean agregarCajaDeAhorro(CajaDeAhorro cuentaNueva, Integer idCliente);

    /**
     * Este metodo me retorna la CajaDeAhorro que tenga el cbu pasado por parametro
     * @param cbu cbu de la cajaDeAhorro a buscar
     * @return CajaDeAhorro encontrada, si no se encuentra esta es null
     */
    CajaDeAhorro dameCajaDeAhorroPorCbu(Long cbu);

    /**
     * Este metodo actualiza (Update) los datos de la cuenta pasada por parametro
     * @param cajaDeAhorro Cuenta a actualizar, con datos nuevos
     */
    void actualizarCuenta (CajaDeAhorro cajaDeAhorro);
}
