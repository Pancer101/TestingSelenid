package com.pages.forms;

import com.codeborne.selenide.SelenideElement;
import com.models.forms.InputDataModel;
import lombok.Getter;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.utils.TimeoutDuration.TIMEOUT_LOW;
import static java.lang.String.format;
import static java.lang.String.valueOf;

public class PracticeFormPage {

    @Getter
    private final String END_POINT = "/automation-practice-form";

    private final SelenideElement firstNameInput = $("#firstName");  // First Name
    private final SelenideElement lastNameInput = $("#lastName");   // Last Name
    private final SelenideElement emailInput = $("#userEmail");      // Email
    private final String genderRadio = "//div[@id='genterWrapper']//label[text()='%s']//preceding-sibling::input//parent::div";
    private final SelenideElement mobileInput = $("#userNumber");     // Mobile Number
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput"); // Date of Birth
    private final SelenideElement subjectsInput = $("#subjectsInput");    // Subjects
    private final SelenideElement hobbiesSportsCheckbox = $("#");  // Hobbies Sports
    private final SelenideElement hobbiesReadingCheckbox = $("#"); // Hobbies Reading
    private final SelenideElement hobbiesMusicCheckbox = $("#");   // Hobbies Music
    private final SelenideElement pictureUploadInput = $("#");     // Picture upload input
    private final SelenideElement currentAddressTextarea = $("#"); // Current Address
    private final SelenideElement stateDropdown = $("#");          // State dropdown
    private final SelenideElement cityDropdown = $("#");           // City dropdown
    private final SelenideElement submitButton = $("#");           // Submit button

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput
                .should(exist, TIMEOUT_LOW)
                .sendKeys(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput
                .should(exist, TIMEOUT_LOW)
                .sendKeys(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        email = format("%s@%s.com", email, email);
        emailInput
                .should(exist, TIMEOUT_LOW)
                .sendKeys(email);
        return this;
    }

    public PracticeFormPage selectGender(InputDataModel.Gender gender) {
        $x(format(genderRadio, gender))
                .should(exist, TIMEOUT_LOW)
                .click();
        return this;
    }

    public PracticeFormPage setMobileNumber(int mobile) {
        mobileInput
                .should(exist, TIMEOUT_LOW)
                .sendKeys(valueOf(Math.abs(mobile)));
        return this;
    }

    public PracticeFormPage setDateOfBirth(LocalDate date) {

        System.out.println(date);
        String year = valueOf(date.getYear());
        String month = valueOf(date.getMonthValue());
        String day = valueOf(date.getDayOfMonth());

        dateOfBirthInput.click();
        $x("//select[@class='react-datepicker__year-select']").selectOption(year);
        $x("//select[@class='react-datepicker__month-select']").selectOptionByValue(month);
        $x("//div[@class='react-datepicker__month']//div[text()='" + day + "']").click();

        return this;
    }

    public PracticeFormPage setSubjects(String subjects) {
        subjectsInput
                .should(exist, TIMEOUT_LOW)
                .sendKeys(subjects);
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

    public PracticeFormPage setAll(InputDataModel dataModel) {
        setFirstName(dataModel.getFirstName())
                .setLastName(dataModel.getLastName())
                .setEmail(dataModel.getEmail())
                .selectGender(dataModel.getGender());
        return this;
    }
}
