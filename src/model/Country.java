package model;

import java.time.LocalDateTime;

public class Country {
    // Instance Variables
    private int countryId;
    private String countryName;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;

    // Constructor
    public Country(int countryId, String countryName, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy) {
        setCountryId(countryId);
        setCountryName(countryName);
        setCreateDate(createDate);
        setCreatedBy(createdBy);
        setLastUpdate(lastUpdate);
        setLastUpdatedBy(lastUpdatedBy);
    }

    // Setter Functions
    public void setCountryId(int countryId) { this.countryId = countryId; }
    public void setCountryName(String countryName) { this.countryName = countryName; }
    public void setCreateDate(LocalDateTime createDate) { this.createDate = createDate; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public void setLastUpdate(LocalDateTime lastUpdate) { this.lastUpdate = lastUpdate; }
    public void setLastUpdatedBy(String lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }

    // Getter Functions
    public int getCountryId() { return countryId; }
    public String getCountryName() { return countryName; }
    public LocalDateTime getCreateDate() { return createDate; }
    public String getCreatedBy() { return createdBy; }
    public LocalDateTime getLastUpdate() { return lastUpdate; }
    public String getLastUpdatedBy() { return lastUpdatedBy; }

    public String toString() {
        return getCountryName();
    }
}
