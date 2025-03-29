package testingpack;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


import com.comcast.crm.generic.fileutility.JSONUtility;
import com.comcst.crm.generic.baseClassUtility.BaseClass;
import com.comcst.crm.objectrepository.LoginPage;

public class Testing extends BaseClass{
	@Test 
	public void test() throws IOException, ParseException {
	System.out.println("inside Test ()");
	}

}
