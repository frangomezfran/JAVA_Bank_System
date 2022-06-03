package dao;

/**
 * Esta clase es la encargada de traerme los datos de Empleado de mi Base de datos
 * @author Franco Gomez
 */
public interface IEmpleadoDAO {

    /**
     * Este metodo actualiza el numero de sucursal de un Empleado
     * @param idSucursalVieja numero de sucursal el cual voy a encontrar al Empleado
     * @param idSucursalNueva nuevo numero de sucursal
     */
    void actualizaIdSucursal(Integer idSucursalVieja, Integer idSucursalNueva);
}
