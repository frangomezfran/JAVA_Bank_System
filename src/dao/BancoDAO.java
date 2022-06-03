package dao;

import modelos.Banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO implements IBancoDAO{

    public List<Banco> dameTodosLosBancos(){

        List<Banco> listaBancos = new ArrayList<>();

        try {

            Statement stmt = Conexion.GetConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Banco");

            while (rs.next()) {
                Banco bancoAux = new Banco();

                bancoAux.setIdBanco(rs.getInt("id_banco"));
                bancoAux.setNombre(rs.getString("nombre"));
                bancoAux.setFechaInicio(rs.getDate("fecha_inicio"));

                listaBancos.add(bancoAux);

            }

        }catch(SQLException e){

            System.out.println("Error Banco : "+e.getMessage());

        }

        return listaBancos;

    }
}
