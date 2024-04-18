package resuableclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;

    public static void invokeBrowser() throws IOException {
        FileInputStream file = new FileInputStream("src/main/resources/configuration/utility.properties");
         prop = new Properties();
         prop.load(file);
         if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else
        {
            driver = new EdgeDriver();
        }
        driver.navigate().to(prop.getProperty("testEnvo"));
        driver.manage().window().maximize();
    }
}
