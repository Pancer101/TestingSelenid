package pageObjects.ToolsQA;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FormPage {
    private final String universalXPath = "//label[text()='%s']//parent::div//following-sibling::div";
    private final String uniEndTable = "//td[text()='%s']//following-sibling::td";
    private final ElementsCollection genderXPath = $$x("//div[@id='genterWrapper']//input//parent::div");
    private final SelenideElement submitButton = $x("//button[text()='Submit']");

    public FormPage setGender(int element_number){

        try {
            genderXPath.get(element_number).click();
        }
        catch (Exception e) {
            throw new RuntimeException("Неправильное значение для пола: " + e);
        }
        return this;
    }

    public FormPage setName(String first_name, String last_name){

        try {
            ElementsCollection nameCollection = $$x(String.format(universalXPath + "//input", "Name"));

            nameCollection.get(0).sendKeys(first_name);
            nameCollection.get(1).sendKeys(last_name);
        }
        catch (Exception e) {
            throw new RuntimeException("Неправильное имя: " + e);
        }
        return this;
    }

    public FormPage setEmail(String value){
        try {
            $x(String.format(universalXPath + "//input", "Email")).sendKeys(value);
        }
        catch (Exception e) {
            throw new RuntimeException("Неправильная почта: " + e);
        }
        return this;
    }

    public FormPage setMobile(String value){

        try {
            $x(String.format(universalXPath + "//input", "Mobile")).sendKeys(value);
        }
        catch (Exception e) {
            throw new RuntimeException("Неправильный номер: " + e);
        }
        return this;
    }

    public FormPage setBirthDate(String day, String month, String year){

        try {
            SelenideElement date = $x(String.format(universalXPath + "//input", "Date of Birth"));

            date.click();
            $x("//select[@class='react-datepicker__year-select']").selectOption(year);
            $x("//select[@class='react-datepicker__month-select']").selectOption(month);
            $x("//div[@class='react-datepicker__month']//div[text()='" + day + "']").click();
        }
        catch (Exception e) {
            throw new RuntimeException("Некорректная дата: " + e);
        }
        return this;
    }

    public FormPage setSubjects(String subjects){

        try {
            SelenideElement subjects_input = $x(String.format(universalXPath + "//input", "Subjects"));

            String[] subjectsArray = subjects.split(",");
            for (int i = 0; i < subjectsArray.length; i++) {
                subjectsArray[i] = subjectsArray[i].trim();
            }

            for (String subject : subjectsArray) {
                // Вводим текст предмета
                subjects_input.shouldBe(visible).sendKeys(subject);

                // Ожидаем появления и выбираем элемент из выпадающего списка
                $x(String.format("//div[contains(@class, 'subjects-auto-complete__menu')]//div[text()='%s']", subject))
                        .shouldBe(visible)
                        .click();
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Не выбраны преметы: " + e);
        }
        return this;
    }

    public FormPage setHobbies(Boolean sports, Boolean reading, Boolean music){

        try {
            ElementsCollection hobbiesCollection = $$x(String.format(universalXPath + "//label", "Hobbies"));
            Boolean[] hobbyValues = {sports, reading, music};

            for (int i = 0; i < hobbiesCollection.size() ;i++) {
                if (hobbyValues[i] && !hobbiesCollection.get(i).isSelected()){
                    hobbiesCollection.get(i).click(); // Ставим галочку
                } else if (!hobbyValues[i] && hobbiesCollection.get(i).isSelected()) {
                    hobbiesCollection.get(i).click(); // Снимаем галочку
                }
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Ошибка выбора хобби: " + e);
        }
        return this;
    }

    public FormPage setPicture(String value) {

        try {
            File file = new File(value);
            $x(String.format(universalXPath + "//input", "Picture")).uploadFile(file);
        }
        catch (Exception e) {
           throw new RuntimeException("Файл не найден: " + e);
        }
        return this;
    }

    public FormPage setAddress(String value) {

        try {
            $x(String.format(universalXPath + "//textarea", "Current Address")).sendKeys(value);
        }
        catch (Exception e) {
            throw new RuntimeException("Отсутствует адресс: " + e);
        }
        return this;
    }

    public FormPage setStateAndCity(String state, String city) {
        // Ввод штата
        try {
            SelenideElement stateInput = $x("//input[@id='react-select-3-input']");
            stateInput.shouldBe(visible).sendKeys(state);
            $x(String.format("//div[contains(@class, 'css-1n7v3ny-option') and text()='%s']", state))
                    .shouldBe(visible)
                    .click();
        }
        catch (Exception e) {
            throw new RuntimeException("Не выбран штат: " + e);
        }
        // Ввод города
        try {
            SelenideElement cityInput = $x("//input[@id='react-select-4-input']");

            cityInput.shouldBe(visible).sendKeys(city);
            $x(String.format("//div[contains(@class, 'css-1n7v3ny-option') and text()='%s']", city))
                    .shouldBe(visible)
                    .click();
        }
        catch (Exception e) {
            throw new RuntimeException("Не выбран город: " + e);
        }
        return this;
    }

    public FormPage clickSubmit(){

        try {
            submitButton.shouldBe(visible).click();
        }
        catch (Exception e) {
            throw new RuntimeException("Кнопка не обнаруена: " + e);
        }
        return this;
    }

    public FormPage checkTable(String labelName, String value){

        $x(String.format(uniEndTable, labelName)).shouldHave(exactText(value));

        return this;
    }
}
