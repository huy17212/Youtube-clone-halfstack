package asm2.com.poly.hellTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Huy1721\\\\Desktop\\\\github\\\\asm2\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://localhost:8086/asm2/index";
		driver.get(url);
		String title_actual = driver.getTitle();

		String title_expected = "Document";

		if (title_actual.equals(title_expected)) {
			System.out.print("Khai nhãn thành công");
		} else {
			System.out.print("Khai nhãn thất bại");
		}
		assertEquals(title_expected, title_actual);
  }
}
