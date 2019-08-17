package myfirstteste.firstteste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\drive\\chromedriver.exe");

		String path = "C:\\Users\\Samsung\\Desktop\\text.csv";

		WebDriver navegador = new ChromeDriver();

		navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		navegador.get("https://www.amazon.com.br");

		navegador.findElement(By.name("field-keywords")).sendKeys("Iphone");
		navegador.findElement(By.className("nav-input")).click();

		List<String> listaDescricao = new ArrayList<String>();
		

		for (Integer i = 1; i <= 15; i++) {

			if (i != 10 && i != 12) {
				
			String XpathDescricao = " //*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[" + i
					+ "]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span";

			String XpathPreco = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[" + i
					+ "]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/a/span[1]/span[2]/span[2]\r\n"
					+ "";

			String IphoneDescricao = navegador.findElement(By.xpath(XpathDescricao)).getText();
			String IphonePreco = navegador.findElement(By.xpath(XpathPreco)).getText();

			listaDescricao.addAll(Arrays.asList("Descricao: " + IphoneDescricao, "Preco: " + IphonePreco + "\n"));
			
			} else 
				continue;

		}

		System.out.println(listaDescricao);
        
		escreverArquivo(path, listaDescricao);
	}

	
	public static void escreverArquivo(String path, List<String> list1) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));

		buffWrite.append(list1 + ",");

		buffWrite.close();
	}
	
	

	
}
