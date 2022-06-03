package servicios;

import dao.ClienteDAO;
import dao.IClienteDAO;
import modelos.Cliente;

import java.util.List;

public class ClienteServicio implements IClienteServicio {

    private IClienteDAO clienteDAO;

    public ClienteServicio(){
        this.clienteDAO = new ClienteDAO();
    }

    public String agregarCliente(Cliente cliente){

        if (this.clienteDAO.agregarCliente(cliente)){
            return "El cliente fue agregado con exito";
        }
        return "El cliente ingresado ya existe";
    }

    public Cliente dameClientePorDni(Integer dniCliente){

      return this.clienteDAO.dameClientePorDni(dniCliente);

    }

    public String listarClientesPorNroSucursal(Integer idSucursal){

        List<Cliente> listaClientes = this.clienteDAO.dameListaDeClientesPorNroSucursal(idSucursal);

        String clientes = "";

        if(listaClientes != null) {

            for (Cliente clienteAux : listaClientes) {
                clientes += "Nombre : " + clienteAux.getNombre() + "\nApellido : " + clienteAux.getApellido() + "\nDni : " + clienteAux.getDni() +
                        "\nDomicilio : " + clienteAux.getDomicilio() + "\nTelefono : " + clienteAux.getTelefono() + "\nCuil : " + clienteAux.getCuil() + "\n\n";
            }
        }else {
            clientes = "No existen Clientes para la sucursal solicitada";
        }

        return clientes;

    }

    public String listarClientesPorSucursal(){

        List<Cliente> listaClientes = this.clienteDAO.dameListaDeClientesPorSucursal();

        String clientes = "";

        if(listaClientes != null) {

            int nroSucursalAux = 0;
            for (Cliente clienteAux : listaClientes) {

                if(nroSucursalAux != clienteAux.getIdSucursal()){
                    nroSucursalAux = clienteAux.getIdSucursal();
                    clientes += "-- Sucursal Nro "+nroSucursalAux+" --\n\n";
                }

                clientes += "Nombre : " + clienteAux.getNombre() + "\nApellido : " + clienteAux.getApellido() + "\nDni : " + clienteAux.getDni() +
                  "\nDomicilio : " + clienteAux.getDomicilio() + "\nTelefono : " + clienteAux.getTelefono() + "\nCuil : " + clienteAux.getCuil() + "\n\n";
            }
        }else {
            clientes = "No existen Clientes en ninguna Sucursal";
        }

        return clientes;

    }

    public Cliente dameClientePorNro (Integer nroCliente){

        return (this.clienteDAO.dameClientePorNro(nroCliente));
    }

    public void actualizaIdSucursal(Integer idSucursalVieja, Integer idSucursalNueva){

        this.clienteDAO.actualizaIdSucursal(idSucursalVieja,idSucursalNueva);
    }

}
