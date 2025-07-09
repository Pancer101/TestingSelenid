package com.pages.forms;

import com.codeborne.selenide.SelenideElement;
import com.models.forms.DataModel;
import lombok.Getter;

import java.io.File;
import java.time.LocalDate;
import java.util.Random;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.utils.TimeoutDuration.TIMEOUT_LOW;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.openqa.selenium.Keys.ENTER;

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
    private final String hobbiesCheckbox = "//input[@id='hobbies-checkbox-%s']/parent::div";  // Hobbies Sports
    private final SelenideElement pictureUploadInput = $("#uploadPicture");     // Picture upload input
    private final SelenideElement currentAddressTextarea = $("#currentAddress"); // Current Address
    private final SelenideElement stateDropdown = $x("//input[@id='react-select-3-input']");          // State dropdown
    private final SelenideElement cityDropdown = $x("//input[@id='react-select-4-input']");           // City dropdown
    private final SelenideElement submitButton = $("#submit");           // Submit button

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
        emailInput
                .should(exist, TIMEOUT_LOW)
                .sendKeys(email);
        return this;
    }

    public PracticeFormPage selectGender(DataModel.Gender gender) {
        $x(format(genderRadio, gender))
                .should(exist, TIMEOUT_LOW)
                .click();
        return this;
    }

    public PracticeFormPage setMobileNumber(String mobile) {
        mobileInput
                .should(exist, TIMEOUT_LOW)
                .sendKeys(mobile);
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

    public PracticeFormPage setSubject(DataModel.Subject subject) {

        subjectsInput
                .should(exist, TIMEOUT_LOW)
                .sendKeys(valueOf(subject));
        subjectsInput
                .sendKeys(ENTER);

        return this;
    }

    public PracticeFormPage setHobbies(DataModel.Hobbies hobbies) {

        if (hobbies.getSports()) {
            $x(format(hobbiesCheckbox, 1))
                    .should(exist, TIMEOUT_LOW)
                    .click();
        }
        if (hobbies.getReading()) {
            $x(format(hobbiesCheckbox, 2))
                    .should(exist, TIMEOUT_LOW)
                    .click();
        }
        if (hobbies.getMusic()) {
            $x(format(hobbiesCheckbox, 3))
                    .should(exist, TIMEOUT_LOW)
                    .click();
        }
        return this;
    }

    public PracticeFormPage uploadPicture(File filePath) {
        pictureUploadInput.uploadFile(filePath);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        currentAddressTextarea.sendKeys(address);
        return this;
    }

    public PracticeFormPage selectState(DataModel.State state) {
        stateDropdown
                .should(exist, TIMEOUT_LOW)
                .sendKeys(valueOf(state.getState())+ENTER);
        return this;
    }

    public PracticeFormPage selectCity(DataModel.State city) {
        cityDropdown.should(exist, TIMEOUT_LOW)
                .sendKeys(valueOf(city.getCity().get(new Random().nextInt(city.getCity().size())))+ENTER);
        return this;
    }

    public PracticeFormPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage setAll(DataModel dataModel) {
        setFirstName(dataModel.getFirstName())
                .setLastName(dataModel.getLastName())
                .setEmail(dataModel.getEmail())
                .selectGender(dataModel.getGender())
                .setMobileNumber(dataModel.getMobileNumber())
                .setDateOfBirth(dataModel.getDateOfBirth())
                .setSubject(dataModel.getSubject())
                .setHobbies(dataModel.getHobbies())
                .uploadPicture(dataModel.getFile())
                .setCurrentAddress(dataModel.getCurrentAddress())
                .selectState(dataModel.getState())
                .selectCity(dataModel.getState());
        return this;
    }
}
