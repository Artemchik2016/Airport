package apavlikovskyi.airport.dao;

import apavlikovskyi.airport.entity.AirplanesEntity;
import apavlikovskyi.airport.entity.ArrivalEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static apavlikovskyi.airport.dao.daoUtil.DataBaseConnection.getConnection;

/**
 * Created by Артем on 08.04.2017.
 */
public class ArrivalDAO {


    PreparedStatement statement;
    ResultSet resultSet;


    public  void deleteById(int id){
        try {
            statement = getConnection().prepareStatement("DELETE FROM arrival WHERE ID = ?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ArrivalEntity> getAll(){
        List<ArrivalEntity> list=null;
        ResultSet resultSet=null;
        try {
            statement = getConnection().prepareStatement("SELECT * FROM arrival");
            resultSet=statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                ArrivalEntity arrivalEntity= new ArrivalEntity();
                arrivalEntity.setVoyage_id(resultSet.getString("Voyage_id"));
                arrivalEntity.setDate(resultSet.getString("Date"));
                arrivalEntity.setTime(resultSet.getString("Time"));
                arrivalEntity.setTerminal(resultSet.getString("Terminbal"));
                arrivalEntity.setFlight_status(resultSet.getString("Flight_status"));
                arrivalEntity.setGate(resultSet.getString("Gate"));
                list.add(arrivalEntity);
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

    public AirplanesEntity getById (int id){
        AirplanesEntity airplanesEntity=null;
        try {
            statement = getConnection().prepareStatement("SELECT * FROM arrival WHERE ID = ?");
            statement.setInt(1,id);
            resultSet= statement.executeQuery();
            ArrivalEntity arrivalEntity= new ArrivalEntity();
            arrivalEntity.setVoyage_id(resultSet.getString("Voyage_id"));
            arrivalEntity.setDate(resultSet.getString("Date"));
            arrivalEntity.setTime(resultSet.getString("Time"));
            arrivalEntity.setTerminal(resultSet.getString("Terminbal"));
            arrivalEntity.setFlight_status(resultSet.getString("Flight_status"));
            arrivalEntity.setGate(resultSet.getString("Gate"));
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
        return airplanesEntity;
    }



    public  void save(ArrivalEntity arrivalEntity){
        try {
            statement = getConnection().prepareStatement("INSERT INTO airplanes VALUES (?,?,?,?,?,?)");
            statement.setString(1,arrivalEntity.getVoyage_id());
            statement.setString(2,arrivalEntity.getDate());
            statement.setString(3,arrivalEntity.getTime());
            statement.setString(4,arrivalEntity.getTerminal());
            statement.setString(5,arrivalEntity.getFlight_status());
            statement.setString(6,arrivalEntity.getGate());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void update(ArrivalEntity arrivalEntity){
        try {
            statement = getConnection().prepareStatement("UPDATE arrival SET Voyage_id=?," +
                    "Date = ?, Time = ?, Terminal = ?,Flight_status=?, Gate=? WHERE ID = ?");
            statement.setString(1,arrivalEntity.getVoyage_id());
            statement.setString(2,arrivalEntity.getDate());
            statement.setString(3,arrivalEntity.getTime());
            statement.setString(4,arrivalEntity.getTerminal());
            statement.setString(5,arrivalEntity.getFlight_status());
            statement.setString(6,arrivalEntity.getGate());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



