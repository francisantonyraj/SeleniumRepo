package com.test.model;

public class HeaderColumn {

    private String company;
    private String contact;
    private String country;
    private String action;
    private boolean status;

    public HeaderColumn(String company, String contact, String country, String action, boolean status) {
        this.company = company;
        this.contact = contact;
        this.country = country;
        this.action = action;
        this.status = status;
    }


    public HeaderColumn() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
