package dao;

import modelos.Cliente;

import java.util.List;

public interface IClienteDAO {

    boolean clienteExiste(Cliente cliente);

    boolean agregarCliente(Cliente cliente);

    Cliente dameClientePorDni(Integer dniCliente);

    List<Cliente> dameListaDeClientesPorNroSucursal(Integer nroSucursal);

    List<Cliente> dameListaDeClientesPorSucursal();

    Cliente dameClientePorNro(Integer nroCliente);

    void actualizaIdSucursal(Integer idSucursalVieja, Integer idSucursalNueva);

}
