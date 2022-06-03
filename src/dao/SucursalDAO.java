package dao;

import modelos.Banco;
import modelos.Sucursal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO implements ISucursalDAO{

    //private Conexion conexion;

    public SucursalDAO(){
        //this.conexion= new Conexion();
    }

    public List<Sucursal> dameListaSucursalesPorBanco(Integer idBanco) {

        List<Sucursal> listaSucursales = null;

        try {
            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Sucursal s WHERE s.id_banco = " + idBanco);

            listaSucursales = new ArrayList<>();

            while (rs.next()) {
                Sucursal sucursalAux = new Sucursal();

                sucursalAux.setIdSucursal(rs.getInt("id_sucursal"));
                sucursalAux.setIdBanco(rs.getInt("id_banco"));
                sucursalAux.setDomicilio(rs.getString("domicilio"));

                listaSucursales.add(sucursalAux);
            }

        } catch (SQLException e) {

            System.out.println("Error dameListaSucursalesPorBanco : " + e.getMessage());

        }

        return listaSucursales;

    }

    public List<Sucursal> sucursalesQueSePuedenBorrar(){

        List<Sucursal> listaSucursales = null;

        try {
            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM sucursal s\n" +
                    "WHERE s.id_banco in (SELECT id_banco\n" +
                    "FROM sucursal\n" +
                    "GROUP BY id_banco\n" +
                    "HAVING COUNT(id_banco) >= 2)");

            listaSucursales = new ArrayList<>();

            while (rs.next()) {
                Sucursal sucursalAux = new Sucursal();

                sucursalAux.setIdSucursal(rs.getInt("id_sucursal"));
                sucursalAux.setIdBanco(rs.getInt("id_banco"));
                sucursalAux.setDomicilio(rs.getString("domicilio"));

                listaSucursales.add(sucursalAux);
            }

        } catch (SQLException e) {

            System.out.println("Error sucusalesQueSePuedenBorrar : " + e.getMessage());

        }

        return listaSucursales;

    }

    public Integer dameIdBancoDeUnaSucursal(Integer idSucursal){

        Integer sucursalAmiga = null;

        try {
            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT id_banco FROM sucursal WHERE id_sucursal = "+idSucursal);

            if (rs.next()) {
                return rs.getInt("id_banco");
            }

        } catch (SQLException e) {

            System.out.println("Error dameIdBancoDeUnaSucursal : " + e.getMessage());

        }

        return null;

    }

    public Integer dameIdSucursalAmiga(Integer idSucursal){

        try {
            Statement stmt = Conexion.GetConnection().createStatement();

            Integer idBancoQuePertenece = this.dameIdBancoDeUnaSucursal(idSucursal);

            ResultSet rs = stmt.executeQuery("SELECT id_sucursal FROM sucursal " +
                    "WHERE id_sucursal <> "+idSucursal+
                    "&& id_banco = "+idBancoQuePertenece);

            if (rs.next()) {
                return rs.getInt("id_sucursal");
            }

        } catch (SQLException e) {

            System.out.println("Error dameIdSucursalAmiga : " + e.getMessage());

        }

        return null;

    }

    public void eliminarSucursal(Integer idSucursalABorrar){

        try {
            Statement stmt = Conexion.GetConnection().createStatement();

            stmt.executeUpdate("DELETE FROM Sucursal WHERE id_sucursal = "+idSucursalABorrar);

        } catch (SQLException e) {

            System.out.println("Error eliminarSucursal : " + e.getMessage());

        }
    }

}
