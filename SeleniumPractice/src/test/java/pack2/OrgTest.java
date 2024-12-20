package pack2;

import org.testng.annotations.Test;

public class OrgTest {
	@Test
	public void createOrgTest() {
		System.out.println("execute createOrgTest");
		String url = System.getProperty("URL");
		String browser = System.getProperty("BROWSER");
		String username = System.getProperty("USERNAME");
		String password = System.getProperty("PASSWORD");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
	}
	@Test
	public void modifyOrgTest() {
		System.out.println("execute modifyOrgTest");
	}
	@Test
	public void DeleteOrgTest() {
		System.out.println("executee modifyOrgTest");
	}


}
