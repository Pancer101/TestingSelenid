package com.pages.forms;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {

    @Getter
    public final static String END_POINT = "/automation-practice-form";

    // Локаторы (вставь свои значения)
    private final SelenideElement firstNameInput = $("#firstName");  // First Name
    private final SelenideElement lastNameInput = $("#lastName");   // Last Name
    private final SelenideElement emailInput = $("#userEmail");      // Email
    private final SelenideElement genderMaleRadio = $("#"); // Gender Male
    private final SelenideElement genderFemaleRadio = $("#");// Gender Female
    private final SelenideElement genderOtherRadio = $("#"); // Gender Other
    private final SelenideElement mobileInput = $("#");     // Mobile Number
    private final SelenideElement dateOfBirthInput = $("#"); // Date of Birth
    private final SelenideElement subjectsInput = $("#");    // Subjects
    private final SelenideElement hobbiesSportsCheckbox = $("#");  // Hobbies Sports
    private final SelenideElement hobbiesReadingCheckbox = $("#"); // Hobbies Reading
    private final SelenideElement hobbiesMusicCheckbox = $("#");   // Hobbies Music
    private final SelenideElement pictureUploadInput = $("#");     // Picture upload input
    private final SelenideElement currentAddressTextarea = $("#"); // Current Address
    private final SelenideElement stateDropdown = $("#");          // State dropdown
    private final SelenideElement cityDropdown = $("#");           // City dropdown
    private final SelenideElement submitButton = $("#");           // Submit button

    // Методы для заполнения полей

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                genderMaleRadio.click();
                break;
            case "female":
                genderFemaleRadio.click();
                break;
            case "other":
                genderOtherRadio.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid gender: " + gender);
        }
        return this;
    }

    public PracticeFormPage setMobileNumber(String mobile) {
        mobileInput.sendKeys(mobile);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String date) {
        dateOfBirthInput.sendKeys(date);
        return this;
    }

    public PracticeFormPage setSubjects(String subjects) {
        subjectsInput.sendKeys(subjects);
        return this;
    }

    public PracticeFormPage setHobbies(boolean sports, boolean reading, boolean music) {
        if (sports && !hobbiesSportsCheckbox.isSelected()) {
            hobbiesSportsCheckbox.click();
        }
        if (reading && !hobbiesReadingCheckbox.isSelected()) {
            hobbiesReadingCheckbox.click();
        }
        if (music && !hobbiesMusicCheckbox.isSelected()) {
            hobbiesMusicCheckbox.click();
        }
        return this;
    }

    public PracticeFormPage uploadPicture(String filePath) {
        pictureUploadInput.uploadFile(new java.io.File(filePath));
        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        currentAddressTextarea.sendKeys(address);
        return this;
    }

    public PracticeFormPage selectState(String state) {
        stateDropdown.click();
        // Тут можно выбрать нужный state из выпадающего списка
        // Например:
        // $("//div[contains(text(),'" + state + "')]").click();
        return this;
    }

    public PracticeFormPage selectCity(String city) {
        cityDropdown.click();
        // Аналогично выбор города
        return this;
    }

    public PracticeFormPage clickSubmit() {
        submitButton.click();
        return this;
    }
}
