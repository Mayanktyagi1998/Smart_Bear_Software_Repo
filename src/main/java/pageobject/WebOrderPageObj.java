package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import resuableclass.BaseClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebOrderPageObj extends BaseClass {

    public static List<WebElement> col2;
    public static List<String> colVal2;
    public static WebElement element;
    public static void enterUsernameAndPassword(String username,String password) throws IOException {
        BaseClass.invokeBrowser();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
    }
    public static void clickLoginButton()
    {
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }
    public static void selectProduct(String product)
    {
        WebElement dropdown = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select val = new Select(dropdown);
        val.selectByValue(product);
    }
    public static void enterQuantity(String quantity)
    {
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(String.valueOf(quantity));
    }
    public static void addressInformation(String custName,String street,String city,String state,String zip)
    {
        WebElement customer_name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        customer_name.clear();
        customer_name.sendKeys(custName);
        WebElement street_Name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        street_Name.clear();
        street_Name.sendKeys(street);
        WebElement city_Name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        city_Name.clear();
        city_Name.sendKeys(city);
        WebElement state_Name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        state_Name.clear();
        state_Name.sendKeys(state);
        WebElement zipCpde = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipCpde.clear();
        zipCpde.sendKeys(zip);
    }
    public static void enterCardDetails(Long carNr,String date)
    {
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(String.valueOf(carNr));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(date);
        driver.findElement(By.xpath("(//a[normalize-space()='Process'])[1]")).click();
    }
    public static void logOutButton() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='ctl00_logout']")).click();
        Thread.sleep(3000);
        driver.close();
    }
    /*public static String fetchWebElementDetails()
    {
        element = driver.findElement(By.xpath(("(//table[@id='ctl00_MainContent_orderGrid'])[1]")));
        col2 = element.findElements(By.tagName("td"));
        colVal2 = new ArrayList<>();
        return String.valueOf(colVal2);
    }*/
    public static  void clickOnEditbutton(String name)
    {

        for(WebElement val: col2)
        {
            colVal2.add(val.getText());
        }
        if(colVal2.contains(name))
        {
            element.findElement(By.xpath("//*[contains(text(),'"+name+"')]/following-sibling::td[11]")).click();
        }
    }
    public static void deleteOrder(String name)
    {

        element = driver.findElement(By.xpath(("(//table[@id='ctl00_MainContent_orderGrid'])[1]")));
        col2 = element.findElements(By.tagName("td"));
        colVal2 = new ArrayList<>();
        for(WebElement val: col2)
        {
            colVal2.add(val.getText());
        }
        if(colVal2.contains(name))
        {
            element.findElement(By.xpath("//*[contains(text(),'"+name+"')]/ancestor::tr[1]/td[1]")).click();
        }
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
    }
}
