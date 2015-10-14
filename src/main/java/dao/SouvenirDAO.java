package dao;


import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Souvenir;


/**
 *
 * class SouvenirDAO служит для проведения
 * опредация межру Souvenir и бд.
 * Функционал SouvenirDAO содржит набор
 * CRUD(create, read, update, delete)
 * методов.
 *
 */


public class SouvenirDAO {

    public void insert(Souvenir souvenir) {
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("INSERT " +
                    "INTO souvenirs(name, made_date, price, producer_id)" +
                    "VALUES( ?, ?,?,?);");

            preparedStatement.setString(1, souvenir.getName());
            preparedStatement.setDate(2, new java.sql.Date(souvenir.getMadeDate().getTime()));
            preparedStatement.setDouble(3, souvenir.getPrice());
            preparedStatement.setInt(4, souvenir.getProducerId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(SouvenirDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public Souvenir selectById(int id) {
        Souvenir souvenir = null;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM souvenirs WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                souvenir = new Souvenir();
                souvenir.setId(resultSet.getInt("id"));
                souvenir.setName(resultSet.getString("name"));
                souvenir.setMadeDate(resultSet.getDate("made_date"));
                souvenir.setPrice(resultSet.getDouble("price"));  
                souvenir.setProducerId(resultSet.getInt("producer_id")); 
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception ex) {
            Logger.getLogger(SouvenirDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return souvenir;
    }


    public List<Souvenir> selectAll() {
        List<Souvenir> souvenirs = new ArrayList<>();
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM souvenirs");
            while (resultSet.next()) {
                Souvenir souvenir = new Souvenir();
                souvenir.setId(resultSet.getInt("id"));
                souvenir.setName(resultSet.getString("name"));
                souvenir.setMadeDate(resultSet.getDate("made_date"));
                souvenir.setPrice(resultSet.getDouble("price"));
                souvenir.setProducerId(resultSet.getInt("producer_id"));             
                
                souvenirs.add(souvenir);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception ex) {
            Logger.getLogger(SouvenirDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return souvenirs;
    }

    public List<Souvenir> selectAll(int producer_id) {
        List<Souvenir> souvenirs = new ArrayList<>();
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM souvenirs WHERE producer_id = ?");
            preparedStatement.setInt(1, producer_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Souvenir souvenir = new Souvenir();
                souvenir.setId(resultSet.getInt("id"));
                souvenir.setName(resultSet.getString("name"));
                souvenir.setMadeDate(resultSet.getDate("made_date"));
                souvenir.setPrice(resultSet.getDouble("price"));
                souvenir.setProducerId(resultSet.getInt("producer_id"));
                
                souvenirs.add(souvenir);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(SouvenirDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return souvenirs;
    }

    public void delete(int id) {
        Connection connection;
        PreparedStatement preparedStatement;
        
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM souvenirs WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(SouvenirDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void update(int id, Souvenir souvenir) {
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE souvenirs \n" +
                    "SET name = ?, made_date = ?, price = ?, producer_id = ?\n" +
                    "WHERE id = ?;");
            preparedStatement.setString(1, souvenir.getName());
            preparedStatement.setDate(2, new java.sql.Date(souvenir.getMadeDate().getTime()));
            preparedStatement.setDouble(3, souvenir.getPrice());
            preparedStatement.setInt(4, souvenir.getProducerId());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(SouvenirDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}