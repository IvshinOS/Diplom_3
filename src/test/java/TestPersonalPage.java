import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.MainPage;
import site.nomoreparties.stellarburgers.pageObject.PersonalPage;
import site.nomoreparties.stellarburgers.pageObject.RegistrationPage;

public class TestPersonalPage extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registerPage;
    PersonalPage personalPage;

    @Before
    public void setUp() {
        initWebDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegistrationPage(driver);
        personalPage = new PersonalPage(driver);

        //кликаем "Войти в аккаунт"
        mainPage.clickLogin();
        //ждем загрузки страницы логина
        loginPage.waitForLoad();
        //кликаем на Зарегистроваться
        loginPage.clickRegister();
        //ждем загрузки страницы регистрации
        registerPage.waitForLoad();
        //заполняем форму регистрации
        String name = "Oleg";
        email = "ios@yandex.ru";
        password = "123456";
        registerPage.fillRegistrationForm(name, email, password);
        //клик на кнопку Зарегистрироваться
        registerPage.clickRegister();
        //ждем загрузки страницы логина
        loginPage.waitForLoad();
        //клик на логотип
        loginPage.clickLogo();
        //Ждем загрузки главной
        mainPage.waitForLoad();
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
        loginPage.fillLoginForm(email, password);
        loginPage.clickLogin();
        mainPage.waitForLoad();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет».")
    public void checkEnterPersonalAccount() {
        //клик на личный кабинет
        mainPage.clickPersonal();
        //проверяем видимость кнопки профиль
        personalPage.waitForLoad();
        Assert.assertTrue("Вход в личный кабинет не выполнен", personalPage.isProfileButtonVisible());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void checkEnterConstructorByConstructorButton() {
        //клик на личный кабинет
        mainPage.clickPersonal();
        personalPage.waitForLoad();
        //кликаем на Конструктор
        personalPage.clickConstructor();
        //Проверяем видимость кнопки оформить заказ
        mainPage.waitForLoad();
        Assert.assertTrue("Переход в конструктор не произошел", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void checkEnterConstructorByLogo() {
   //клик на личный кабинет
        mainPage.clickPersonal();
        personalPage.waitForLoad();
        //кликаем на лого
        personalPage.clickLogo();
        //Проверяем видимость кнопки оформить заказ
        mainPage.waitForLoad();
        Assert.assertTrue("Переход в конструктор не произошел", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка выхода по кнопке Выйти")
    public void checkLogoutByButtonLogout() {
        //клик на личный кабинет
        mainPage.clickPersonal();
        personalPage.waitForLoad();
        //клик на Выйти
        personalPage.clickLogout();
        //проверяем что перешли на страницу Логина
        loginPage.waitForLoad();
        Assert.assertTrue("Выход не произошел", loginPage.isEnterLabelVisible());
    }
}
