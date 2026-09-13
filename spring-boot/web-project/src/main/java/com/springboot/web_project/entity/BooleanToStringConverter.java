package com.springboot.web_project.entity;

import jakarta.persistence.AttributeConverter;

import java.util.Objects;

public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        if(aBoolean == null) return "No";
        return aBoolean ? "Yes" : "No";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        if(s == null) return true;
        return "Yes".equals(s);
    }
}
