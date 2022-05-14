package model;

import java.time.LocalDateTime;

public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private LocalDateTime createDate;
    private String createBy;
    private LocalDateTime updateDate = null;
    private String updateBy = null;

    public User(int userId, String userName, String userPassword) {
        setUserId(userId);
        setUserName(userName);
        setUserPassword(userPassword);
    }

    public User(int userId, String userName, String userPassword, LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updateBy) {
        setUserId(userId);
        setUserName(userName);
        setUserPassword(userPassword);
        setCreateDate(createDate);
        setCreateBy(createBy);
        setUpdateDate(updateDate);
        setUpdateBy(updateBy);
    }

    public void setUserId(int userId){ this.userId = userId; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    public void setCreateDate(LocalDateTime createDate) { this.createDate = createDate; }
    public void setCreateBy(String createBy) { this.createBy = createBy; }
    public void setUpdateDate(LocalDateTime updateDate) { this.updateDate = updateDate; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }

    public int getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getUserPassword() { return userPassword; }
    public LocalDateTime getCreateDate() { return createDate; }
    public String getCreateBy() { return createBy; }
    public LocalDateTime getUpdateDate() { return updateDate; }
    public String getUpdateBy() { return updateBy; }
}


