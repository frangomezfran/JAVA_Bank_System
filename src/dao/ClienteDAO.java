package dao;

import modelos.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO implements IClienteDAO{

    public boolean clienteExiste(Cliente cliente){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT c.dni, c.cuil FROM Cliente c WHERE c.dni = "+cliente.getDni()+" and c.cuil = "+cliente.getCuil());

            if (rs.next()) {
                return true;
            }

        }catch(SQLException e){

            System.out.println("Error Cliente : "+e.getMessage());

        }

        return false;


    }

    public boolean agregarCliente(Cliente cliente){

        if(!this.clienteExiste(cliente)){

            try {

                Statement stmt = Conexion.GetConnection().createStatement();

                stmt.executeUpdate("INSERT INTO Cliente(id_sucursal, nombre, apellido, dni, domicilio, telefono, cuil) " +
                        "Values ("+cliente.getIdSucursal()+",'"+cliente.getNombre()+"','"+cliente.getApellido()+"',"+cliente.getDni()+",'" +
                        cliente.getDomicilio()+"','"+cliente.getTelefono()+"',"+cliente.getCuil()+")");


            }catch(SQLException e){

                System.out.println("Error Banco : "+e.getMessage());

            }

            return true;

        }
        return false;
    }

    public Cliente dameClientePorDni(Integer dniCliente){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente WHERE dni = "+dniCliente);

            if (rs.next()) {

                Cliente clienteAux = new Cliente();

                clienteAux.setNroCliente(rs.getInt("nro_cliente"));
                clienteAux.setIdSucursal(rs.getInt("id_sucursal"));
                clienteAux.setNombre(rs.getString("nombre"));
                clienteAux.setApellido(rs.getString("apellido"));
                clienteAux.setDni(rs.getLong("dni"));
                clienteAux.setDomicilio(rs.getString("domicilio"));
                clienteAux.setTelefono(rs.getString("telefono"));
                clienteAux.setCuil(rs.getInt("cuil"));

                return clienteAux;
            }


        }catch(SQLException e){

            System.out.println("Error dameClientePorDni : "+e.getMessage());

        }

        return null;

    }

    public List<Cliente> dameListaDeClientesPorSucursal(){
        List<Cliente> listaClientes = null;

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente ORDER BY id_sucursal ASC ");

            listaClientes = new ArrayList<>();

            while (rs.next()) {

                Cliente clienteAux = new Cliente();

                clienteAux.setNroCliente(rs.getInt("nro_cliente"));
                clienteAux.setIdSucursal(rs.getInt("id_sucursal"));
                clienteAux.setNombre(rs.getString("nombre"));
                clienteAux.setApellido(rs.getString("apellido"));
                clienteAux.setDni(rs.getLong("dni"));
                clienteAux.setDomicilio(rs.getString("domicilio"));
                clienteAux.setTelefono(rs.getString("telefono"));
                clienteAux.setCuil(rs.getInt("cuil"));

                listaClientes.add(clienteAux);

            }


        }catch(SQLException e){

            System.out.println("Error dameListaDeClientesPorSucursal : "+e.getMessage());

        }

        return listaClientes;

    }

    public List<Cliente> dameListaDeClientesPorNroSucursal(Integer idSucursal){

        List<Cliente> listaClientes = null;

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente WHERE id_sucursal = "+idSucursal);

            listaClientes = new ArrayList<>();

            while (rs.next()) {

                Cliente clienteAux = new Cliente();

                clienteAux.setNroCliente(rs.getInt("nro_cliente"));
                clienteAux.setIdSucursal(rs.getInt("id_sucursal"));
                clienteAux.setNombre(rs.getString("nombre"));
                clienteAux.setApellido(rs.getString("apellido"));
                clienteAux.setDni(rs.getLong("dni"));
                clienteAux.setDomicilio(rs.getString("domicilio"));
                clienteAux.setTelefono(rs.getString("telefono"));
                clienteAux.setCuil(rs.getInt("cuil"));

                listaClientes.add(clienteAux);

            }


        }catch(SQLException e){

            System.out.println("Error dameListaDeClientesPorNroSucursal : "+e.getMessage());

        }

        return listaClientes;

    }

    public Cliente dameClientePorNro(Integer nroCliente){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente WHERE nro_cliente = "+nroCliente);

            if (rs.next()) {

                Cliente clienteAux = new Cliente();

                clienteAux.setNroCliente(rs.getInt("nro_cliente"));
                clienteAux.setIdSucursal(rs.getInt("id_sucursal"));
                clienteAux.setNombre(rs.getString("nombre"));
                clienteAux.setApellido(rs.getString("apellido"));
                clienteAux.setDni(rs.getLong("dni"));
                clienteAux.setDomicilio(rs.getString("domicilio"));
                clienteAux.setTelefono(rs.getString("telefono"));
                clienteAux.setCuil(rs.getInt("cuil"));

                return clienteAux;
            }


        }catch(SQLException e){

            System.out.println("Error dameClientePorNro : "+e.getMessage());

        }

        return null;

    }

    public void actualizaIdSucursal(Integer idSucursalVieja, Integer idSucursalNueva){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            stmt.executeUpdate("UPDATE Cliente " +
                    "SET id_sucursal = "+idSucursalNueva+
                    " WHERE id_sucursal = "+idSucursalVieja+";");

        }catch(SQLException e){

            System.out.println("Error actualizaIdSucursal : "+e.getMessage());

        }
    }


}
