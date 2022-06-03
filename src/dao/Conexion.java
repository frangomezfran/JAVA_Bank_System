package dao;

import java.sql.*;

public class Conexion {

    //Puede ser profe que tenga que agregar 'cj.' luego de mysql.
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_bancario";

    private static Connection CON = null;

    /**
     * Este metodo verifica si la Connection fue instanciada
     * si no lo fué, la instancia y la devuelve
     * si fue instanciada la devuelve
     * @return me retorna la conexion inicilizada una vez en todoo el proyecto
     */
    public static Connection GetConnection(){

        if(CON == null) {
            try {
                Class.forName(DRIVER);
                CON = DriverManager.getConnection(URL, USER, PASS);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error en GetConnection " + e.getMessage());
            }
        }

        return CON;
    }

}
