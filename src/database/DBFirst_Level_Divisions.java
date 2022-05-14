package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;
import model.Division;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DBFirst_Level_Divisions {

    // public static ObservableList<Division> allDivisionsList = FXCollections.observableArrayList();
    public static ObservableList<Division> uSDivisionsList = FXCollections.observableArrayList();
    public static ObservableList<Division> uKDivisionsList = FXCollections.observableArrayList();
    public static ObservableList<Division> canadaDivisionsList = FXCollections.observableArrayList();

    public static ObservableList<Division> getAllDivisions() {
        ObservableList<Division> allDivisionsList = FXCollections.observableArrayList();

        try {
            String sqlCommand = "SELECT * FROM first_level_divisions";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Division tempDivision;
                int divisionId = rs.getInt("Division_ID");
                String divisionName = rs.getString("Division");
                /* Timestamp cts = rs.getTimestamp("Create_Date");
                LocalDateTime createdLdt = cts.toLocalDateTime();
                String createdBy = rs.getString("Created_By");
                Timestamp uts = rs.getTimestamp("Last_Update");
                LocalDateTime updatedLdt = uts.toLocalDateTime();
                String updatedBy = rs.getString("Last_Updated_By"); */
                int countryId = rs.getInt("Country_ID");
                tempDivision = new Division(divisionId, divisionName, countryId);
                allDivisionsList.add(tempDivision);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return allDivisionsList;
    }

    public static void getUSDivisions() {

        uSDivisionsList.clear();

        try {
            String sqlCommand = "SELECT * FROM first_level_divisions WHERE Country_ID = 1 ";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Division tempDivision;
                int divisionId = rs.getInt("Division_ID");
                String divisionName = rs.getString("Division");
                /* Timestamp cts = rs.getTimestamp("Create_Date");
                LocalDateTime createdLdt = cts.toLocalDateTime();
                String createdBy = rs.getString("Created_By");
                Timestamp uts = rs.getTimestamp("Last_Update");
                LocalDateTime updatedLdt = uts.toLocalDateTime();
                String updatedBy = rs.getString("Last_Updated_By"); */
                int countryId = rs.getInt("Country_ID");
                tempDivision = new Division(divisionId, divisionName, countryId);
                uSDivisionsList.add(tempDivision);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void getUKDivisions() {

        uKDivisionsList.clear();

        try {
            String sqlCommand = "SELECT * FROM first_level_divisions WHERE Country_ID = 2 ";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Division tempDivision;
                int divisionId = rs.getInt("Division_ID");
                String divisionName = rs.getString("Division");
                int countryId = rs.getInt("Country_ID");
                tempDivision = new Division(divisionId, divisionName, countryId);
                uKDivisionsList.add(tempDivision);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void getCanadaDivisions() {
        canadaDivisionsList.clear();

        try {
            String sqlCommand = "SELECT * FROM first_level_divisions WHERE Country_ID = 3 ";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Division tempDivision;
                int divisionId = rs.getInt("Division_ID");
                String divisionName = rs.getString("Division");
                /* Timestamp cts = rs.getTimestamp("Create_Date");
                LocalDateTime createdLdt = cts.toLocalDateTime();
                String createdBy = rs.getString("Created_By");
                Timestamp uts = rs.getTimestamp("Last_Update");
                LocalDateTime updatedLdt = uts.toLocalDateTime();
                String updatedBy = rs.getString("Last_Updated_By"); */
                int countryId = rs.getInt("Country_ID");
                tempDivision = new Division(divisionId, divisionName, countryId);
                canadaDivisionsList.add(tempDivision);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
