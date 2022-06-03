package dao;

import modelos.Sucursal;

import java.util.List;

/**
 * Esta clase es la encargada de traerme los datos de Sucursal de mi Base de datos
 * @author Franco Gomez
 */
public interface ISucursalDAO {

    /**
     * Este metodo me retorna una lista con todas las sucursales de un banco
     * @param idBanco id del banco de las sucursales a buscar
     * @return lista de sucursales que pertenecen a un banco
     */
    List<Sucursal> dameListaSucursalesPorBanco(Integer idBanco);

    /**
     * Este metodo me retorna una lista con las sucursales que pueden ser eliminadas
     * serian las sucursales donde el id banco se repitan 2 o mas veces
     * @return lista de sucursales que pueden ser eliminadas
     */
    List<Sucursal> sucursalesQueSePuedenBorrar();

    /**
     * Este metodo me retorna el id de banco de una sucursal
     * @param idSucursal id de la sucursal a retornar su id de banco
     * @return id del banco de la sucursal buscada, si este es null no se encontró
     * ninguna sucursal
     */
    Integer dameIdBancoDeUnaSucursal(Integer idSucursal);

    /**
     * Este metodo me retorna el id de una sucursal donde su id de banco sea igual
     * a la pasada por parametro
     * @param idSucursal id de la sucursal a buscar su amiga (amiga quiere decir que tengan el mismo
     *                   id de banco)
     * @return id de una sucursal amiga
     */
    Integer dameIdSucursalAmiga(Integer idSucursal);

    /**
     * Este metodo elimina una sucursal con id igual a la pasada por parametro
     * @param idSucursalABorrar id de la sucursal a borrar
     */
    void eliminarSucursal(Integer idSucursalABorrar);
}
