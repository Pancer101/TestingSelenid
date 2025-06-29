package com.models.forms;

import lombok.Data;

import java.io.File;
import java.time.LocalDate;

@Data
public class InputDataModel {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    private String subjects;
    private Hobbies hobbies;
    private final File file = new File("src\\main\\resources\\Voldemort.jpg");
    private String currentAddress;
    private String state;
    private String city;

    @Data
    public static class Hobbies {
        private Boolean sports;
        private Boolean reading;
        private Boolean music;
    }
}

