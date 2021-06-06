import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class blue_ribbon {
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
	public static final String WEB_DRIVER_PATH = "C:/chromedriver/chromedriver.exe"; //드라이버 경로
	
	public static void main(String[] args)  throws IOException{
		PrintWriter pw = new PrintWriter("C:\\Users\\Lenovo\\blue_ribbon_data.txt");
	    StringBuilder sb = new StringBuilder();
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int tot = 0;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		String url = "https://www.bluer.co.kr/search?tabMode=single&searchMode=ribbonType&location=&ribbonType=&feature=#filter-restaurant";
		
		driver.get(url);
		int page = 1;
		int cnt = 2;
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		WebElement nm = null;
		WebElement nm2 = null;
		WebElement ft = null;
		WebElement ft2 = null;
		WebElement addr = null;

		WebElement pg = null;
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
			}
			System.out.println("currpage" + page);
			for (int i = 1; i < 31; i++) {
				sb = new StringBuilder();
				try {
					nm = driver.findElement(By.xpath("//*[@id=\"list-restaurant\"]/li["+  i + "]"));
					nm2 = nm.findElement(By.cssSelector("h3"));
					ft = driver.findElement(By.xpath("//*[@id=\"list-restaurant\"]/li["+  i + "]"));
					ft2 = ft.findElement(By.cssSelector("li"));
					addr = driver.findElement(By.xpath("//*[@id=\"list-restaurant\"]/li["+  i + "]/div/div/div[1]/dl/dd[2]"));
				}catch(Exception e) {
					continue;
				}
				sb.append("INSERT INTO restaurant(restaurant_name, restaurant_type, restaurant_address) VALUES (")
					.append("'")
					.append(nm2.getText())
					.append("',")
					.append("'")
					.append(ft2.getText())
					.append("',")
					.append("'")
					.append(addr.getText())
					.append("');");
				pw.println(sb);
				System.out.println(sb);
			}
			try {
				if(cnt == 8) {
					pg = driver.findElement(By.xpath("//*[@id=\"page-selection\"]/ul/li[9]/a"));
					cnt = 2;
				}
				else{
					cnt++;
					pg = driver.findElement(By.xpath("//*[@id=\"page-selection\"]/ul/li[" + cnt + "]/a"));
				}
				pg.click();
				page++;
			} catch(Exception e){
				System.out.println("데이터 수집 완료");
					driver.close(); 
					driver.quit();
				throw new RuntimeException(e.getMessage());
			}
			System.out.println(tot++);
		}
	}
}