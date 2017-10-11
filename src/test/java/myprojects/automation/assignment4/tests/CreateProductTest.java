package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.GeneralActions;
import myprojects.automation.assignment4.utils.Properties;
import myprojects.automation.assignment4.utils.logging.EventHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateProductTest extends BaseTest {

    @Test ()
    public void LogInSite(){
        // TODO вынести ожидания wait сюда в одном месте.
        driver.get(Properties.getBaseAdminUrl());
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterName(Properties.getAdminEmail(), Properties.getAdminPWD());
        signUpPage.submitBtn();
    }

    @Test (dependsOnMethods = { "LogInSite" })
    public void createNewProduct(){
        CreateNewProduct newProduct = new CreateNewProduct(driver);
        newProduct.markCatalogItem();
        newProduct.newProductBtn();
        newProduct.newProductCreated();
        newProduct.activateProduct();
        newProduct.saveProduct();

        LogOut logOut = new LogOut(driver);
        logOut.logOutOnPage();
    }

    @Test ()
    public void newProductFind(){
        driver.get(Properties.getBaseUrl());
        ShowTheProductList showList = new ShowTheProductList(driver);
       // showList.showAllProduct(CreateNewProduct.getFirstName(),CreateNewProduct.getFirstCount(), CreateNewProduct.getFirstPrice());
        showList.showAllProduct(CreateNewProduct.getFirstName());
        showList.openProduct(CreateNewProduct.getFirstName(), CreateNewProduct.getFirstPrice());
    }

}
