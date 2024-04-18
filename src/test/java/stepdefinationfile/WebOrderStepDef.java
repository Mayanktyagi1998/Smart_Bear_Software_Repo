package stepdefinationfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageobject.WebOrderPageObj;

import java.io.IOException;

public class WebOrderStepDef extends WebOrderPageObj {
    @Given("enter username and password")
    public void enterUsernameAndPassword() throws IOException {
        WebOrderPageObj.enterUsernameAndPassword("Tester","test");
    }

    @And("click on login button")
    public void clickOnLoginButton() {
         WebOrderPageObj.clickLoginButton();
    }

    @And("click on order button")
    public void clickOnOrderButton() {
      driver.findElement(By.xpath("//a[normalize-space()='Order']")).click();
    }

    @Then("enter all the fields required to create a order and click on process button")
    public void enterAllTheFieldsRequiredToCreateAOrderAndClickOnProcessButton() {
        WebOrderPageObj.selectProduct("FamilyAlbum");
        WebOrderPageObj.enterQuantity("2");
        WebOrderPageObj.addressInformation("Jhon","Turner Road","Boston","Seoul","246793");
        WebOrderPageObj.enterCardDetails(6829012889L,"18/25");
        driver.findElement(By.xpath("(//a[normalize-space()='Process'])[1]")).click();

    }

    @And("validate the successful order creation message")
    public void validateTheSuccessfulOrderCreationMessage() {
        String expmssg = "New order has been successfully added.";
        String actmssg = driver.findElement(By.xpath("//strong[normalize-space()='New order has been successfully added.']")).getText();
        Assert.assertEquals(actmssg,expmssg);
    }

    @Then("click on logout button")
    public void clickOnLogoutButton() throws InterruptedException {
       WebOrderPageObj.logOutButton();
        
    }

    @Then("select order and click on edit button")
    public void selectOrderAndClickOnEditButton() throws InterruptedException {

        driver.findElement(By.xpath("(//a[normalize-space()='View all orders'])[1]")).click();
        WebOrderPageObj.clickOnEditbutton("Mark Smith");
        Thread.sleep(3000);
    }

    @Then("update required fields and click on update button")
    public void updateRequiredFieldsAndClickOnUpdateButton() throws InterruptedException {
        WebOrderPageObj.addressInformation("Jonathan","Turner Road","Swedan","Uk","809238");
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[normalize-space()='Update'])[1]")).click();

    }

    @And("select order and click on delete button")
    public void selectOrderAndClickOnDeleteButton() throws InterruptedException {
        driver.findElement(By.xpath("(//a[normalize-space()='View all orders'])[1]")).click();
        WebOrderPageObj.deleteOrder("Steve Johns");
        Thread.sleep(3000);
    }
}
