package model;

public class Contact {
    private int contactId;
    private String contactName;
    private String contactEmail;

    public Contact(int contactId, String contactName, String contactEmail) {
        setContactId(contactId);
        setName(contactName);
        setEmail(contactEmail);
    }

    // Setter Functions
    public void setContactId(int contactId) { this.contactId = contactId; }
    public void setName(String name) { this.contactName = name; }
    public void setEmail(String email) { this.contactEmail = email; }

    //Getter Functions
    public int getId() { return contactId; }
    public String getContactName() { return contactName; }
    public String getEmail() { return contactEmail; }

    public String toString() { return this.contactName; }
}
