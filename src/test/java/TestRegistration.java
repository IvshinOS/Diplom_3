import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.MainPage;
import site.nomoreparties.stellarburgers.pageObject.RegistrationPage;


public class TestRegistration extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registerPage;
    @Before
    public void setUp() {
        initWebDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegistrationPage(driver);

        //кликаем "Войти в аккаунт"
        mainPage.clickLogin();
        //ждем загрузки страницы логина
        loginPage.waitForLoad();
        //кликаем на Зарегистроваться
        loginPage.clickRegister();
        //ждем загрузки страницы регистрации
        registerPage.waitForLoad();
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void checkRegisterNewUser() {
        //заполняем форму регистрации
        String name = "Oleg";
        email = "ios@ya.ru";
        password = "123456";
        registerPage.fillRegistrationForm(name, email, password);
        //клик на кнопку Зарегистрироваться
        registerPage.clickRegister();
        //ждем загрузки страницы логина
        loginPage.waitForLoad();
        //заполняем форму логина
        loginPage.fillLoginForm(email, password);
        loginPage.clickLogin();
        //ждем загрузки главной страницы
        mainPage.waitForLoad();
        //проверяем что появилась кнопка заказа
        Assert.assertTrue("Регистрация не произошла", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка ввода некорректного пароля")
    public void checkErrorWrongPassword() {
      //заполняем форму регистрации
        String name = "Oleg";
        email = "ios@ya.ru";
        password = "12345";
        registerPage.fillRegistrationForm(name, email, password);
        registerPage.clickRegister();
        password = null;
        //проверяем что появилась надпись о некорректном пароле
        Assert.assertTrue("Ошибка о некорректном пароле не появилась",
                registerPage.isIncorrectPasswordLabelVisible());
    }
}