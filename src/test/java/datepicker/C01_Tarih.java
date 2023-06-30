package datepicker;

import day10.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_Tarih extends TestBase {
    @Test
    public void test01() {
        driver.get("https://fengyuanchen.github.io/datepicker/");
//        Tarih seçiciyi göstermek için metin kontrolünü tıklayın
        WebElement calendar = driver.findElement(By.xpath("//*[@class='docs-datepicker']"));
        calendar.click();
//        Yarının tarihini seçin
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        int tommorrowDay = tomorrow.getDayOfMonth();
        System.out.println("tomorrow = " + tomorrow);

        WebElement yarinElement = driver.findElement(By.xpath("(//ul[@data-view='days']//li[text()='" + tommorrowDay + "'])[2]"));
        yarinElement.click();

        WebElement secilenTarihElement = driver.findElement(By.xpath("//*[@placeholder='Pick a date']"));
        String secilenTarih = secilenTarihElement.getAttribute("value");
        System.out.println("secilenTarih = " + secilenTarih);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String beklenenTarih = tomorrow.format(dateTimeFormatter);
        System.out.println("beklenenTarih = " + beklenenTarih);

//        Seçimden sonra otomatik kapanmadıysa tarih seçiciyi kapatın
        driver.findElement(By.xpath("//body")).click();
//        Seçilen tarihi doğrulayın
        Assert.assertEquals(beklenenTarih,secilenTarih);
    }
}
