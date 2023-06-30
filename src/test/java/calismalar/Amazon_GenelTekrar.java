package calismalar;

import day10.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Amazon_GenelTekrar extends TestBase {
//    Test01 :
//            1- amazon gidin
//2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
//3. dropdown menude 40 eleman olduğunu doğrulayın
//            Test02
//1. dropdown menuden elektronik bölümü seçin
//2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
//3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
//4. ikinci ürüne relative locater kullanarak tıklayin
//5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
//    Test03
//1. yeni bir sekme açarak amazon anasayfaya gidin
//2. dropdown’dan bebek bölümüne secin
//3. bebek puset aratıp bulundan sonuç sayısını yazdırın
//4. sonuç yazsının puset içerdiğini test edin
//5-üçüncü ürüne relative locater kullanarak tıklayin
//6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
//    Test 4
//            1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın


    @Test
    public void test01() {
//        // 1- amazon gidin
//        driver.get("https://www.amazon.com");
//        //2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
//        WebElement ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
//        Select select = new Select(ddm);
//        List<WebElement> allSelectedOptions = select.getOptions();
//        for (int i = 0; i < allSelectedOptions.size(); i++) {
//            allSelectedOptions = select.getOptions();
//            System.out.println(allSelectedOptions.get(i).getText());


        // 1- amazon gidin
        driver.get("https://www.amazon.com");
        // 2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<String> optionTexts = select.getOptions().stream()
                .map(option -> {
                    WebElement currentOption = option;
                    String text = currentOption.getText();
                    System.out.println(text);
                    return text;
                })
                .collect(Collectors.toList());


    }




//        //3. dropdown menude 28 eleman olduğunu doğrulayın
//        int optionSize = allSelectedOptions.size();
//        System.out.println("optionSize = " + optionSize);
//        System.out.println("========================================");
//        int expectedSize = 28;
//        Assert.assertEquals(expectedSize,optionSize);
//    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        //1. dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Electronics");
        //2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone"+ Keys.ENTER);
        WebElement elementResult = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String resultText = elementResult.getText().split(" ")[3];
        System.out.println("resultText = " + resultText);

        //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin

        Assert.assertTrue(elementResult.getText().contains("iphone"));
        //4. ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrunWebelement = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        WebElement div = driver.findElement(with(By.tagName("div")).toRightOf(ilkUrunWebelement));
        div.click();

        //5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        List<WebElement> elements = driver.findElements(By.xpath("//h2"));
        elements.get(4).click();
        String title = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println("title = " + title);


    }
}
