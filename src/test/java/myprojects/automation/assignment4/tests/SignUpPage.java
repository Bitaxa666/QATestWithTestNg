package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.utils.logging.CustomReporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by user on 10/3/17.
 */
public class SignUpPage extends PageObject {
    @CacheLookup
    @FindBy(id="email")
    private WebElement email;

    @CacheLookup
    @FindBy(id="passwd")
    private WebElement password;

    @CacheLookup
    @FindBy(name = "submitLogin")
    private WebElement submitButton;

    WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).withMessage("Element was not found");

    //Method for login on the site
    public SignUpPage(EventFiringWebDriver driver) {
        super(driver);
    }
    public void enterName(String eml, String pwd) {
        try {

            wait.until(ExpectedConditions.visibilityOf(this.email));
            this.email.clear();
            this.email.sendKeys(eml);

            wait.until(ExpectedConditions.visibilityOf(this.password));
            this.password.clear();
            this.password.sendKeys(pwd);
            CustomReporter.logAction("User is input all value");
        } catch (UnsupportedOperationException ue) {
            ue.printStackTrace();
            System.out.println("Doesn't login on admin panel");
        }
    }

    public void submitBtn(){
        wait.until(ExpectedConditions.visibilityOf(this.submitButton));
        this.submitButton.click();
        CustomReporter.logAction("User is login");
    }
}
