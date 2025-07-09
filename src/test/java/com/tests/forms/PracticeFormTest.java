package com.tests.forms;

import com.models.forms.DataModel;
import com.models.forms.Generator;
import com.pages.forms.PracticeFormPage;
import com.settings.BaseTest;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest extends BaseTest {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();
    private final DataModel dataModel = new Generator().generateRandomData();

    @BeforeEach
    void before() {
        open(practiceFormPage.getEND_POINT());
    }

    @Test
    @DisplayName("")
    void setAllTest() {
        practiceFormPage
                .setAll(dataModel)
                .clickSubmit()
                .checkResult(dataModel);
    }

    @Test
    @DisplayName("")
    void fieldFirstNameTest() {
        practiceFormPage
                .setFirstName(dataModel.getFirstName());
    }

    @Test
    @DisplayName("")
    void fieldLastNameTest() {
        practiceFormPage
                .setLastName(dataModel.getLastName());
    }

    @Test
    @DisplayName("")
    void fieldEmailTest() {
        practiceFormPage
                .setEmail(dataModel.getEmail());
        
    }

    @Test
    @DisplayName("") // За что отвечает?
    void selectGenderTest() {
        practiceFormPage
                .selectGender(dataModel.getGender()); // Почему getGender, а не Gender?
    }

    @Test
    @DisplayName("")
    void radioGenderTest() {
        practiceFormPage.setAll(dataModel);
    }

    @Test
    @DisplayName("")
    void fieldMobileNumberTest() {
        practiceFormPage
                .setMobileNumber(dataModel.getMobileNumber());
    }

    @Test
    @DisplayName("")
    void setDateOfBirthTest() {
        practiceFormPage
                .setDateOfBirth(dataModel.getDateOfBirth());
    }

    @Test
    @DisplayName("")
    void setSubjectTest() {
        practiceFormPage
                .setSubject(dataModel.getSubject());
    }

    @Test
    @DisplayName("")
    void setHobbiesTest() {
        practiceFormPage
                .setHobbies(dataModel.getHobbies());
    }

    @Test
    @DisplayName("")
    void uploadPictureTest() {
        practiceFormPage
                .uploadPicture(dataModel.getFile());
    }

    @Test
    @DisplayName("")
    void setCurrentAddressTest() {
        practiceFormPage
                .setCurrentAddress(dataModel.getCurrentAddress());
    }

    @Test
    @DisplayName("")
    void selectStateCityTest() {
        practiceFormPage
                .selectState(dataModel.getState())
                .selectCity(dataModel);
    }
}
