package dao;

import modelos.CuentaCorriente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CuentaCorrienteDAO implements ICuentaCorrienteDAO{

    public boolean agregarCuentaCorriente(CuentaCorriente cuentaNueva, Integer idCliente){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            stmt.executeUpdate("INSERT INTO CuentaCorriente(nro_cliente,cbu,clave,balance_pesos,saldo_deudor,salario_por_mes) " +
                    "Values ("+idCliente+","+cuentaNueva.getCbu()+",'"+cuentaNueva.getClave()+"'," +
                    cuentaNueva.getBalancePesos()+","+cuentaNueva.getSaldoDeudor()+","+cuentaNueva.getSalarioPorMes()+")");

            return true;


        }catch(SQLException e){

            System.out.println("Error agregarCuentaCorriente : "+e.getMessage());

        }
        return false;
    }

    public Long ultimoCbuGeneradoCuentaCorriente(){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT MAX(cbu) AS cbu FROM CuentaCorriente");

            if(rs.next()){
                return (rs.getLong("cbu"));
            }

        }catch(SQLException e){

            System.out.println("Error agregarCuentaCorriente : "+e.getMessage());

        }

        return null;
    }

    public CuentaCorriente dameCuentaCorrientePorCbu(Long cbu){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM CuentaCorriente WHERE cbu = "+cbu);

            if(rs.next()){
                CuentaCorriente cuentaCorriente = new CuentaCorriente();

                cuentaCorriente.setNroCuenta(rs.getInt("nro_cuenta"));
                cuentaCorriente.setNroCliente(rs.getInt("nro_cliente"));
                cuentaCorriente.setCbu(rs.getLong("cbu"));
                cuentaCorriente.setClave(rs.getString("clave"));
                cuentaCorriente.setBalancePesos(rs.getDouble("balance_pesos"));
                cuentaCorriente.setSaldoDeudor(rs.getDouble("saldo_deudor"));
                cuentaCorriente.setSalarioPorMes(rs.getDouble("salario_por_mes"));

                return cuentaCorriente;
            }

        }catch(SQLException e){

            System.out.println("Error dameCuentaCorrientePorCbu : "+e.getMessage());

        }

        return null;

    }

    public void actualizarCuenta (CuentaCorriente cuentaCorriente){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            stmt.executeUpdate("UPDATE CuentaCorriente " +
                    "SET nro_cliente = "+cuentaCorriente.getDuenio().getNroCliente()+
                    ",cbu = "+cuentaCorriente.getCbu()+
                    ",clave = '"+cuentaCorriente.getClave()+"'"+
                    ",balance_pesos = "+cuentaCorriente.getBalancePesos()+
                    ",saldo_deudor = "+cuentaCorriente.getSaldoDeudor()+
                    ",salario_por_mes = "+cuentaCorriente.getSalarioPorMes()+
                    "WHERE nro_cuenta = "+cuentaCorriente.getNroCuenta()+";");

        }catch(SQLException e){

            System.out.println("Error actualizarCuenta : "+e.getMessage());

        }
    }
}
