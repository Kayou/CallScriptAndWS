package com.sfeir.sfeirito.commands;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sfeir.sfeirito.ExecutionScriptTest;
import com.sfeir.sfeirito.Sfeirito;
import com.sfeir.sfeirito.enums.APIEnum;
import com.sfeir.sfeirito.utils.ExecutionScript;
import com.sfeir.sfeirito.ws.PostJson;

public class MockTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	@Override
	public void testRunOk() throws Exception {
	}
	
	@Test
	public void mockMethod() throws IOException, URISyntaxException, InterruptedException{

		List<PostJson> postArray = new ArrayList<PostJson>();
		
		PostJson postJson = new PostJson("com.example.Operation","addition");
		postJson.addResult("java.lang.Integer", "6");
		postArray.add(postJson);

		postJson = new PostJson("com.example.Operation","substraction");
		postJson.addResult("java.lang.Integer", "1");
		postArray.add(postJson);
		
		Process proc = Sfeirito.mock(APIEnum.MOCK_METHOD, postJson);
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

		String complexResultObject =  "{"
									+ "\"name\": \"United States of America\", "
									+ "\"alpha2_code\":\"US\","
									+ "\"alpha3_code\":\"USA\""
							   + "}";
				
		PostJson postJson = new PostJson("com.example.ws.WebserviceAPI","getCountries");
		postJson.addArgument("java.lang.String", "FRANCE");
		postJson.addResult("com.example.ws.Response", complexResultObject);

		Process proc = Sfeirito.mock(APIEnum.MOCK_METHOD, postJson);
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

		String complexResultObject = "{\"RestResponse\" : { "
									+ "\"messages\":[], "
									+ "\"result\" : [{"
										+ "\"name\": \"India\","
										+ "\"alpha2_code\":\"IN\","
										+ "\"alpha3_code\":\"IND\""
									+ "}]"
								+ "}}";
				
		PostJson postJson = new PostJson("com.example.callback.APIService","country");
		postJson.addArgument("java.lang.String", "FRANCE");
		postJson.addResult("com.example.callback.CountryResponse", complexResultObject);
		
		Process proc = Sfeirito.mock(APIEnum.MOCK_CALLBACK, postJson);
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.test("com.sfeir.testant.tests.TestAPIServiceClass");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
	
}
