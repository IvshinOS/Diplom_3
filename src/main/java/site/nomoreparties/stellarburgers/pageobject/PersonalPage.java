package site.nomoreparties.stellarburgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalPage extends BasePage {

    //Кнопка Конструктор
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    //Логотип
    private By logoButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");
    //Кнопка Профиль
    private By profileButton = By.xpath("//a[@href='/account/profile']");
    //Кнопка Выход
    private By logoutButton = By.xpath("//li[@class='Account_listItem__35dAP']/button");
    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки главной страницы")
    public void waitForLoad() {
        waitForVisibility(profileButton);
    }

    @Step("Проверка видимости кнопки 'Профиль'")
    public boolean isProfileButtonVisible() {
        return driver.findElement(profileButton).isDisplayed();
    }

    @Step("Клик на кнопку 'Конструктор'")
    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик на логотип")
    public void clickLogo() {
        driver.findElement(logoButton).click();
    }

    @Step("Клик на 'Выйти'")
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}