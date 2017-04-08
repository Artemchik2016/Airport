package apavlikovskyi.airport.dao;

import apavlikovskyi.airport.entity.DepartureEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static apavlikovskyi.airport.dao.daoUtil.DataBaseConnection.getConnection;

/**
 * Created by Артем on 08.04.2017.
 */
public class DepartureDAO {

    PreparedStatement statement;
    ResultSet resultSet;


    public  void deleteById(int id){
        try {
            statement = getConnection().prepareStatement("DELETE FROM departure WHERE ID = ?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DepartureEntity> getAll(){
        List<DepartureEntity> list=null;
        ResultSet resultSet=null;
        try {
            statement = getConnection().prepareStatement("SELECT * FROM departure");
            resultSet=statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                DepartureEntity departureEntity= new DepartureEntity();
                departureEntity.setVoyage_id(resultSet.getString("Voyage_id"));
                departureEntity.setDate(resultSet.getString("Date"));
                departureEntity.setTime(resultSet.getString("Time"));
                departureEntity.setTerminal(resultSet.getString("Terminbal"));
                departureEntity.setFlight_status(resultSet.getString("Flight_status"));
                departureEntity.setGate(resultSet.getString("Gate"));
                list.add(departureEntity);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public DepartureEntity getById (int id){
        DepartureEntity departureEntity=null;
        try {
            statement = getConnection().prepareStatement("SELECT * FROM departure WHERE ID = ?");
            statement.setInt(1,id);
            resultSet= statement.executeQuery();
            departureEntity= new DepartureEntity();
            departureEntity.setVoyage_id(resultSet.getString("Voyage_id"));
            departureEntity.setDate(resultSet.getString("Date"));
            departureEntity.setTime(resultSet.getString("Time"));
            departureEntity.setTerminal(resultSet.getString("Terminbal"));
            departureEntity.setFlight_status(resultSet.getString("Flight_status"));
            departureEntity.setGate(resultSet.getString("Gate"));
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return departureEntity;
    }



    public  void save(DepartureEntity departureEntity){
        try {
            statement = getConnection().prepareStatement("INSERT INTO departure VALUES (?,?,?,?,?,?)");
            statement.setString(1,departureEntity.getVoyage_id());
            statement.setString(2,departureEntity.getDate());
            statement.setString(3,departureEntity.getTime());
            statement.setString(4,departureEntity.getTerminal());
            statement.setString(5,departureEntity.getFlight_status());
            statement.setString(6,departureEntity.getGate());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void update(DepartureEntity departureEntity){
        try {
            statement = getConnection().prepareStatement("UPDATE departure SET Voyage_id=?," +
                    "Date = ?, Time = ?, Terminal = ?,Flight_status=?, Gate=? WHERE ID = ?");
            statement.setString(1,departureEntity.getVoyage_id());
            statement.setString(2,departureEntity.getDate());
            statement.setString(3,departureEntity.getTime());
            statement.setString(4,departureEntity.getTerminal());
            statement.setString(5,departureEntity.getFlight_status());
            statement.setString(6,departureEntity.getGate());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

