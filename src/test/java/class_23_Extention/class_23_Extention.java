package class_23_Extention;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class class_23_Extention {

	public static void main(String[] args) {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

		// playwright declaration and creation
		Playwright playwright;
		playwright = Playwright.create();

		LaunchOptions launchOptions;
		launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath));

		Browser browser;
		browser = playwright.chromium().launch(launchOptions);

		Page page;
		page = browser.newPage();

		page.navigate("C:\\Class20htmlCssJc\\mypage\\allhtml-all.html");
		
		page.locator("#input__text").fill("'Hello World'");
		
		page.locator("#input__password").fill("123456");
		
		page.locator("#input__webaddress").fill("http://mysite.com");
		
		page.locator("#input__emailaddress").fill("sghosh22@gmail.com");
		
		page.locator("#input__phone").fill("(347) 222-333");
		
		page.locator("#input__search").fill("Batch23");
		
		page.locator("#input__text2").fill("7");
		
		page.locator("#input__file").setInputFiles(Paths.get("C:/JAVA/Workspace/class_23_Table/src/test/resources/Flag.jpg"));
		
		page.selectOption("#select_city", "Dhaka");
		
		page.selectOption("#select_animal", "Cat");
		
			// how can I select multiple options
		String selectDouble = "#select_multiple";//selectSelector
		String[] option = { "Option One", "Option Two","Option Three", };//values
		page.selectOption(selectDouble, option);
		
		//How can I check multiple check Box
		Locator checkboxes = page.locator("[type='checkbox']");
		for (int i = 1; i < checkboxes.count(); i++) {
			checkboxes.nth(i).click();
		}
		
		page.locator("#forms__radio > ul > li:nth-child(2) > label").click();
		
		page.locator("#textarea").fill("Hey there, This me your third party vendor");//how to fill text box
		
		//table
		System.out.println(page.locator("//tr[3]/td[2]").innerText());
		
		System.out.println("First child Row: " + page.locator(".dataTable>tbody>tr:first-child").count());
		// page.locator(".dataTable>tbody").locator("tr:first-child").count());
		System.out.println("First child Row: " + page.locator(".dataTable>tbody>tr:first-child").count());
		// First child Column count
		// System.out.println("First child column: "
		// Web table handling id=#,class=.
		// Total Row Count
		int row = page.locator(".dataTable>tbody").locator("tr").count();
		System.out.println("Total Row: " + row);
		// System.out.println("Total Row: " +
		// page.locator(".dataTable>tbody").locator("tr").count());
		// System.out.println("Total Row: " +
		// page.locator(".dataTable>tbody>tr").count());

		// Total Column Count
		int column = page.locator(".dataTable>tbody>tr>td").count();
		System.out.println("Total Column: " + column);
		System.out.println("Total Column count: " + page.locator(".dataTable>tbody>tr>td").count());

		// First child Row count
		// System.out.println("First child Row: " +
		// +
		// page.locator(".dataTable>tbody").locator("tr:first-child").locator("td").count());
		System.out.println("Third child column: " + page.locator(".dataTable>tbody>tr:nth-child(3)>td").count());
		// Second child Column count
		System.out.println("Second child column: "
		+ page.locator(".dataTable>tbody").locator("tr:nth-child(2)").locator("td").count());

		// Verify Column Text
		// assertThat(page.locator(".dataTable>tbody").locator("tr:first-child").locator("td:nth-child(2)"))
		// .hasText("Table cell 2");
		//assertThat(page.locator(".dataTable>tbody").locator("tr:first-child").locator("td:nth-child(2)"))
		//.hasText("Table Cell 2");

		// Total table text print //java lamda expression
		// page.locator(".dataTable>tbody").allInnerTexts().forEach(text ->
		// System.out.println(text));
		page.locator(".dataTable>tbody").allInnerTexts().forEach(text -> System.out.println(text));

		System.out.println("((((((((_(((((((((()))");

		
		
		
		

	}

}
