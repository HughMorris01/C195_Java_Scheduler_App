package database;

import javafx.collections.ObservableList;
import model.Appointment;

public interface LEInterface {
    abstract ObservableList<Appointment> getMonthlyAppointments(int customerId);
}

