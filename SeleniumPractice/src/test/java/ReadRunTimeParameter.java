import org.testng.annotations.Test;

public class ReadRunTimeParameter {
@Test
public void runtimeparameterTest()
{
	System.out.println("test ng test");
	String url = System.getProperty("url");
	System.out.println("Env Data==>URL==>" + url);
	 }
}
