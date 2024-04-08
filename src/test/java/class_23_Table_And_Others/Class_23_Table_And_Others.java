package class_23_Table_And_Others;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class Class_23_Table_And_Others {

	public static void main(String[] args) {
		Playwright playwright;
		playwright =Playwright.create();//enteract with the browser
		Browser browser;
		browser = playwright.chromium()
				.launch(new BrowserType
				.LaunchOptions()
				.setHeadless(false)//Show GUI mode
				.setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
		Page page;
		page = browser.newPage();//until here if I run it it would show me a blank page
		
		page.navigate("https://money.rediff.com/indices/nse/NIFTY-50?src=moneyhome_nseIndices");
		//count row
		System.out.println("Table Row "+page.locator(".dataTable>tbody")
				.locator("tr")
				.count());
		//count column
		System.out.println("Table Colum "+page.locator(".dataTable>tbody")
				.locator("tr:first-child")
				.locator("td")
				.count());
		//row 3 column 2
		System.out.println("Cell Value is : "+page.locator("//tr[3]/td[2]").innerText());
		
		
		assertThat(page.locator(".dataTable>tbody")
						.locator("tr:first-child")
						.locator("td:nth-child(2)"))
						.hasText("Nifty");
		System.out.println(page.locator("//tr[4]/td[1]").innerText());
		//Verify that actual inner text match with expected text 
	
		assertThat(page.locator("//*[@id=\"leftcontainer\"]/div[2]/div[2]/table/tbody/tr[4]/td[1]/a")).hasText("Asian Paints Ltd.");
		
		
		System.out.println("Price is : "+page.locator("//tr[4]/td[3]").innerText());
		System.out.println("Price is : "+page.locator("//tr[4]/td[4]").innerText());
		page.close();
		
		//assertThat(page.locator("/html/body/div[2]/div[5]/div[2]/div[2]/table/tbody/tr[4]/td[3]")).hasValue("3,168.90");
		
		
		
	}
	
	
	
	
	
	
	


}
