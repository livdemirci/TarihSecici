package datepicker;

import day10.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class C02_AyinSonGunu extends TestBase {
    @Test
    public void test01() {

        driver.get("https://fengyuanchen.github.io/datepicker/");
        // Tarih seçiciyi göstermek için metin kontrolünü tıklayın
        WebElement calendar = driver.findElement(By.xpath("//*[@class='docs-datepicker']"));
        calendar.click();
        // Yarının tarihini seçin
        LocalDate today = LocalDate.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate tomorrow = today.plusDays(1);
        int yarinAyinKaci = tomorrow.getDayOfMonth();

        if (tomorrow.getMonthValue() != today.getMonthValue()) {
            WebElement yarininGunuElement = driver.findElement(By.xpath("//ul/li[@data-view='month next']"));
            yarininGunuElement.click();
        }

        WebElement yarinElement = driver.findElement(By.xpath("//ul[@data-view='days']//li[text()='" + yarinAyinKaci + "']"));
        yarinElement.click();

        WebElement secilenTarihElement = driver.findElement(By.xpath("//*[@placeholder='Pick a date']"));
        String secilenTarih = secilenTarihElement.getAttribute("value");


        String[] split = secilenTarih.split("/");
        String duzenlenmisTarih = split[1] + "/" + split[0] + "/" + split[2];
        System.out.println("duzenlenmisTarih = " + duzenlenmisTarih);

        String beklenenTarih = tomorrow.format(dateFormatter);
        System.out.println("beklenenTarih = " + beklenenTarih);

        // Seçimden sonra otomatik kapanmadıysa tarih seçiciyi kapatın
        driver.findElement(By.xpath("//body")).click();

        // Seçilen tarihi doğrulayın
        Assert.assertEquals(beklenenTarih, duzenlenmisTarih);
    }
}
