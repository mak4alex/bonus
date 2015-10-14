package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Producer;


/**
 *
 * class ProducerDAO служит для проведения
 * опредация межру Producer и бд.
 * Функционал ProducerDAO содржит набор
 * CRUD(create, read, update, delete)
 * методов.
 *
 */

public class ProducerDAO {  

    public void insert(Producer producer) {
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("INSERT " +
                    "INTO producers(name, country)" +
                    "VALUES( ?, ?);");

            preparedStatement.setString(1, producer.getName());
            preparedStatement.setString(2, producer.getCountry());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (Exception ex) {
             Logger.getLogger(ProducerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public Producer selectById(int id) {
        Producer producer = null;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM producers WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                producer = new Producer();                
                producer.setId(resultSet.getInt("id"));
                producer.setName(resultSet.getString("name"));
                producer.setCountry(resultSet.getString("country"));          
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception ex) {
            Logger.getLogger(ProducerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return producer;
    }


    public List<Producer> selectAll() {
        List<Producer> producers = new ArrayList<>();
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM producers");
            
            while (resultSet.next()) {
                Producer producer = new Producer();
                producer.setId(resultSet.getInt("id"));
                producer.setName(resultSet.getString("name"));
                producer.setCountry(resultSet.getString("country"));
                
                producers.add(producer);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception ex) {
            Logger.getLogger(ProducerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return producers;
    }


    public void delete(int id) {
        Connection connection;
        PreparedStatement preparedStatement;
        
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM producers WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (Exception ex) {
            Logger.getLogger(ProducerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void update(int id, Producer producer) {
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE producers \n" +
                    "SET name = ?, country = ?\n" +
                    "WHERE id = ?;");

            preparedStatement.setString(1, producer.getName());
            preparedStatement.setString(2, producer.getCountry());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(ProducerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
