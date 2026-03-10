package com.livingston.ProfileHub.dto;
import jakarta.validation.constraints.NotBlank;

public class StudentDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String degree;

    @NotBlank
    private String destination;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
}