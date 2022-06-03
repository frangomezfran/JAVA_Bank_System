package servicios;

import modelos.Cliente;

/**
 * Esta clase es la encargada de manipular los datos de la Base de datos de Cliente
 * y los datos que llegan del main
 * @author Franco Gomez
 */
public interface IClienteServicio {

    /**
     * Este metodo agrega un nuevo cliente a la BD si este no existe previamente
     * @param cliente cliente nuevo a agregar
     * @return retorna un mensaje si fue exitoso o no
     */
    String agregarCliente(Cliente cliente);

    /**
     * Este metodo me devuelve un cliente buscado por dni
     * @param dniCliente dni del cliente a buscar
     * @return cliente encontrado, si este es null no se encontró
     */
    Cliente dameClientePorDni(Integer dniCliente);

    /**
     * Este metodo construye un String de los atributos de cliente que
     * pertenecen a una sucursal
     * @param idSucursal id de la sucursal a buscar sus clientes
     * @return String de los atributos de clientes que pertenecen a una sucursal
     */
    String listarClientesPorNroSucursal(Integer idSucursal);

    /**
     * Este metodo construye un string con todos los atributos de los clientes ordenados
     * por sucursal
     * @return String de todos los clientes ordenados por sucursal
     */
    String listarClientesPorSucursal();

    /**
     * Este metodo me retorna un cliente que tenga su numero igual al pasado por parametro
     * @param nroCliente numero de cliente a buscar
     * @return cliente a buscar, si este es null no se encontró
     */
    Cliente dameClientePorNro (Integer nroCliente);

    /**
     * Este metodo actualiza a los Clientes, en la BD, que tengan su numero de sucursal
     * igual al de idSucursalVieja
     * @param idSucursalVieja numero de sucursal de los clientes a buscar para ser modificados
     * @param idSucursalNueva nuevo numero de sucursal que tendran los clientes encontrados
     */
    void actualizaIdSucursal(Integer idSucursalVieja, Integer idSucursalNueva);
}
