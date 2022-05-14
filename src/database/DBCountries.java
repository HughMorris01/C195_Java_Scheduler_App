package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DBCountries {

    // public static ObservableList<Country> allCountryList = FXCollections.observableArrayList();

    public static ObservableList<Country> getAllCountries() {
        ObservableList<Country> allCountryList = FXCollections.observableArrayList();

        try {
            String sqlCommand = "SELECT * FROM countries";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int countryId = rs.getInt("Country_ID");
                String countryName = rs.getString("Country");
                Timestamp cts = rs.getTimestamp("Create_Date");
                LocalDateTime createdLdt = cts.toLocalDateTime();
                String createdBy = rs.getString("Created_By");
                Timestamp uts = rs.getTimestamp("Last_Update");
                LocalDateTime updatedLdt = uts.toLocalDateTime();
                String updatedBy = rs.getString("Last_Updated_By");

                Country tempCountry = new Country(countryId, countryName, createdLdt, createdBy, updatedLdt, updatedBy );
                allCountryList.add(tempCountry);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return allCountryList;
    }

    public static void checkDateTimeConversion() {
        String sqlCommand = "SELECT Create_Date FROM countries";
        try {
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Timestamp ts = rs.getTimestamp("Create_Date");
                System.out.println("Create Date: " + ts.toLocalDateTime().toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
