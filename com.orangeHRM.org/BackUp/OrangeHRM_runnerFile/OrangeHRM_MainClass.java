package OrangeHRM_runnerFile;
import java.io.IOException;
import org.testng.annotations.Test;

import Library.BrowserInvoke;
import tests.OrangeHRM.RegistrationTest;

public class OrangeHRM_MainClass{
	
	@Test
	public static void MyRunner() throws IOException {
		
		RegistrationTest.registrationpage();
		
	}
}
