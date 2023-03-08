package site.nomoreparties.stellarburgers.pageObject;

import org.openqa.selenium.By;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage extends BasePage{

    //Надпись Восстановление пароля
    private By resetPasswordLabel = By.xpath("//h2[text()='Восстановление пароля']");
    //Кнопка Войти
    private By loginButton = By.xpath("//a[@href='/login']");
    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик на 'Войти'")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Ожидание загрузки страницы восстановления пароля")
    public void waitForLoad() {
        waitForVisibility(resetPasswordLabel);
    }
}