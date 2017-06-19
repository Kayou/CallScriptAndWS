package com.sfeir.sfeirito.commands;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sfeir.sfeirito.ExecutionScriptTest;
import com.sfeir.sfeirito.Sfeirito;
import com.sfeir.sfeirito.enums.APIEnum;
import com.sfeir.sfeirito.utils.ExecutionScript;

public class MockTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	@Override
	public void testRunOk() throws Exception {
	}
	
	@Test
	public void mockMethod() throws IOException, URISyntaxException, InterruptedException{

		String teste = "[{"+
				"\"classname\" : \"com.example.Operation\","+
				"\"method\" : \"addition\","+
			    "\"in\" : [],"+
			    "\"out\" : [{"+
			    "	\"classname\" : \"java.lang.Integer\","+
			    "	\"value\" : \"6\" "+
			    "}]"+
			"},"
			+ "{"+
				"\"classname\" : \"com.example.Operation\","+
				"\"method\" : \"substraction\","+
			    "\"in\" : [],"+
			    "\"out\" : [{"+
			    "	\"classname\" : \"java.lang.Integer\","+
			    "	\"value\" : \"1\" "+
			    "}]"+
			"}]";
		
		Process proc = Sfeirito.mock(APIEnum.MOCK_METHOD, teste);
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		
		Thread.sleep(1000);

		proc = Sfeirito.test("com.sfeir.testant.tests.TestOperationClass");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
	
	@Test
	public void mockAPIMethod() throws IOException, URISyntaxException{

		String test = "{"+
				"\"classname\" : \"com.example.ws.WebserviceAPI\","+
				"\"method\" : \"getCountries\","+
			    "\"in\" : ["+
			    "			{\"classname\" : \"java.lang.String\", \"value\" : \"FRANCE\"}"+
			    "],"+
			    "\"out\" : [{"+
			    "	\"classname\" : \"com.example.ws.Response\","+
			    "	\"value\" : \"{"+
				"	      \\\"name\\\" : \\\"United States of America\\\","+
				"	      \\\"alpha2_code\\\" : \\\"US\\\","+
				"	      \\\"alpha3_code\\\" : \\\"USA\\\""+
				"	}\""+
			    "}]"+
			"}";

		Process proc = Sfeirito.mock(APIEnum.MOCK_METHOD, test);
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.test("com.sfeir.testant.tests.TestWebserviceAPIClass");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		

		proc = Sfeirito.removeMock("com.example.ws.WebserviceAPI");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

//		proc = Sfeirito.test("com.sfeir.testant.tests.TestWebserviceAPIClass");
//		readConsole = ExecutionScript.readConsole(proc);
//		Assert.assertNotNull(readConsole);
//		Assert.assertFalse(readConsole.isEmpty());
	}
	
	@Test
	public void mockCallback() throws IOException, URISyntaxException{

		String teste = "{"+
				"\"classname\" : \"com.example.callback.APIService\","+
				"\"method\" : \"country\","+
			    "\"in\" : ["+
			    "			{\"classname\" : \"java.lang.String\", \"value\" : \"FRANCE\"}"+
			    "],"+
			    "\"out\" : [{"+
			    "	\"classname\" : \"com.example.callback.CountryResponse\","+
			    "	\"value\" : \"{"+
				"	      \\\"RestResponse\\\" : {"+
				"	      						\\\"messages\\\" : [],"+
				"	      						\\\"result\\\" : [{"+
				"	      								\\\"name\\\" : \\\"India\\\","+
				"	      								\\\"alpha2_code\\\" : \\\"IN\\\","+
				"	      								\\\"alpha3_code\\\" : \\\"IND\\\""+
				"		  				   		}]"
				+ "		  }"
				+ " }\""+
			    "}]"+
			"}";
		
		Process proc = Sfeirito.mock(APIEnum.MOCK_CALLBACK, teste);
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.test("com.sfeir.testant.tests.TestAPIServiceClass");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
	
}
