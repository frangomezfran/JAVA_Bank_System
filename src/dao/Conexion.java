package dao;

import java.sql.*;

public class Conexion {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String URL = "jdbc:mysql://localhost:3306/bank_system";

    private static Connection CON = null;

    //Statement stmt;
    //ResultSet rs;

    /**
     * Este metodo verifica si el atributo CON fue instanciado
     * si no lo fué, lo hace solo una vez
     * si fue instanciada la devuelve
     * (Quedaria una CON por cada tabla de la BD y no una CON por todo el proyecto)
     * @return me retorna la conexion inicilizada una vez por cada tabla
     */
    public static Connection GetConnection(){

        if(CON == null) {
            try {
                Class.forName(DRIVER);
                CON = DriverManager.getConnection(URL, USER, PASS);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error en conexion " + e.getMessage());
            }
        }

        return CON;
    }


}
