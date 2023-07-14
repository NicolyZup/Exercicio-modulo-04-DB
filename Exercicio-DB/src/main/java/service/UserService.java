package service;

import connection.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
    static Connection connection = Conexao.getConnection();

    static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consultaRebeldes(){
        String sql = "select * from rebeldes";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("id: "+ resultSet.getInt("id_rebelde")
                        + " nome: "+resultSet.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
