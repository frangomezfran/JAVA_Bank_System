package servicios;

import modelos.Cliente;

public interface IClienteServicio {

    /**
     * Agrega un nuevo cliente
     * @param cliente cliente a agregar
     * @return retorna si fue exitoso o no, puede pasar que ya exista el cliente en la base de datos
     */
    String agregarCliente(Cliente cliente);

    Cliente dameClientePorDni(Integer dniCliente);

    String listarClientesPorNroSucursal(Integer idSucursal);

    String listarClientesPorSucursal();

    Cliente dameClientePorNro (Integer nroCliente);

    void actualizaIdSucursal(Integer idSucursalVieja, Integer idSucursalNueva);
}
