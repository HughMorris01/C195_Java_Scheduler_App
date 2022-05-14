package model;

import database.DBContacts;
import database.DBCustomers;
import database.DBUsers;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private int appointmentId;
    private String title;
    private String description;
    private String location;
    private int contactId;
    private String type;
    private LocalDateTime start;
    private LocalDate startDate;
    private String startDateString;
    private LocalTime startTime;
    private LocalDateTime end;
    private LocalTime endTime;
    private int customerId;
    private int userId;
    private Contact contact;
    private Customer customer;
    private User user;

    public Appointment(int appointmentId, LocalDateTime start, LocalDateTime end, String title, String description,
                       String location, String type, int customerId, int userId, int contactId)
    {
        setAppointmentId(appointmentId);
        setStart(start);
        setStartDate(start);
        setStartTime(start);
        setStartDateString();
        setEnd(end);
        setEndTime(end);
        setTitle(title);
        setDescription(description);
        setLocation(location);
        setType(type);
        setCustomerId(customerId);
        setUserId(userId);
        setContactId(contactId);
    }

    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setLocation(String location) { this.location = location; }
    public void setType(String type) { this.type = type; }
    public void setStart(LocalDateTime start) { this.start = start; }
    public void setStartDate(LocalDateTime start) { this.startDate = start.toLocalDate(); }
    public void setStartDateString() { DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M-d-yyyy");
        startDateString = dtf.format(this.startDate); }
    public void setStartTime(LocalDateTime start) { this.startTime = start.toLocalTime(); }
    public void setEnd(LocalDateTime end) { this.end = end; }
    public void setEndTime(LocalDateTime end) { this.endTime = end.toLocalTime(); }
    public void setContact(Contact contact) { this.contact = contact; }
    public void setUser(User user) { this.user = user; }
    public void setCustomer(Customer customer) { this.customer = customer;}
    public void setUserId(int userId) {
        this.userId = userId;
        ObservableList<User> allUsers = DBUsers.getAllUsers();
        for(User u : allUsers) {
            if(u.getUserId() == userId) {
                setUser(u);
                break;
            }
        }
    }
    public void setContactId(int contactId) {
        this.contactId = contactId;
        ObservableList<Contact> allContacts = DBContacts.getAllContacts();
        for(Contact c : allContacts) {
            if(c.getId() == contactId) {
                setContact(c);
                break;
            }
        }
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
        ObservableList<Customer> allCustomers = DBCustomers.getAllCustomers();
        for(Customer c : allCustomers) {
            if(c.getCustomerId() == customerId) {
                setCustomer(c);
                break;
            }
        }
    }

    public int getAppointmentId() { return appointmentId; }
    public LocalDateTime getStart() { return start; }
    public LocalDate getStartDate() { return startDate; }
    public String getStartDateString() {return startDateString; }
    public LocalTime getStartTime() { return startTime; }
    public LocalDateTime getEnd() { return end; }
    public LocalTime getEndTime() { return endTime; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getType() { return type; }
    public Customer getCustomer() { return customer; }
    public int getCustomerId() { return customerId; }
    public Contact getContact() { return contact; }
    public int getContactId() { return contactId; }
    public User getUser() { return user; }
    public int getUserId() { return userId; }

}
