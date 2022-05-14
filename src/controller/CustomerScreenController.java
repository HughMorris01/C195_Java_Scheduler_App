package controller;

import database.DBCustomers;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * This is the controller class for the Customers screen.
 */
public class CustomerScreenController implements Initializable {
    public TableView<Customer> customersTable;
    public TableColumn<Customer, Integer> idCol;
    public TableColumn<Customer, String> nameCol;
    public TableColumn<Customer, String> addressCol;
    public TableColumn<Customer, String> postalCol;
    public TableColumn<Customer, String> phoneCol;
    public TableColumn<Customer, Integer> divisionCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        postalCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        divisionCol.setCellValueFactory(new PropertyValueFactory<>("divisionId"));
        customersTable.setItems(DBCustomers.getAllCustomers());
    }
    
    public void onAddCustomer(ActionEvent actionEvent) throws IOException {
        AddModifyCustomerScreenController.labelBoolean = false;

        Parent root = FXMLLoader.load(getClass().getResource("/view/AddModifyCustomerScreen.fxml"));
        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Add New Customer Screen");
        stage.show();
    }

    public void onModifyCustomer(ActionEvent actionEvent) throws IOException {
        if (customersTable.getSelectionModel().getSelectedItem() != null ) {
            AddModifyCustomerScreenController.labelBoolean = true;
            AddModifyCustomerScreenController.tempCustomer = customersTable.getSelectionModel().getSelectedItem();
            AddModifyCustomerScreenController.tempCustomerIndex = DBCustomers.getAllCustomers().indexOf(AddModifyCustomerScreenController.tempCustomer);

            Parent root = FXMLLoader.load(getClass().getResource("/view/AddModifyCustomerScreen.fxml"));
            Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
            Scene scene = new Scene(root, 500, 500);
            stage.setScene(scene);
            stage.setTitle("Modify Customer Screen");
            stage.show();
        }
        else  {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("No Selection Made");
            alert1.setContentText("Please select a customer to to update.");
            alert1.show();
        }
    }

    public void onDeleteCustomer(ActionEvent actionEvent) throws SQLException {
        Customer selectedCustomer = customersTable.getSelectionModel().getSelectedItem();
        int customerId = selectedCustomer.getCustomerId();
        DBCustomers.deleteCustomer(customerId);
        customersTable.setItems(DBCustomers.getAllCustomers());
    }

    public void toUserHomeScreen(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/UserHomeScreen.fxml"));
            Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
            Scene scene = new Scene(root, 500, 500);
            stage.setScene(scene);
            stage.setTitle("User Home Screen");
            stage.show();
    }
}
