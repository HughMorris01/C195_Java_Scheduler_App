package controller;

import database.DBAppointments;
import database.DBContacts;
import database.DBCustomers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Contact;
import model.Customer;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddModifyAppointmentScreenController implements Initializable {
    public Label screenLabel;
    public Button submitButton;
    public static boolean isNewAppointment = false;
    public ComboBox<Contact> contactComboBox;
    public ComboBox<Customer> customerComboBox;
    public TextField contactId;
    public TextField appointmentIdTextField;
    public TextField userIdTextField;
    public DatePicker datePickerComboBox;
    public ComboBox<String> startTimeComboBox;
    public ComboBox<String> endTimeComboBox;
    public TextField titleTextField;
    public TextField locationTextField;
    public TextField descriptionTextField;
    public TextField typeTextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (isNewAppointment) { screenLabel.setText("Enter New Appointment");
        submitButton.setText("Confirm Appointment");}
        else {screenLabel.setText("Update Existing Appointment");
        submitButton.setText("Save Changes");}

        customerComboBox.setItems(DBCustomers.getAllCustomers());
        contactComboBox.setItems(DBContacts.getAllContacts());
        userIdTextField.setText(Integer.toString(MainScreenController.getUser().getUserId()));

        ObservableList<String> startTimes = FXCollections.observableArrayList();
        for(int i = 0; i < 56; i++) {
            LocalTime lt = LocalTime.of(8,0);
            lt = lt.plusMinutes(15 * i);
            String t1 = lt.format(DateTimeFormatter.ofPattern("h:mm a"));
            startTimes.add(t1);
        }
        startTimeComboBox.setItems(startTimes);
    }

    public void toBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AppointmentScreen.fxml"));
        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 1050, 450);
        stage.setScene(scene);
        stage.setTitle("Appointment Screen");
    }

    public void onSubmit(ActionEvent actionEvent) throws IOException, SQLException {
        if (appointmentIdTextField.getText() == "") {
            Customer selectedCustomer = customerComboBox.getSelectionModel().getSelectedItem();
            if (selectedCustomer == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Blank Field");
                alert.setContentText("A Customer Name Must Be Selected");
                alert.show();
                return;
            }
            int customerId = selectedCustomer.getCustomerId();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
            LocalDate localDate = datePickerComboBox.getValue();
            String localTimeStartString = startTimeComboBox.getSelectionModel().getSelectedItem();
            LocalTime localTimeStart = LocalTime.from(timeFormatter.parse(localTimeStartString));
            LocalDateTime localDateTimeStart = LocalDateTime.of(localDate, localTimeStart);
            ZonedDateTime zonedDateTimeStart = ZonedDateTime.of(localDate, localTimeStart, ZoneId.of("US/Eastern"));
            Timestamp timeStampStart = Timestamp.valueOf(localDateTimeStart);
            String localTimeEndString = endTimeComboBox.getSelectionModel().getSelectedItem();
            LocalTime localTimeEnd = LocalTime.from(timeFormatter.parse(localTimeEndString));
            LocalDateTime localDateTimeEnd = LocalDateTime.of(localDate, localTimeEnd);
            ZonedDateTime zonedDateTimeEnd = ZonedDateTime.of(localDate, localTimeEnd, ZoneId.of("US/Eastern"));
            Timestamp timeStampEnd = Timestamp.valueOf(localDateTimeEnd);
            String title = titleTextField.getText();
            String description = descriptionTextField.getText();
            String location = locationTextField.getText();
            String type = typeTextField.getText();
            Contact contact = contactComboBox.getSelectionModel().getSelectedItem();
            int contactId = contact.getId();
            int userId = Integer.parseInt(userIdTextField.getText());

            DBAppointments.insertAppointment(title, description, location, type, timeStampStart, timeStampEnd, customerId, contactId, userId);

            Parent root = FXMLLoader.load(getClass().getResource("/view/AppointmentScreen.fxml"));
            Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
            Scene scene = new Scene(root, 1050, 450);
            stage.setScene(scene);
            stage.setTitle("Appointment Screen");
        }
         else {
            int appointmentId = Integer.parseInt(appointmentIdTextField.getText());
            Customer selectedCustomer = customerComboBox.getSelectionModel().getSelectedItem();
            if (selectedCustomer == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Blank Field");
                alert.setContentText("A Customer Name Must Be Selected");
                alert.show();
                return;
            }
            int customerId = selectedCustomer.getCustomerId();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
            LocalDate localDate = datePickerComboBox.getValue();
            String localTimeStartString = startTimeComboBox.getSelectionModel().getSelectedItem();
            LocalTime localTimeStart = LocalTime.from(timeFormatter.parse(localTimeStartString));
            LocalDateTime localDateTimeStart = LocalDateTime.of(localDate, localTimeStart);
            ZonedDateTime zonedDateTimeStart = ZonedDateTime.of(localDate, localTimeStart, ZoneId.of("US/Eastern"));
            Timestamp timeStampStart = Timestamp.valueOf(localDateTimeStart);
            String localTimeEndString = endTimeComboBox.getSelectionModel().getSelectedItem();
            LocalTime localTimeEnd = LocalTime.from(timeFormatter.parse(localTimeEndString));
            LocalDateTime localDateTimeEnd = LocalDateTime.of(localDate, localTimeEnd);
            ZonedDateTime zonedDateTimeEnd = ZonedDateTime.of(localDate, localTimeEnd, ZoneId.of("US/Eastern"));
            Timestamp timeStampEnd = Timestamp.valueOf(localDateTimeEnd);
            String title = titleTextField.getText();
            String description = descriptionTextField.getText();
            String location = locationTextField.getText();
            String type = typeTextField.getText();
            Contact contact = contactComboBox.getSelectionModel().getSelectedItem();
            int contactId = contact.getId();
            int userId = Integer.parseInt(userIdTextField.getText());

            DBAppointments.updateAppointment(appointmentId, title, description, location, type, timeStampStart, timeStampEnd, customerId, contactId, userId);

            Parent root = FXMLLoader.load(getClass().getResource("/view/AppointmentScreen.fxml"));
            Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
            Scene scene = new Scene(root, 1050, 450);
            stage.setScene(scene);
            stage.setTitle("Appointment Screen");
        }
    }

    public void onContactSelect(ActionEvent actionEvent) {
        Contact selectedContact = contactComboBox.getSelectionModel().getSelectedItem();
        int selectedId = selectedContact.getId();
        contactId.setText(String.valueOf(selectedId));
    }

    public void onCustomerSelect(ActionEvent actionEvent) {
        Customer selectedCustomer = customerComboBox.getSelectionModel().getSelectedItem();
        locationTextField.setText(selectedCustomer.getDivision().getDivisionName());
    }

    public void onStartTime(ActionEvent actionEvent) {
        String start = startTimeComboBox.getSelectionModel().getSelectedItem();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        LocalTime lt = LocalTime.from(timeFormatter.parse(start));
        System.out.println(lt);
        ObservableList<String> endTimes = FXCollections.observableArrayList();
        int i = 0;
        while(lt.isBefore(LocalTime.of(22,0))) {
            lt = lt.plusMinutes(15);
            String t1 = lt.format(DateTimeFormatter.ofPattern("h:mm a"));
            endTimes.add(t1);
        }
        endTimeComboBox.setItems(endTimes);
        endTimeComboBox.setValue(null);
        endTimeComboBox.setDisable(false);

    }
}
