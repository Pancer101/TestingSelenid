package com.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class DataModel {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    private Subject subject;
    private Hobbies hobbies;
    private final File file = new File("src\\main\\resources\\Voldemort.jpg");
    private String currentAddress;
    private State state;
    private String selectedCity;

    @Setter
    @Getter
    public static class Hobbies {
        private Boolean sports;
        private Boolean reading;
        private Boolean music;
    }

    public enum Gender {
        Male, Female, Other
    }

    public enum Subject {
        English, Maths, Physics, Arts, History, Civics, Chemistry
    }

    @Getter
    @AllArgsConstructor
    public enum State {
        NCR("NCR", List.of("Delhi", "Gurgaon", "Noida")),
        UTTAR_PRADESH("Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut")),
        HARYANA("Haryana", List.of("Karnal", "Panipat")),
        RAJASTHAN("Rajasthan", List.of("Jaipur", "Jaiselmer"));

        private final String state;
        private final List<String> city;
    }
}

