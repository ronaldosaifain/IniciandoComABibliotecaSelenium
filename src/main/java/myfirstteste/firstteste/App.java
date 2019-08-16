package myfirstteste.firstteste;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver","C:\\drive\\chromedriver.exe");
    
       WebDriver navegador = new ChromeDriver();
       navegador.manage().timeouts().implicitlyWait(20, TimeUnit.HOURS);
       
       navegador.get("https:\\www.amazon.com.br");
       
       navegador.findElement(By.name("field-keywords")).sendKeys("Iphone");
       navegador.findElement(By.className("nav-input")).click();
       
       
        System.out.println(navegador.findElement(By.className("a-size-medium a-color-base a-text-normal")).getText());
       
    }
}
