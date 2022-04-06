package Pages;

import java.io.IOException;
import java.util.List;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Create New Account']")
    WebElement CreateBtn;

    @FindBy(name = "firstname")
    WebElement FirstName;

    @FindBy(name = "lastname")
    WebElement LastName;

    @FindBy(name = "reg_email__")
    WebElement Email;

    @FindBy(name = "reg_email_confirmation__")
    WebElement Email_Confirm;

    @FindBy(id = "password_step_input")
    WebElement Password;

    @FindBy(xpath = "//select[@title='Day']")
    WebElement DaySelect;

    @FindBy(name = "birthday_month")
    WebElement MonthSelect;

    @FindBy(name = "birthday_year")
    WebElement YearSelect;

    @FindBy(xpath = "//label[text()='Male']")
    WebElement Gender;

    @FindBy(xpath = "//button[text()='Sign Up']")
    WebElement SignBtn;

    @FindBy(xpath = "//*[@id=\"conf_dialog_middle_components\"]/div[3]/a")
    WebElement EnterCodeText;

    public void CreateNewAccount() {
        CreateBtn.click();
    }

    public void FillingForm(DataTable dt) throws InterruptedException {
        List<List<String>> data = dt.raw();
        FirstName.sendKeys(data.get(0).get(0));
        LastName.sendKeys(data.get(0).get(1));
        Email.sendKeys(data.get(0).get(2));
        Email_Confirm.sendKeys(data.get(0).get(3));
        Password.sendKeys(data.get(0).get(4));
        Select selectDay = new Select(DaySelect);
        selectDay.selectByVisibleText("10");
        Select selectMonth = new Select(MonthSelect);
        selectMonth.selectByVisibleText("Jul");
        Select selectYear = new Select(YearSelect);
        selectYear.selectByVisibleText("2005");
        Gender.click();
        SignBtn.click();
    }

    public boolean CheckExistOfEnterCode() {
        return EnterCodeText.isEnabled();
    }

    public void SetUpChrome() {
        driver.get("http://facebook.com");
    }
}
