package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointment;
import model.Contact;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public abstract class DBAppointments {

    public static ObservableList<Appointment> getAllAppointments() {
        ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
        try {
            String sqlCommand = "select * from appointments";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sqlCommand);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int appointmentId = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                Timestamp sts = rs.getTimestamp("Start");
                LocalDateTime start = sts.toLocalDateTime();
                Timestamp ets = rs.getTimestamp("End");
                LocalDateTime end = ets.toLocalDateTime();
                int customerId = rs.getInt("Customer_ID");
                int userId = rs.getInt("User_ID");
                int contactId = rs.getInt("Contact_ID");
                Appointment tempAppointment = new Appointment(appointmentId, start, end, title, description, location,
                        type, customerId, userId, contactId);
                // for(Contact c : getAllContacts)
                allAppointments.add(tempAppointment);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return allAppointments;
    }

    public static boolean insertAppointment() {

        return true;
    }
}
