package com.tests.forms;

import com.models.forms.InputDataModel;
import com.pages.forms.PracticeFormPage;
import com.settings.BaseTest;
import io.qameta.allure.Description;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class test extends BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    private final InputDataModel dataModel = new EasyRandom().nextObject(InputDataModel.class);

    @BeforeEach
    void before() {
        open(PracticeFormPage.getEND_POINT());
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
    @DisplayName("")
    void radioGenderTest() {

    }
}
