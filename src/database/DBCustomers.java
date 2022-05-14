package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DBCustomers {

    // public static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();

    public static int insertCustomer(String name, String address, String postalCode, String phone, int divisionId) throws SQLException {

        String sqlCommand = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Division_ID) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
        ps.setString(1, name);
        ps.setString(2, address);
        ps.setString(3, postalCode);
        ps.setString(4, phone);
        ps.setInt(5, divisionId);
        return ps.executeUpdate();
    }

    public static int updateCustomer(int customerId, String updatedName, String updatedAddress, String updatedPostalCode,
                                     String updatedPhone, int updatedDivisionId) throws SQLException {
        String sqlCommand = "UPDATE customers SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Division_ID = ? WHERE Customer_ID = ? ";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
        ps.setString(1, updatedName);
        ps.setString(2, updatedAddress);
        ps.setString(3, updatedPostalCode);
        ps.setString(4, updatedPhone);
        ps.setInt(5, updatedDivisionId);
        ps.setInt(6, customerId);
        return ps.executeUpdate();
    }

    public static int deleteCustomer(int customerId) throws SQLException {
        String sqlCommand = "DELETE FROM customers WHERE Customer_ID = ? ";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
        ps.setInt(1, customerId);
        return ps.executeUpdate();
    }

    public static ObservableList<Customer> getAllCustomers() {

        ObservableList<Customer> allCustomers = FXCollections.observableArrayList();

        try {
            String sqlCommand = "SELECT * FROM customers";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int customerId = rs.getInt("Customer_ID");
                String customerName = rs.getString("Customer_Name");
                String customerAddress = rs.getString("Address");
                String customerPostal = rs.getString("Postal_Code");
                String customerPhone = rs.getString("Phone");
                int divisionId = rs.getInt("Division_ID");
                Customer tempCustomer = new Customer(customerId, customerName, customerAddress, customerPostal, customerPhone, divisionId);
                allCustomers.add(tempCustomer);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return allCustomers;
    }
}
