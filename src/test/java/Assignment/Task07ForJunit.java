package Assignment;

import com.beust.ah.A;
import day10.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Struct;
import java.time.Duration;

public class Task07ForJunit extends TestBase {
//    -https://jqueryui.com/slider/#colorpicker adrese gidiniz
//            -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
//-Sarı olduğunu test edelim


    @Test
    public void test01() {
        // https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(iframe);


        //WebElement kirmizi = driver.findElement(By.xpath("(//body/div/span)[1]"));



        WebElement yesil = driver.findElement(By.xpath("((//body/div/span)[2])"));


        Actions actions = new Actions(driver);
        actions.clickAndHold(yesil).perform();

        actions.moveToElement(yesil, -175, 0).perform();
        actions.release(yesil).perform();
        bekle(1);
///////////////////////////////////////////////////////////////////////////////////////////////////////
        //kirmizi yapiniz
        WebElement kirmizi = driver.findElement(By.xpath("((//body/div/span)[1])"));
        actions.clickAndHold(kirmizi).perform();

        actions.moveToElement(kirmizi,1,0).perform();
        actions.release(kirmizi).perform();
        bekle(1);
        /////////////////////////////////////////////////////////////////////////////////////////////////////


        WebElement mavi = driver.findElement(By.xpath("((//body/div/span)[3])"));
        actions.clickAndHold(mavi).perform();
        bekle(1);
        actions.moveToElement(mavi,-76,0).perform();
        actions.release(mavi).perform();


        ////////////////////////////////////////////////////////////////////////////

        //sari yapiniz

        yesil = driver.findElement(By.xpath("((//body/div/span)[2])"));



        actions.clickAndHold(yesil).perform();

        actions.moveToElement(yesil, 300, 0).perform();
        actions.release(yesil).perform();
        bekle(1);



        ////////////////////////////////////////////////////////////////////////////
        WebElement swatch = driver.findElement(By.xpath("//*[@id='swatch']"));
        String styleAttribute = swatch.getAttribute("style");

        System.out.println(styleAttribute);
        String clean = styleAttribute.replaceAll("[^\\d\\s]", "").trim();
        System.out.println("clean = " + clean);



        /////////////////////////////////////////////////////////////////////////////////
        String beklenen= "254 253 1";
        String olan= clean;

        Assert.assertEquals(beklenen,olan);
    }
}