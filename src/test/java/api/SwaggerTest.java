package api;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class SwaggerTest {

    @Test
    void loginTest() {
        Map<String, Object> backValues = new HashMap<>();

        backValues.put("userName", "string");
        backValues.put("password", "string");

        given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(backValues)
                .when()
                .post("https://demoqa.com/Account/v1/Authorized")
                .then()
                .statusCode(200);
    }

    @Test
    void generateTokenTest() {

        Response response = given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"userName\" : \"Igor\"," +
                        "\"password\" : \"12345\"" +
                        "}")
                .when()
                .post("https://demoqa.com/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .extract().response();

        JsonPath peremennaia = response.jsonPath();
        assertNull(peremennaia.get("token"));
        assertNull(peremennaia.get("expires"));
        assertTrue(peremennaia.get("status").equals("Failed"));
        assertEquals("User authorization failed.", peremennaia.get("result"));
    }

    @Test
    void deleteUserTest() {
        String userId = "3412123"; // Значение из скриншота

        given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .pathParam("UUID", userId)
                .when()
                .delete("https://demoqa.com/Account/v1/User/{UUID}")
                .then()
                //.log().all() // Логируем ответ для диагностики
                .statusCode(401);
    }

    @Test
    void getUserTest() {
        String userId = "UserId"; // Замените на реальный UserId

        given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .pathParam("UUID", userId)
                .when()
                .get("https://demoqa.com/Account/v1/User/{UUID}")
                .then()
                .log().all() // Логируем ответ для диагностики
                .statusCode(200)
                .body("userId", equalTo(userId)) // Проверяем, что userId совпадает
                .body("books", equalTo("")) // Проверяем пустой список книг (по умолчанию)
                .body("isbn", equalTo("")) // Проверяем пустое значение isbn
                .body("title", equalTo("")) // Проверяем пустое значение title
                .body("subTitle", equalTo("")) // Проверяем пустое значение subTitle
                .body("author", equalTo("")) // Проверяем пустое значение author
                .body("publishDate", equalTo("")) // Проверяем пустое значение publishDate
                .body("publisher", equalTo("")) // Проверяем пустое значение publisher
                .body("pages", equalTo(0)) // Проверяем пустое значение pages
                .body("description", equalTo("")) // Проверяем пустое значение description
                .body("website", equalTo("")); // Проверяем пустое значение website
    }

    @Test
    void addBooksTest() {
        // Подготовка тела запроса согласно Swagger
        Map<String, Object> book = new HashMap<>();
        book.put("userId", "string");
        book.put("collectionOfIsbns", new String[]{"isbn1", "isbn2"});

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("addListOfBooks", new Map[]{book});

        given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .contentType("application/json") // Указываем тип контента
                .body(requestBody)
                .when()
                .post("https://demoqa.com/BookStore/v1/Books")
                .then()
                .log().all() // Логируем ответ для диагностики
                .statusCode(201) // Ожидаем успешное создание
                .body("isbn", equalTo("isbn1")); // Проверяем первый ISBN из ответа
    }

    @Test
    void updateBookTest() {
        // Подготовка тела запроса согласно Swagger
        Map<String, Object> replaceIsbn = new HashMap<>();
        replaceIsbn.put("userId", "string");
        replaceIsbn.put("isbn", "new_isbn");

        given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .contentType("application/json") // Указываем тип контента
                .pathParam("ISBN", "existing_isbn") // Замените на реальный ISBN
                .body(replaceIsbn)
                .when()
                .put("https://demoqa.com/BookStore/v1/Books/{ISBN}")
                .then()
                .log().all() // Логируем ответ для диагностики
                .statusCode(200) // Ожидаем успешное обновление
                .body("userId", equalTo("string")) // Проверяем обновлённое userId
                .body("isbn", equalTo("new_isbn")); // Проверяем обновлённый isbn
    }
}
