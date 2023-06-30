package calismalar;

import day10.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_ClickAndHold extends TestBase {
    /*
       1- "http://webdriveruniversity.com/Actions" sayfasina gidin

       2- Hover over  Me First" kutusunun ustune gelin
       3- Link 1" e tiklayin
       4- Popup mesajini yazdirin
       5- Popup'i tamam diyerek kapatin
       6- “Click and hold" kutusuna basili tutun
       7-“Click and hold" kutusunda cikan yaziyi yazdirin  8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        */
    @Test
    public void test01() {

//        1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

//        2- Hover over  Me First" kutusunun ustune gelin
        Actions action = new Actions(driver);
        WebElement firstElement = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        action.moveToElement(firstElement).perform();
        bekle(3);
//        3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//div[@class='dropdown-content'])[1]")).click();
        bekle(1);
//        4- Popup mesajini yazdirin
        String alertText = driver.switchTo().alert().getText();
        System.out.println("alertText = " + alertText);//alertText = Well done you clicked on the link!

//        5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
//        6- “Click and hold" kutusuna basili tutun
        WebElement buttonElement = driver.findElement(By.xpath("(//*[@class='col-lg-12 text-center'])[3]"));
        action.clickAndHold(buttonElement).perform();


//        7-“Click and hold" kutusunda cikan yaziyi yazdirin
        buttonElement=driver.findElement(By.id("click-box"));
        String yazi = buttonElement.getText();
        System.out.println(yazi);


        //8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClickelement = driver.findElement(By.xpath("//*[@id='double-click']"));
        System.out.println(doubleClickelement.getText());
        action.doubleClick(doubleClickelement).perform();
        String renk = doubleClickelement.getCssValue("background-color");
        System.out.println(renk);

        Assert.assertTrue(renk.equals("rgba(147, 203, 90, 1)"));

    }
}
