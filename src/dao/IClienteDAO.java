package dao;

import modelos.Cliente;

import java.util.List;

/**
 * Esta clase es la encargada de traerme los datos de Cliente de mi Base de datos
 * @author Franco Gomez
 */
public interface IClienteDAO {

    /**
     * Este metodo busca a un cliente por ID y Cuil si matchea con la BD me retorna un true
     * caso contrario un false
     * @param cliente Cliente a buscar en mi BD
     * @return Si me retorna un true quiere decir que el cliente existe en mi BD caso contrario me
     * retorna un false
     */
    boolean clienteExiste(Cliente cliente);

    /**
     * Este metodo agrega un nuevo cliente a mi BD si es que este no existe
     * @param cliente cliente nuevo a ingresar
     * @return Si el guardado fue exitoso me retorna un true, caso contrario un false
     */
    boolean agregarCliente(Cliente cliente);

    /**
     * Este metodo me retorna el Cliente que busco por DNI
     * @param dniCliente Dni del cliente a buscar en mi BD
     * @return el cliente encontrado, si este es null quiere decir que no se encontró
     */
    Cliente dameClientePorDni(Integer dniCliente);

    /**
     * Este metodo me retorna una lista con todos los clientes de una sucursal
     * @param nroSucursal numero de sucursal a ver sus clientes
     * @return Lista de clientes de una sucursal
     */
    List<Cliente> dameListaDeClientesPorNroSucursal(Integer nroSucursal);

    /**
     * Este metodo me retorna todos los clientes ordenados por numero de sucursal
     * @return lista de todos los clientes ordenados por sucursal
     */
    List<Cliente> dameListaDeClientesPorSucursal();

    /**
     * Este metodo me retorna un cliente por nroCliente
     * @param nroCliente numero del cliente a buscar
     * @return cliente encontrado,si este es null quiere decir que no se encontro
     */
    Cliente dameClientePorNro(Integer nroCliente);

    /**
     * Este metodo actualiza el numero de sucursal de un cliente
     * @param idSucursalVieja numero de sucursal el cual voy a encontrar al cliente
     * @param idSucursalNueva nuevo numero de sucursal
     */
    void actualizaIdSucursal(Integer idSucursalVieja, Integer idSucursalNueva);

}
