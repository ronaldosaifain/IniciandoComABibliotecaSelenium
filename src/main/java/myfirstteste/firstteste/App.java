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

		List<String> listaDescricao = new ArrayList<String>();
		List<String> listaPreco = new ArrayList<String>();

		for (Integer i = 1; i < 17; i++) {
			for (Integer j = 1; j < 9; j++) {
				String XpathDescricao = " //*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[" + i
						+ "]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span";

				String XpathPreco = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[" + j
						+ "]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/a/span[1]/span[2]/span[2]\r\n"
						+ "";

				String IphoneDescricao = navegador.findElement(By.xpath(XpathDescricao)).getText();
				String IphonePreco = navegador.findElement(By.xpath(XpathPreco)).getText();

				listaDescricao.add(IphoneDescricao + "\n");
				listaPreco.add(IphonePreco + "\n");

			}
		}

		System.out.println(listaDescricao + "\n" + listaPreco);
		escritor(path, listaDescricao, listaPreco);

	}

	public static void escritor(String path, List<String> list1,List<String> list2) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));

		
		buffWrite.append(list1 + "/");
		buffWrite.append(list2 + "/");
		buffWrite.close();
	}

	// *[@id="search"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/a/span[1]/span[2]/span[2]
	// *[@id="search"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/a/span/span[2]/span[2]
}
