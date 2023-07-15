package service;

import connection.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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

    public void consultarRebeldes(){
        String sql = "SELECT * FROM rebeldes";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("id: "+ resultSet.getInt("id_rebelde")
                        + " | nome: "+resultSet.getString("nome")
                        + " | idade: "+resultSet.getInt("idade")
                        + " | gênero: "+resultSet.getString("genero")
                        + " | localização: "+resultSet.getString("localizacao")
                        + " | traidor: "+resultSet.getString("traidor"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void adicionarRebelde(String nome, int idade, String genero, String localizacao){
        String sql = "INSERT INTO rebeldes (nome, idade, genero, localizacao) " +
                "VALUES ('"+nome+"',"+idade+",'"+genero+"','"+localizacao+"')";
        try{
            statement.executeUpdate(sql);
            System.out.println("Rebelde adicionado!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void alterarLocalizacao(String localizacao, int idRebelde){
        String sql = String.format("UPDATE rebeldes SET localizacao='%s' where id_rebelde=%d",localizacao,idRebelde);
        try{
            statement.executeUpdate(sql);
            System.out.println("Localização atualizada com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void reportarRebeldeTraidor(int idRebeldeTraidor){
        String sql = "INSERT INTO traidores (rebelde_id) VALUES (" + idRebeldeTraidor+ ")";
        try{
            statement.executeUpdate(sql);
            System.out.println("Obrigado pelo reporte!");

            int totalDeReportes= totalDeReportesTraicao(idRebeldeTraidor);
            if(totalDeReportes >= 3){
                marcarRebeldeTraidor(idRebeldeTraidor);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void marcarRebeldeTraidor(int idRebelde){
        String sql = "UPDATE rebeldes SET traidor=true WHERE id_rebelde='"+idRebelde+"'";
        try{
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static int totalDeReportesTraicao(int idRebelde){
        String sql = "SELECT COUNT(*) AS total FROM traidores WHERE rebelde_id='"+idRebelde+"'";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                return resultSet.getInt("total");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public void consultarTraidores(){
        String sql = "SELECT * FROM rebeldes WHERE traidor = true";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("Traidores:");
            while(resultSet.next()){
                System.out.println("id: "+ resultSet.getInt("id_rebelde")
                        + " | nome: "+resultSet.getString("nome")
                        + " | idade: "+resultSet.getInt("idade")
                        + " | gênero: "+resultSet.getString("genero")
                        + " | localização: "+resultSet.getString("localizacao")
                        + " | traidor: "+resultSet.getString("traidor"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void adicionarRecurso(int idRebelde, int idRecurso){
        String sql = "INSERT INTO inventario (rebelde_id,recurso_id) VALUES("+idRebelde+","+idRecurso+")";
        try{
            statement.executeUpdate(sql);
            System.out.println("Recurso adicionado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void listarRecursos(){
        String sql="SELECT * FROM recursos";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("id: "+ resultSet.getInt("id_recurso")
                        + " | item: "+resultSet.getString("item")
                        + " | valor: R$"+resultSet.getInt("valor"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void consultarRecursosRebelde(int idRebelde){
        String sql = "SELECT recursos.item "+
                "FROM recursos "+
                "INNER JOIN inventario ON recursos.id_recurso = inventario.recurso_id "+
                "WHERE inventario.rebelde_id="+idRebelde;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                System.out.println("Recursos do rebelde:");
                while (resultSet.next()) {
                    System.out.println(" - " + resultSet.getString("item"));
                }
            }else {
                System.out.println("O rebelde ainda não possui recursos.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void excluirRebelde(int idRebelde){
        String sql2 = String.format("DELETE FROM inventario WHERE rebelde_id=%d",idRebelde);
        try {
            statement.executeUpdate(sql2);
        }catch (SQLException e){
            e.printStackTrace();
        }

        String sql3 = String.format("DELETE FROM traidores WHERE rebelde_id=%d",idRebelde);
        try {
            statement.executeUpdate(sql3);
        }catch (SQLException e){
            e.printStackTrace();
        }

        String sql1 = String.format("DELETE FROM rebeldes WHERE id_rebelde=%d",idRebelde);
        try {
            statement.executeUpdate(sql1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Rebelde excluído com sucesso!");
    }
}
