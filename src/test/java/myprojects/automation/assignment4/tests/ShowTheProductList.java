package myprojects.automation.assignment4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by user on 10/9/17.
 */
public class ShowTheProductList extends PageObject {

    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = "i.material-icons.shopping-cart")
    private WebElement logOutIcon;

    @FindBy(tagName = "body")
    private WebElement bodyText;

    @FindBy (css = ".all-product-link.pull-xs-left.pull-md-right.h4")
    private WebElement allProductBtn;


    //@FindBy (css = ".h3.product-title")
    @FindBy (css = ".product-description")
    private WebElement productList;

    public ShowTheProductList(EventFiringWebDriver driver) {
        super(driver);
    }

    public void showAllProduct(String name, String count, String price){
    //public void showAllProduct(){

        this.allProductBtn.click();

        waitTheElement(driver, logOutIcon, 5);

        softAssert.assertEquals(name, String.valueOf(bodyText.getText().contains(CreateNewProduct.getFirstName())));
        //softAssert.assertEquals("Blouse", "Blouse");
        Reporter.log("The your element is find");
    }
    public void openProduct(){
       //List<WebElement> nameProducts = new List<WebElement>();
      //  добавим в список ряд элементов
//
//        nameProducts = productList.findElements(By.cssSelector("h1"));
//
//        System.out.printf("В списке %d элементов \n", nameProducts.size());
//        for(WebElement prod : nameProducts){
//
//            if(prod.getText() == CreateNewProduct.getFirstName()) {
//                System.out.println(prod.getText());
//                prod.click();
//            }
//
//        }
        List<WebElement> elements = driver.findElements(By.cssSelector(".product-description h1"));
        java.util.Iterator<WebElement> i = elements.iterator();
        while(i.hasNext()) {
            WebElement element = i.next();
            if (element.getText() == "Blouse") {
                System.out.println(element.getText() + "web is find");
            }
        }

     //   productList.findElements(By.cssSelector("h1")).get(0).getText();
      //  System.out.println("Product is finded: " + productList.findElements(By.cssSelector("h1")).get(0).getText());

    }

    public void waitTheElement(EventFiringWebDriver driver, WebElement element, int timeSec){
        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        wait.until(ExpectedConditions. elementToBeClickable(element));
    }

}
