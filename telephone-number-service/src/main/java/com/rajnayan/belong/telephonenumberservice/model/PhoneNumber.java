package com.rajnayan.belong.telephonenumberservice.model;

import javax.annotation.PostConstruct;

public class PhoneNumber {
    private Long phone;

    public PhoneNumber(long phone, String status) {
        this.phone = phone;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getPhone() {
        return phone;
    }

}
