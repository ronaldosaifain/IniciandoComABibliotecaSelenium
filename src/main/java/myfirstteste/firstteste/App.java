package myfirstteste.firstteste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	@Test
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\drive\\chromedriver.exe");

		String path = "C:\\Users\\Samsung\\Desktop\\text.xls";

		WebDriver navegador = new ChromeDriver();

		navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		navegador.get("https://www.amazon.com.br");

		navegador.findElement(By.name("field-keywords")).sendKeys("Iphone");
		navegador.findElement(By.className("nav-input")).click();

		List<String> listaIphones = new ArrayList<String>();

		Integer i = 0;

		for (i = 1; i < 17; i++) {
			String buttonXpath = " //*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[" + i
					+ "]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span";

			String Iphone = navegador.findElement(By.xpath(buttonXpath)).getText();

			listaIphones.add(Iphone + "\n");

		}

		System.out.println(listaIphones + "\n");
		escritor(path, listaIphones);

	}

	public static void escritor(String path, List<String> list) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));

		buffWrite.append(list + "\n");
		buffWrite.close();
	}

	
}
