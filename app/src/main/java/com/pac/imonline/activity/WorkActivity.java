package com.pac.imonline.activity;

public class WorkActivity {
    private String company_name;
    private String date;
    private String role;
    private String description;

    public WorkActivity(String company_name, String date, String role, String description) {
        this.company_name = company_name;
        this.date = date;
        this.role = role;
        this.description = description;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
