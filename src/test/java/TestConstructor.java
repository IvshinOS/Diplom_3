import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobject.MainPage;

public class TestConstructor extends BaseTest {
    //Проверка работы перехода по разделам:«Булки», «Соусы», «Начинки».
    MainPage mainPage;

    @Before
    public void setUp() {
        initWebDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Соусы'")
    public void checkActiveSauceInConstructor(){
        mainPage.clickSauce();
        Assert.assertTrue("Соусы не активны", mainPage.isSauceActive());
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Начинки'")
    public void checkActiveFillingInConstructor(){
        mainPage.clickFilling();
        Assert.assertTrue("Начинки не активны", mainPage.isFillingActive());
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Булки'")
    public void checkActiveBunInConstructor(){
        mainPage.clickFilling();
        mainPage.clickBun();
        Assert.assertTrue("Булки не активны", mainPage.isBunActive());
    }
}
