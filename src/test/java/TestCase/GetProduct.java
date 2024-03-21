package TestCase;

import io.qameta.allure.Description;
import junit.framework.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class GetProduct extends BaseTest{
    @Test(priority = 1) //urutan yg diuji mau yg mana dulu!!
    @Description("Test price") //kalo allurenya gak bisa gausah pake description!!
    public void getPrice(){
        //Test dan Assert(Validasi) harga Smartphone Galaxy s6
        WebElement phonesCat = driver.get().findElement(By.xpath("//a[.='Phones']"));
        phonesCat.click();

        WebElement samsung = driver.get().findElement(By.xpath("//a[.='Samsung galaxy s6']"));
        samsung.click();

        //Assert or Validate price
        WebElement price = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='price-container']")));
        Assert.assertTrue(price.getText().contains("$360"));
    }

    @Test(priority = 2)
    @Description("Test Description: Sign Up functionality check.")
    public void testSignUp() {
        driver.get().findElement(By.xpath("//a[.='Sign up']")).click();
        explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        driver.get().findElement(By.id("sign-username")).sendKeys("Fuy");
        driver.get().findElement(By.id("sign-password")).sendKeys("hohoho123");
        driver.get().findElement(By.xpath("//button[.='Sign up']")).click();

        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Sign up successful.") || alertMessage.equals("This user already exist."));
        alert.accept();
    }

    //@Test(priority = 3)
    //@Description ("Add to Cart")
}
