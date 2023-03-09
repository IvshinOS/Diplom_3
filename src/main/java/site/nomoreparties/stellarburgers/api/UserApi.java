package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import site.nomoreparties.stellarburgers.Constant;

import static io.restassured.RestAssured.given;

//API запросы для авторизации и удаления пользователя
public class UserApi extends ApiBase {

    @Step("Удаление пользователя (DELETE /api/auth/user)")
    public static Response deleteUser(String accessToken) {
        setUp();
        return given()
                .header("Authorization",accessToken)
                .when()
                .delete(Constant.BURGER_API_USER_DELETE);
    }

    @Step("Авторизация пользователя (POST /api/auth/login)")
    public static Response loginUser(UserPojo userPojo) {
        setUp();
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userPojo)
                .when()
                .post(Constant.BURGER_API_USER_AUTH);
    }
    @Step("Создание пользователя POST /api/auth/register")
    public static Response createUser(UserPojo userPojo){
        setUp();
        return given()
                .header("Content-type", "application/json")
                .body(userPojo)
                .when()
                .post(Constant.BURGER_API_USER_CREATE);
    }
}
