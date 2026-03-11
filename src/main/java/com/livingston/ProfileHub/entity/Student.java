package com.livingston.ProfileHub.entity;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String degree;
    private String destination;
    private String resumePath;
    private String visumePath;
//
//    public Student() {
//    }
//
//    public Student(Long id, String name, String degree, String destination, String resumePath, String visumePath) {
//        this.id = id;
//        this.name = name;
//        this.degree = degree;
//        this.destination = destination;
//        this.resumePath = resumePath;
//        this.visumePath = visumePath;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getVisumePath() {
        return visumePath;
    }

    public void setVisumePath(String visumePath) {
        this.visumePath = visumePath;
    }
}