package apavlikovskyi.airport.dao;

import apavlikovskyi.airport.entity.PassengersEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static apavlikovskyi.airport.dao.daoUtil.DataBaseConnection.getConnection;

/**
 * Created by Артем on 08.04.2017.
 */
public class PassengersDAO {

        PreparedStatement statement;
        ResultSet resultSet;


    public  void deleteById(int id){
        try {
            statement = getConnection().prepareStatement("DELETE FROM passengers WHERE ID = ?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PassengersEntity> getAll(){
        List<PassengersEntity> list=null;
        ResultSet resultSet=null;
        try {
            statement = getConnection().prepareStatement("SELECT * FROM passengers");
            resultSet=statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                PassengersEntity passengersEntity= new PassengersEntity();
                passengersEntity.setId(resultSet.getInt("ID"));
                passengersEntity.setFirst_name(resultSet.getString("First_name"));
                passengersEntity.setLast_name(resultSet.getString("Last_name"));
                passengersEntity.setNationality(resultSet.getString("Nationality"));
                passengersEntity.setPassport(resultSet.getString("DOB"));
                passengersEntity.setDob(resultSet.getString("SEX"));
                list.add(passengersEntity);
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

    public PassengersEntity getById (int id){
        PassengersEntity passengersEntity=null;
        try {
            statement = getConnection().prepareStatement("SELECT * FROM passengers WHERE ID = ?");
            statement.setInt(1,id);
            resultSet= statement.executeQuery();
            passengersEntity= new PassengersEntity();
            passengersEntity.setId(resultSet.getInt("ID"));
            passengersEntity.setFirst_name(resultSet.getString("First_name"));
            passengersEntity.setLast_name(resultSet.getString("Last_name"));
            passengersEntity.setNationality(resultSet.getString("Nationality"));
            passengersEntity.setPassport(resultSet.getString("SEX"));
            passengersEntity.setPassport(resultSet.getString("DOB"));
            passengersEntity.setDob(resultSet.getString("SEX"));

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
        return passengersEntity;
    }



    public  void save(PassengersEntity passengersEntity){
        try {
            statement = getConnection().prepareStatement("INSERT INTO passengers VALUES (?,?,?,?,?,?,?)");
            passengersEntity.setId(resultSet.getInt("ID"));
            passengersEntity.setFirst_name(resultSet.getString("First_name"));
            passengersEntity.setLast_name(resultSet.getString("Last_name"));
            passengersEntity.setNationality(resultSet.getString("Nationality"));
            passengersEntity.setPassport(resultSet.getString("SEX"));
            passengersEntity.setPassport(resultSet.getString("DOB"));
            passengersEntity.setDob(resultSet.getString("SEX"));
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void update(PassengersEntity passengersEntity){
        try {
            statement = getConnection().prepareStatement("UPDATE passengers SET ID=?," +
                    "First_name = ?, Last_name = ?, Nationality = ?,Passport=?, DOB=?, SEX=? WHERE ID = ?");
            statement.setInt(1,passengersEntity.getId());
            statement.setString(2,passengersEntity.getFirst_name());
            statement.setString(3,passengersEntity.getLast_name());
            statement.setString(4,passengersEntity.getNationality());
            statement.setString(5,passengersEntity.getPassport());
            statement.setString(6,passengersEntity.getDob());
            statement.setString(6,passengersEntity.getSex());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

