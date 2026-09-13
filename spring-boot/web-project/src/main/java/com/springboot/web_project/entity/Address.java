package com.springboot.web_project.entity;

import jakarta.persistence.Embeddable;

/* cannot be an entity */
@Embeddable
public class Address {
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pincode;
}
