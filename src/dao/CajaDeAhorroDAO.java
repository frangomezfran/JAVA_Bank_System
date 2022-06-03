package dao;

import modelos.CajaDeAhorro;
import modelos.CuentaCorriente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CajaDeAhorroDAO implements ICajaDeAhorroDAO {

    public Long ultimoCbuGeneradoCajaDeAhorro(){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT MAX(cbu) AS cbu FROM CajaDeAhorro");

            if(rs.next()){
                return (rs.getLong("cbu"));
            }

        }catch(SQLException e){

            System.out.println("Error ultimoCbuGeneradoCajaDeAhorro : "+e.getMessage());

        }

        return null;

    }

    public boolean agregarCajaDeAhorro(CajaDeAhorro cuentaNueva, Integer idCliente){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            stmt.executeUpdate("INSERT INTO CajaDeAhorro(nro_cliente,cbu,clave,balance_pesos,balance_dolares) " +
                    "Values ("+idCliente+","+cuentaNueva.getCbu()+",'"+cuentaNueva.getClave()+"'," +
                    cuentaNueva.getBalancePesos()+","+cuentaNueva.getBalanceDolares()+")");

            return true;


        }catch(SQLException e){

            System.out.println("Error agregarCajaDeAhorro : "+e.getMessage());

        }
        return false;
    }

    public CajaDeAhorro dameCajaDeAhorroPorCbu(Long cbu){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM CajaDeAhorro WHERE cbu = "+cbu);

            if(rs.next()){
                CajaDeAhorro cajaDeAhorro = new CajaDeAhorro();

                cajaDeAhorro.setNroCuenta(rs.getInt("nro_cuenta"));
                cajaDeAhorro.setNroCliente(rs.getInt("nro_cliente"));
                cajaDeAhorro.setCbu(rs.getLong("cbu"));
                cajaDeAhorro.setClave(rs.getString("clave"));
                cajaDeAhorro.setBalancePesos(rs.getDouble("balance_pesos"));
                cajaDeAhorro.setBalanceDolares(rs.getDouble("balance_dolares"));

                return cajaDeAhorro;
            }

        }catch(SQLException e){

            System.out.println("Error dameCajaDeAhorroPorCbu : "+e.getMessage());

        }

        return null;

    }

    public void actualizarCuenta (CajaDeAhorro cajaDeAhorro){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            stmt.executeUpdate("UPDATE CajaDeAhorro " +
                    "SET nro_cliente = "+cajaDeAhorro.getDuenio().getNroCliente()+
                    ",cbu = "+cajaDeAhorro.getCbu()+
                    ",clave = '"+cajaDeAhorro.getClave()+"'"+
                    ",balance_pesos = "+cajaDeAhorro.getBalancePesos()+
                    ",balance_dolares = "+cajaDeAhorro.getBalanceDolares()+
                    "WHERE nro_cuenta = "+cajaDeAhorro.getNroCuenta()+";");

        }catch(SQLException e){

            System.out.println("Error actualizarCuenta : "+e.getMessage());

        }
    }

}
