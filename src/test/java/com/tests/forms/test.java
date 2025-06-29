package com.tests.forms;

import com.models.forms.InputDataModel;
import com.pages.forms.PracticeFormPage;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.pages.forms.PracticeFormPage.END_POINT;

public class test {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    private final InputDataModel dataModel = new EasyRandom().nextObject(InputDataModel.class);

    @Test
    void adfasdfasd() {
        open(END_POINT);

    }
}
