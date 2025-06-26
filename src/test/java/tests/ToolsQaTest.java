package tests;

import org.junit.jupiter.api.Test;
import pageObjects.ToolsQA.FormPage;
import settings.BaseTest;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.open;

public class ToolsQaTest extends BaseTest {

    FormPage formPage = new FormPage();

    private final static String BASE_URL = "https://demoqa.com/";
    private final static String FORM_ENDPOINT = "automation-practice-form";



    @Test
    void formToolsQaTest() {
        HashMap<String, String> formMap = new HashMap<>();
        formMap.put("Ivan", "Chai");

        open(BASE_URL + FORM_ENDPOINT);
        formPage
                .setGender(0)
                .setName("Ivan", "Chai")
                .setEmail("sobaka@sobaka.com")
                .setMobile("19888444333")
                .setBirthDate("31", "December","1997")
                .setSubjects("English, Physics, Computer Science")
                .setHobbies(true,false,true)
                .setPicture("src\\test\\resources\\image_test.jpeg")
                .setAddress("Улица Пушкина, \nДом Колотушкина")
                .setStateAndCity("NCR", "Noida")
                .clickSubmit()
                .setStateAndCity("NCR", "Noida");
    }

    @Test
    void formToolsQaTest2() {
        open(BASE_URL + FORM_ENDPOINT);
        formPage
                .setGender(1);
    }

    @Test
    void formToolsQaTest3() {
        open(BASE_URL + FORM_ENDPOINT);
        formPage
                .setGender(2);
    }

}
