package model;

import database.DBCountries;

import java.time.LocalDateTime;

public class Division {
    private int divisionId;
    private String divisionName;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;
    private Country country;
    private int countryId;

    public Division(int divisionId, String divisionName, LocalDateTime createDate, String createdBy, int countryId) {
        setDivisionId(divisionId);
        setDivisionName(divisionName);
        setCreateDate(createDate);
        setCreatedBy(createdBy);
        setCountryId(countryId);
        for (Country c : DBCountries.getAllCountries()) {
            if (countryId == c.getCountryId()) {
                country = c;
            }
        }
    }

    public Division(int divisionId, String divisionName, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy, int countryId) {
        setDivisionId(divisionId);
        setDivisionName(divisionName);
        setCreateDate(createDate);
        setCreatedBy(createdBy);
        setLastUpdate(lastUpdate);
        setLastUpdatedBy(lastUpdatedBy);
        setCountryId(countryId);
    }

    public Division(int divisionId, String divisionName, int countryId) {
        setDivisionId(divisionId);
        setDivisionName(divisionName);
        setCountryId(countryId);
        DBCountries.getAllCountries();
        for (Country c : DBCountries.getAllCountries()) {
            if (countryId == c.getCountryId()) {
                this.country = c;
                return;
            }
        }
    }

    public void setDivisionId(int divisionId) { this.divisionId = divisionId; }
    public void setDivisionName(String divisionName) { this.divisionName = divisionName; }
    public void setCreateDate(LocalDateTime createDate) { this.createDate = createDate; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public void setLastUpdate(LocalDateTime lastUpdate) { this.lastUpdate = lastUpdate; }
    public void setLastUpdatedBy(String lastUpdatedBy) { this.lastUpdatedBy = lastUpdatedBy; }
    public void setCountryId(int countryId) { this.countryId = countryId; }

    public int getDivisionId() { return divisionId; }
    public String getDivisionName() { return divisionName; }
    public LocalDateTime getCreateDate() { return createDate; }
    public String getCreatedBy() { return createdBy; }
    public LocalDateTime getLastUpdate() { return lastUpdate; }
    public String getLastUpdatedBy() { return lastUpdatedBy; }
    public int getCountryId() { return countryId; }
    public Country getCountry() { return country; }

    public String toString() {
        return getDivisionName();
    }
 }

