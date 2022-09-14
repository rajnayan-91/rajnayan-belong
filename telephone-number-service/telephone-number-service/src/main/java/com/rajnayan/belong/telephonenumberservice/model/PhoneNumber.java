package com.rajnayan.belong.telephonenumberservice.model;

public class PhoneNumber {

    public PhoneNumber(long phone, String userName) {
        this.phone = phone;
        this.userName = userName;
    }

    private long phone;
    private String userName;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getPhone() {
        return phone;
    }
}
