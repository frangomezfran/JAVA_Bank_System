package dao;

import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadoDAO implements IEmpleadoDAO{

    public void actualizaIdSucursal(Integer idSucursalVieja, Integer idSucursalNueva){

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            stmt.executeUpdate("UPDATE Empleado " +
                    "SET id_sucursal = "+idSucursalNueva+
                    " WHERE id_sucursal = "+idSucursalVieja+";");

        }catch(SQLException e){

            System.out.println("Error actualizaIdSucursal : "+e.getMessage());

        }
    }

}
