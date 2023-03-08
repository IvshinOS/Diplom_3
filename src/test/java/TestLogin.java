import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.MainPage;
import site.nomoreparties.stellarburgers.pageObject.RegistrationPage;
import site.nomoreparties.stellarburgers.pageObject.ResetPasswordPage;

public class TestLogin extends BaseTest {

    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registerPage;

    @Before
    public void setUp() {
        initWebDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegistrationPage(driver);

        //"Войти в аккаунт"
        mainPage.clickLogin();
        //ждем загрузки страницы
        loginPage.waitForLoad();
        //кликаем на Зарегистроваться
        loginPage.clickRegister();
        //ждем загрузки страницы
        registerPage.waitForLoad();
        //создаем нового пользователя
        String name = "Oleg";
        email = "ios@yandex.ru";
        password = "123456";
        registerPage.fillRegistrationForm(name, email, password);
        //клик на кнопку Зарегистрироваться
        registerPage.clickRegister();
        //ждем загрузки страницы
        loginPage.waitForLoad();
        //клик на логотип
        loginPage.clickLogo();
        //Ждем загрузки главной
        mainPage.waitForLoad();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void checkLoginOnMainPage() {
        //клик на кнопку войти
        mainPage.clickLogin();
        //заполняем форму логина
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLogin();
        //Проверяем что появилась кнопка оформить заказ
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка оформить заказ не появилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void checkLoginByPersonalButton() {
        //клик на кнопку личный кабинет
        mainPage.clickPersonal();
        //заполняем форму логина
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLogin();
        //Проверяем что появилась кнопка оформить заказ
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка оформить заказ не появилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void checkLoginOnRegistrationPage() {
        mainPage.clickLogin();
        //ждем загрузки страницы логина
        loginPage.waitForLoad();
        //кликаем на Зарегистроваться
        loginPage.clickRegister();
        //ждем загрузки страницы регистрации
        registerPage.waitForLoad();
        //клик на кнопку Войти
        registerPage.clickLogin();
        //заполняем форму логина
        loginPage.waitForLoad();
        loginPage. fillLoginForm(email, password);
        loginPage.clickLogin();
        //Проверяем что появилась кнопка оформить заказ
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка оформить заказ не появилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void checkLoginOnResetPasswordPage() {
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);

        mainPage.clickLogin();
        loginPage.waitForLoad();
        loginPage.clickReset();
        //Кликаем на Войти
        resetPasswordPage.waitForLoad();
        resetPasswordPage.clickLogin();
        //ждем загрузки страницы регистрации
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLogin();
        //Проверяем что появилась кнопка оформить заказ
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка оформить заказ не появилась", mainPage.isOrderButtonVisible());
    }
}
