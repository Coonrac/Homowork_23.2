package ru.mazaev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWGoogle {
    WebDriver webDriver;

    @Test
    public void HelloWorld(){
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");

        WebElement searchInput = webDriver.findElement(By.name("q")); // Ищем оле ввода
        searchInput.sendKeys("Hello World"); // Вбиваем тебуемый текст в поле ввода
        searchInput.submit(); // Производим поиск в поисковике

        String title = webDriver.getTitle();
        Assert.assertTrue(title.contains("Hello World")); // Проверяем в имени вкладки текст
    }

    @After
    public void closeDriver(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
