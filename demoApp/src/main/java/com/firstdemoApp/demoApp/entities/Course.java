package com.firstdemoApp.demoApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Entities class also known as models
@Entity   // added entity @annotation
public class Course  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String title;
    private String des;

    // To String method
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", des='" + getDes() + "'" +
            "}";
    }

    public Course(long id, String title, String des) {
        this.id = id;
        this.title = title;
        this.des = des;
    }

        // Default Constructor
        public Course() {
            super();
        }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
