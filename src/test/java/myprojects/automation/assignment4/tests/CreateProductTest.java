package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.GeneralActions;
import myprojects.automation.assignment4.model.ProductData;
import myprojects.automation.assignment4.utils.Properties;
import myprojects.automation.assignment4.utils.logging.EventHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateProductTest extends BaseTest {

    private ProductData productData = null;

    public CreateProductTest() {
        this.productData = ProductData.generate();
    }

    @Test ()
    public void logInSite(){
        // TODO вынести ожидания wait сюда в одном месте.
        driver.get(Properties.getBaseAdminUrl());
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterName(Properties.getAdminEmail(), Properties.getAdminPWD());
        signUpPage.submitBtn();
    }

    @Test (dependsOnMethods = { "logInSite" })
    public void aCreateNewProduct(){
        CreateNewProduct newProduct = new CreateNewProduct(driver);
        newProduct.markCatalogItem();
        newProduct.newProductBtn();
        newProduct.newProductCreated(getFirstName(),getFirstCount(), getFirstPrice());
        newProduct.activateProduct();
        newProduct.saveProduct();

        LogOut logOut = new LogOut(driver);
        logOut.logOutOnPage();
    }

    @Test ()
    public void newProductFind(){

        ShowTheProductList showList = new ShowTheProductList(driver);
        showList.showAllProduct(getFirstName());
        showList.openProductTest(getFirstName(), getFirstPrice());
    }

    public String getFirstName() {

        return this.productData.getName();
    }
    public String getFirstCount() {

       return String.valueOf(this.productData.getQty());
    }

    public String getFirstPrice() {

        return this.productData.getPrice();
    }

}
