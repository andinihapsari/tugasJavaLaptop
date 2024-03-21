package TestCase;

import io.qameta.allure.Description;
import junit.framework.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AddToCart extends BaseTest {
    @Test(priority = 3)
    @Description("Add to Cart from Laptop category and navigate to Cart")
    public void testAddToCartAndNavigateToCart() throws InterruptedException {
        // Click on Laptops category
        WebElement laptopsCat = driver.get().findElement(By.xpath("//a[.='Laptops']"));
        laptopsCat.click();

        Thread.sleep(4000);

        // Select the first laptop listed
        WebElement firstLaptop = driver.get().findElement(By.xpath("//a[normalize-space()='Sony vaio i5']"));
        firstLaptop.click();

        Thread.sleep(2000);

        // Click on Add to Cart button
        WebElement addToCartBtn = driver.get().findElement(By.xpath("//a[normalize-space()='Add to cart']"));
        addToCartBtn.click();

        // Handle alert
        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Navigate to Cart
        WebElement cartLink = driver.get().findElement(By.xpath("//a[@id='cartur']"));
        cartLink.click();

        // Validate that the added laptop appears in the cart
        WebElement cartItem = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='cart_product']")));
        String itemNameInCart = cartItem.getText();
        String expectedItemName = firstLaptop.getText();
        Assert.assertEquals(itemNameInCart, expectedItemName);
    }
}
