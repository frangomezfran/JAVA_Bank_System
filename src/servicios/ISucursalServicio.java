package servicios;


/**
 * Esta clase es la encargada de manipular los datos de la Base de datos de Sucursal
 * y los datos que llegan del main
 * @author Franco Gomez
 */
public interface ISucursalServicio {

    /**
     * Este método construye un string con los atributos de una sucursal que pertenecen al
     * id de banco pasado por parametro
     * @param idBanco id de banco de las sucursales a imprimir
     * @return String con los atributos de sucursales enlistados
     */
    String listarSucursalesPorIdBanco(Integer idBanco);

    /**
     * Este método me informa si existe una sucursal con idBanco igual a eleccionBanco
     * y un idSucursal igual a eleccionSucursal
     * @param eleccionBanco id del banco de la sucursal a buscar
     * @param eleccionSucursal id de la sucursal a buscar
     * @return un true si matcheo que una sucursal tiene su idSucursal y idBanco igual al los
     * pasados por parametro, caso contrario un false
     */
    boolean existeIdSucursalPorBanco(Integer eleccionBanco,Integer eleccionSucursal);

    /**
     * Este metodo construye un String con los atributos de sucursal que podrian ser
     * eliminados
     * @return String con los atributos de las sucursales que podrian eliminarse
     */
    String listaSucursalesQueSePuedenBorrar();

    /**
     * Este método me informa si la sucursal pasada por parametro se puede eliminar o no
     * @param eleccionSucursal id de la sucursal a verificar si se puede eliminar
     * @return un true si la sucursal encontrada se puede eliminar, un false si la sucursal
     * no se encontro o no se puede eliminar
     */
    boolean existeIdSucursalABorrar(Integer eleccionSucursal);

    /**
     * Este metodo me retorna el id de una sucursal donde su id de banco sea igual
     * a la pasada por parametro
     * @param sucursalABorrar id de la sucursal a buscar su amiga (amiga quiere decir que tengan el mismo
     *                   id de banco)
     * @return id de una sucursal amiga
     */
    Integer dameIdSucursalAmiga(Integer sucursalABorrar);

    /**
     * Este metodo elimina una sucursal con id igual a la pasada por parametro
     * @param idSucursalABorrar id de la sucursal a borrar
     */
    void eliminarSucursal(Integer idSucursalABorrar);
}
