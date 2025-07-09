package com.models.forms;

import java.time.LocalDate;
import java.util.Random;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.*;

public class Generator {
    Random random = new Random();

    public DataModel generateRandomData() {
        DataModel model = new DataModel();

        model.setFirstName(randomString(4, 16));
        model.setLastName(randomString(4, 16));
        model.setEmail(generateEmail());
        model.setGender(randomEnum(DataModel.Gender.class));
        model.setMobileNumber(generateMobileNumber());
        model.setDateOfBirth(LocalDate.now().minusYears(randomInteger(2)));
        model.setSubject(randomEnum(DataModel.Subject.class));

        DataModel.Hobbies hobbies = new DataModel.Hobbies();
        hobbies.setMusic(random.nextBoolean());
        hobbies.setReading(random.nextBoolean());
        hobbies.setSports(random.nextBoolean());
        model.setHobbies(hobbies);

        model.setCurrentAddress("Some address, Street #" + randomInteger(1, 10));

        DataModel.State state = randomEnum(DataModel.State.class);
        model.setState(state);

        return model;
    }

    private String generateEmail() {
        return format("%s@%s.%s", randomString(5, 20), randomString(2, 8), randomString(2, 4));
    }

    private String generateMobileNumber() {
        return "9" + randomInteger(9);
    }

    private <T> T randomEnum(Class<T> enumClass) {
        T[] constants = enumClass.getEnumConstants();
        return constants[random.nextInt(constants.length)];
    }

    private String randomString(int minLengthInclusive, int maxLengthExclusive) {
        return insecure().nextAlphabetic(minLengthInclusive, maxLengthExclusive);
    }

    private String randomString(int count) {
        return insecure().nextAlphabetic(count);
    }

    private int randomInteger(int minLengthInclusive, int maxLengthExclusive) {
        return parseInt(insecure().nextNumeric(minLengthInclusive, maxLengthExclusive));
    }

    private int randomInteger(int count) {
        return parseInt(insecure().nextNumeric(count));
    }
}

