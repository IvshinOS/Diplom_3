import io.restassured.response.Response;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import site.nomoreparties.stellarburgers.api.UserApi;
import site.nomoreparties.stellarburgers.Constant;
import site.nomoreparties.stellarburgers.api.UserPojo;

public class BaseTest {
    WebDriver driver;
    String email;
    String password;

    public void initWebDriver() {

        //Для запуска тестов на Yandex
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        //ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\ProjectsPraktikum\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //driver = new ChromeDriver(options);

        //Для запуска тестов на Chrome
        driver = new ChromeDriver();

        driver.get(Constant.BURGER_URL);
    }

    @After
    public void tearDown() {
        String accessToken = UserApi.loginUser(new UserPojo(email,password)).then().extract().path("accessToken");
        if (accessToken != null) {
            UserApi.deleteUser(accessToken);
        }
        driver.quit();
    }
}
