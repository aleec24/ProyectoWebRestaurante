package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Conexion conexion;
    private static final String DBURL = "jdbc:mysql://localhost:3306/deweb";
    private static Connection conn = null;

    //-----------
    //Constructor
    private Conexion() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DBURL, "root", "America.9"); // Cambiar por usuario conexion de cada uno. NO COMMITEAR ESTE CAMBIO.
            System.out.println("Conexion correcta");
        } catch (SQLException | SecurityException | IllegalArgumentException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Conexion fallida");
        }

    }

    //-----------
    //Metodos
    public static synchronized Connection getConexion() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        if (conexion == null) {
            conexion = new Conexion();
        }

        return conn;
    }

}
