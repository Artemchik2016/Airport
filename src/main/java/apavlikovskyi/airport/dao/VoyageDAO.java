package apavlikovskyi.airport.dao;

import static apavlikovskyi.airport.dao.daoUtil.DataBaseConnection.*;
import apavlikovskyi.airport.entity.VoyageEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 08.04.2017.
 */
public class VoyageDAO {
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public void save(VoyageEntity voyage) {
        try {
            preparedStatement = getConnection().prepareStatement("INSERT INTO voyage VALUES (?,?,?,?)");
            preparedStatement.setString(1, voyage.getId());
            preparedStatement.setString(2, voyage.getFlightNumber());
            preparedStatement.setString(3, voyage.getArrivalPort());
            preparedStatement.setString(4, voyage.getDeparturePort());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List getAll() {
        List<VoyageEntity> list = new ArrayList<>();
        try {
            preparedStatement = getConnection().prepareStatement("SELECT * FROM voyage");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VoyageEntity voyageEntity = new VoyageEntity();
                voyageEntity.setId(resultSet.getString("ID"));
                voyageEntity.setFlightNumber(resultSet.getString("Flight_number"));
                voyageEntity.setArrivalPort(resultSet.getString("Arrival_port"));
                voyageEntity.setDeparturePort(resultSet.getString("Departure_port"));
                list.add(voyageEntity);
            }
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void deleteById(int id) {
        try {
            preparedStatement = getConnection().prepareStatement("DELETE FROM voyage WHRE ID =?");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void update(VoyageEntity voyageEntity) {
        try {
            preparedStatement = getConnection().prepareStatement("UPDATE voyage SET ID=?,Flight_number=?,Arrival_port=?,Departure_port=?");
            preparedStatement.setString(1,voyageEntity.getId());
            preparedStatement.setString(2,voyageEntity.getFlightNumber());
            preparedStatement.setString(3,voyageEntity.getArrivalPort());
            preparedStatement.setString(4,voyageEntity.getDeparturePort());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
