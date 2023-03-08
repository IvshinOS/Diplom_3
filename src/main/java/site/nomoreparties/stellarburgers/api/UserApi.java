package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import site.nomoreparties.stellarburgers.Constant;

import static io.restassured.RestAssured.given;

//API запросы для авторизации и удаления пользователя
public class UserApi extends ApiBase {

    @Step("Извлечение accessToken")
    public static String getAccessToken(Response response) {
        setUp();
        return response.body().as(AnswerLoginPojo.class)
                .getAccessToken().replace("Bearer ", "");
    }

    @Step("Удаление пользователя (DELETE /api/auth/user)")
    public static Response deleteUser(String accessToken) {
        setUp();
        return given()
                .auth().oauth2(accessToken)
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
}
