package controller;

import database.DBAppointments;
import database.DBCustomers;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointment;
import model.Contact;
import model.Customer;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

/**
 * This is the controller class for the Appointments screen.
*/
public class AppointmentScreenController implements Initializable {
    public ToggleGroup scheduleToggle;
    public ComboBox monthlyComboBox;
    public ComboBox weeklyComboBox;
    public TableView<Appointment> appointmentsTable;
    public TableColumn<Appointment, Integer> appointmentIdCol;
    public TableColumn <Appointment, String> startDateCol;
    public TableColumn <Appointment, LocalTime> startTimeCol;
    public TableColumn <Appointment, LocalTime> endTimeCol;
    public TableColumn <Appointment, Integer> titleCol;
    public TableColumn <Appointment, String> descriptionCol;
    public TableColumn <Appointment, String> locationCol;
    public TableColumn <Appointment, String> typeCol;
    public TableColumn <Appointment, Integer>customerIdCol;
    public TableColumn <Appointment, Integer> contactIdCol;
    public TableColumn <Appointment, Integer> userIdCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDateString"));
        startTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endTimeCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        contactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        userIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        appointmentsTable.setItems(DBAppointments.getAllAppointments());

    }

    public void toUserHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/UserHomeScreen.fxml"));
        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("User Home Screen");
    }

    public void loadMonthlySchedule(ActionEvent actionEvent) {
        monthlyComboBox.setDisable(false);
        weeklyComboBox.setDisable(true);
    }

    public void loadWeeklySchedule(ActionEvent actionEvent) {
        monthlyComboBox.setDisable(true);
        weeklyComboBox.setDisable(false);
    }

    public void onNewAppointment(ActionEvent actionEvent) throws IOException {
        AddModifyAppointmentScreenController.isNewAppointment = true;

        Parent root = FXMLLoader.load(getClass().getResource("/view/AddModifyAppointment.fxml"));
        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 600, 500);
        stage.setScene(scene);
        stage.setTitle("New Appointment");
    }

    public void onUpdateAppointment(ActionEvent actionEvent) throws IOException {
        AddModifyAppointmentScreenController.isNewAppointment = false;

        Parent root = FXMLLoader.load(getClass().getResource("/view/AddModifyAppointment.fxml"));
        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Update Existing Appointment");
    }
}
