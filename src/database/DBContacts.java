package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contact;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBContacts {
    public static int contactId = 3;

    public static int insertContact(String name, String email) throws SQLException {

        String sqlCommand = "INSERT INTO contacts (Contact_Name, Email) VALUES (?, ?)";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
        ps.setString(1, name);
        ps.setString(2, email);
        int rowsAffected = ps.executeUpdate();
        contactId++;
        return rowsAffected;
    }

    public static ObservableList<Contact> getAllContacts() {

        ObservableList<Contact> allContacts = FXCollections.observableArrayList();

        try {
            String sqlCommand = "SELECT * FROM contacts";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int contactId = rs.getInt("Contact_ID");
                String contactName = rs.getString("Contact_Name");
                String email = rs.getString("Email");

                Contact tempContact= new Contact(contactId, contactName, email);
                allContacts.add(tempContact);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return allContacts;
    }
}
