package site.nomoreparties.stellarburgers.pageobject;

import org.openqa.selenium.By;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    //Надпись Регистрация
    private By registerLabel = By.xpath("//h2[text()='Регистрация']");
    //Поле Имя
    private By nameField = By.xpath("//label[text()='Имя']/../input");
    //Поле Email
    private By emailField = By.xpath("//label[text()='Email']/../input");
    //Поле Пароль
    private By passwordField = By.xpath("//label[text()='Пароль']/../input");
    //Кнопка Зарегистрироваться
    private By registerButton = By.xpath("//button[@class='button_button__33qZ0 " +
            "button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //Кнопка Войти
    private By loginButton = By.xpath("//a[@href='/login']");
    //Надпись Некорректный пароль
    private By incorrectPasswordLabel = By.xpath("//p[@class='input__error text_type_main-default']");
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки страницы Регистрации")
    public void waitForLoad() {
        waitForVisibility(registerLabel);
    }

    @Step("Заполнение формы регистрации")
    public void fillRegistrationForm(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик на кнопку 'Зарегистрироваться'")
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    @Step("Проверка видимости надписи 'Неправильный пароль'")
    public boolean isIncorrectPasswordLabelVisible() {
        return driver.findElement(incorrectPasswordLabel).isDisplayed();
    }

    @Step("Клик на кнопку 'Войти'")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
