package site.nomoreparties.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;


public class MainPage extends BasePage {

        //Кнопка "Войти в аккаунт"
        private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
        //Кнопка "Личный кабинет"
        private By personalButton = By.linkText("Личный Кабинет");
        //Кнопка раздела "Булки" - активная
        private By activeBunButton = By.xpath("//div[@class='tab_tab__1SPyG " +
                "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
        //Кнопка раздела "Булки" - неактивная
        private By inactiveBunButton = By.xpath("//div[@class='tab_tab__1SPyG  " +
                "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
        //Кнопка раздела "Соусы" - активная
        private By activeSauceButton = By.xpath("//div[@class='tab_tab__1SPyG " +
                "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
        //Кнопка раздела "Соусы" - неактивная
        private By inactiveSauceButton = By.xpath("//div[@class='tab_tab__1SPyG  " +
                "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
        //Кнопка раздела "Начинки" - активная
        private By activeFillingButton = By.xpath("//div[@class='tab_tab__1SPyG " +
                "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
        //Кнопка раздела "Начинки" - неактивная
        private By inactiveFillingButton = By.xpath("//div[@class='tab_tab__1SPyG  " +
                "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
        //Надпись Соберите бургер
        private By makeBurgerLabel = By.xpath("//h1[@class='text text_type_main-large mb-5 mt-10']");
        //Кнопка Оформить заказ
        private By orderButton = By.xpath("//button[text()='Оформить заказ']");
        public MainPage(WebDriver driver) {
            super(driver);
        }

        @Step("Клик по кнопке 'Войти в аккаунт' на главной странице")
        public void clickLogin() {
            driver.findElement(loginButton).click();
        }

        @Step("Ожидание загрузки главной страницы")
        public void waitForLoad() {
            waitForVisibility(makeBurgerLabel);
        }

        @Step("Проверка видимости кнопки 'Оформить заказ'")
        public boolean isOrderButtonVisible() {
            return driver.findElement(orderButton).isDisplayed();
        }

        @Step("Клик на кнопку 'Личный кабинет'")
        public void clickPersonal() {
            driver.findElement(personalButton).click();
        }

        @Step("Клик на 'Соусы'")
        public void clickSauce() {
            driver.findElement(inactiveSauceButton).click();
        }

        @Step("Проверка активности кнопки 'Соусы'")
        public boolean isSauceActive() {
            return driver.findElement(activeSauceButton).isDisplayed();
        }

        @Step("Клик на 'Начинки'")
        public void clickFilling() {
            driver.findElement(inactiveFillingButton).click();
        }

        @Step("Проверка активности кнопки 'Начинки'")
        public boolean isFillingActive() {
            return driver.findElement(activeFillingButton).isDisplayed();
        }

        @Step("Клик на 'Булки'")
        public void clickBun() {
            driver.findElement(inactiveBunButton).click();
        }

        @Step("Проверка активности кнопки 'Булки'")
        public boolean isBunActive() {
            return driver.findElement(activeBunButton).isDisplayed();
        }
    }
