package site.nomoreparties.stellarburgers.api;

import io.restassured.RestAssured;
import site.nomoreparties.stellarburgers.Constant;


public class ApiBase {

    protected static void setUp(){
        RestAssured.baseURI = Constant.BURGER_URL;
    }
}
