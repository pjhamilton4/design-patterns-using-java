package com.philipjhamilton.patterns.creational.objectpool;

public class UserTemp {

    private long id;
    private long userId;
    private String fName;
    private String lName;
    private String city;

    public UserTemp() {
    }

    public UserTemp(long id, long userId, String fName, String lName, String city) {
        this.id = id;
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "UserTemp{" +
                "id=" + id +
                ", userId=" + userId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
