package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exercicio",
                    "postgres", "Nicoly*postgresql");
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
