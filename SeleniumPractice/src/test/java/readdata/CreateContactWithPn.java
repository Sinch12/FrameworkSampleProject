package readdata;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithPn {
	@Test(dataProvider = "getData")
	public void createContact(String firstname,String lastname,int cnum) {
		System.out.println("firstname:"+ firstname + "lastname:"+ lastname +"contactnum:"+ cnum);
	}
	@DataProvider
	public Object[][]  getData() {
		Object[][] objArr = new Object[3][3];
		objArr[0][0]= "deepak";
		objArr[0][1]= "HR";
		objArr[0][2]= 9483;
		
		objArr[1][0]= "sam";
		objArr[1][1]= "HD";
		objArr[1][2]= 0321;
		
		objArr[2][0]= "jhon";
		objArr[2][1]= "smith";
		objArr[2][2]= 6542;
		return objArr;
	}

}
