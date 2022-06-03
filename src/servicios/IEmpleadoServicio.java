package servicios;

/**
 * Esta clase es la encargada de manipular los datos de la Base de datos de Empleado
 * y los datos que llegan del main
 * @author Franco Gomez
 */
public interface IEmpleadoServicio {

    /**
     * Este metodo actualiza a los Empleados, en la BD, que tengan su numero de sucursal
     * igual al de idSucursalVieja
     * @param idSucursalVieja numero de sucursal de los empleados a buscar para ser modificados
     * @param idSucursalNueva nuevo numero de sucursal que tendran los empleados encontrados
     */
    void actualizaIdSucursal(Integer idSucursalVieja, Integer idSucursalNueva);

}
