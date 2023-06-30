package Assignment;

import day10.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task05ForJunit extends TestBase {
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin

    // ikinci emojiye tıklayın
    // İkinci emoji öğelerini yazdırınız
    // Parent iframe e geri donun
    // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
    // Apply button a basiniz


    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın
        WebElement emoojis = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(emoojis);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();
        // İkinci emoji öğelerini yazdırınız
        List<WebElement> emojilerList = driver.findElements(By.xpath("//*[@id='nature']//div"));
        emojilerList.forEach(t-> System.out.println(t.getText()));
        // Parent iframe e geri donun
        driver.switchTo().defaultContent();
        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> form = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        ArrayList<String> veriler = new ArrayList<>(Arrays.asList("Mustafa", "livdemirci", "selenium", "lambda", "java", "sql", "gitgithub", "fsd", "dfasf", "lkjl", "asdasd", "asd", "sda"));

        for (int i = 0; i <form.size(); i++) {
            form.get(i).sendKeys(veriler.get(i) );

        }
        driver.findElement(By.xpath("//*[text()='Apply']")).click();
        // Apply button a basiniz
    }
}
