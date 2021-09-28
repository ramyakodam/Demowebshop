package learntesting;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class GridDemo {
    WebDriver driver;
    @Test
    public void testLogin() throws MalformedURLException
    {
        DesiredCapabilities cpt = DesiredCapabilities.chrome();
        cpt.setBrowserName("chrome");
        cpt.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://192.168.56.1:4344/wd/hub"),cpt);
        
        driver.get("http://demowebshop.tricentis.com/login");
        driver.manage().window().maximize();
        System.out.println("Start Application");
        String actualtitle = driver.getTitle();    
        System.out.println(actualtitle);
    
        driver.findElement(By.id("Email")).sendKeys("kodamshanku66@gmail.com");
        driver.findElement(By.name("Password")).sendKeys("shanku");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        System.out.println("Successfully Login");
        driver.findElement(By.linkText("Log out")).click();
    }
}
