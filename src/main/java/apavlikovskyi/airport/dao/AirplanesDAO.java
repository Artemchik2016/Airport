package apavlikovskyi.airport.dao;

import apavlikovskyi.airport.entity.AirplanesEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static apavlikovskyi.airport.dao.daoUtil.DataBaseConnection.getConnection;

/**
 * Created by Артем on 08.04.2017.
 */
public class AirplanesDAO {
        PreparedStatement statement;
        ResultSet resultSet;


        public  void deleteById(int id){
            try {
                statement = getConnection().prepareStatement("DELETE FROM airplanes WHERE ID = ?");
                statement.setInt(1,id);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<AirplanesEntity> getAll(){
            List<AirplanesEntity> list=null;
            ResultSet resultSet=null;
            try {
                statement = getConnection().prepareStatement("SELECT * FROM airplanes");
                resultSet=statement.executeQuery();
                list = new ArrayList<>();
                while (resultSet.next()) {
                    AirplanesEntity airplanesEntity= new AirplanesEntity();
                    airplanesEntity.setVoyage_id(resultSet.getString("Voyage_id"));
                    airplanesEntity.setName(resultSet.getString("Name"));
                    airplanesEntity.setSeats_capacity(resultSet.getInt("Seats_capacity"));
                    list.add(airplanesEntity);
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
                statement = getConnection().prepareStatement("SELECT * FROM airplanes WHERE ID = ?");
                statement.setInt(1,id);
                resultSet= statement.executeQuery();
                airplanesEntity= new AirplanesEntity();
                airplanesEntity.setVoyage_id(resultSet.getString("Voyage_id"));
                airplanesEntity.setName(resultSet.getString("Name"));
                airplanesEntity.setSeats_capacity(resultSet.getInt("Seats_capacity"));
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



        public  void save(AirplanesEntity airplanesEntity){
            try {
                statement = getConnection().prepareStatement("INSERT INTO airplanes VALUES (?,?,?,?)");
                statement.setString(1,airplanesEntity.getVoyage_id());
                statement.setString(2,airplanesEntity.getName());
                statement.setInt(3,airplanesEntity.getSeats_capacity());
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public  void update(AirplanesEntity airplanesEntity){
            try {
                statement = getConnection().prepareStatement("UPDATE airplanes SET Voyage_id=?," +
                        "Class = ?, Passenger_id = ?, Seat_number = ? WHERE ID = ?");
                statement.setString(1,airplanesEntity.getVoyage_id());
                statement.setString(2,airplanesEntity.getName());
                statement.setInt(3,airplanesEntity.getSeats_capacity());
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}

