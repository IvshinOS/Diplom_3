import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.api.UserApi;
import site.nomoreparties.stellarburgers.api.UserPojo;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.MainPage;
import site.nomoreparties.stellarburgers.pageobject.PersonalPage;
import site.nomoreparties.stellarburgers.pageobject.RegistrationPage;

public class TestPersonalPage extends BaseTest {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registerPage;
    private PersonalPage personalPage;
    private UserPojo userPojo;

    @Before
    public void setUp() {
        initWebDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegistrationPage(driver);
        personalPage = new PersonalPage(driver);

        //создаем нового пользователя
        String name = "Oleg";
        email = "ios@yandex.ru";
        password = "123456";
        userPojo = new UserPojo(email,password,name);
        UserApi.createUser(userPojo);

        //кликаем "Войти в аккаунт"
        mainPage.clickLogin();
        //ждем загрузки страницы логина
        loginPage.waitForLoad();
        //заполняем форму логина
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
