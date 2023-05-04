package com.pac.imonline.activity;

public class EducationActivity {
    private String university_name;
    private String date;
    private String graduation;
    private String description;

    public EducationActivity(String university_name, String date, String graduation, String description) {
        this.university_name = university_name;
        this.date = date;
        this.graduation = graduation;
        this.description = description;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
