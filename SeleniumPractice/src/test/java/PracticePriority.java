import org.testng.annotations.Test;

public class PracticePriority {
	@Test(priority = 1)
public void createcontact() {
	System.out.println("createcontact");
}
	@Test(priority = 2)
public void modifycontact() {
	System.out.println("modifycontact");
}
	@Test(priority = 3)
public void deletecontact() {
	System.out.println("deletecontact");
}
}
