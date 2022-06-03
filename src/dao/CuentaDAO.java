package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CuentaDAO {

    public String queTipoDeCuentaEs(Long cbu){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM CajaDeAhorro WHERE cbu = "+cbu);

            if(rs.next()){
                return "CA";
            }

            rs = stmt.executeQuery("SELECT * FROM CuentaCorriente WHERE cbu = "+cbu);

            if(rs.next()){
                return "CC";
            }

        }catch(SQLException e){

            System.out.println("Error queTipoDeCuentaEs : "+e.getMessage());

        }

        return null;

    }
}
