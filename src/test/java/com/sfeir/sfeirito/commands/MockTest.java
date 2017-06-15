package com.sfeir.sfeirito.commands;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

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

		
//		http://10.2.32.124:8080/mockMethod?class=com.example.Operation&method=substraction&result=1
		Process proc = Sfeirito.mock("com.example.Operation","substraction","1");
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.mock("com.example.Operation","addition","6");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
 
		String test = "{"+
				"\"class\" : \"com.example.ws.WebserviceAPI\","+
				"\"method\" : \"getCountries\","+
			    "\"in\" : ["+
			    "			{\"class\" : \"java.lang.String\", \"value\" : \"FRANCE\"}"+
			    "],"+
			    "\"out\" : [{"+
			    "	\"class\" : \"com.example.ws.Response\","+
			    "	\"value\" : {"+
				"	      \"name\" : \"United States of America\","+
				"	      \"alpha2_code\" : \"US\","+
				"	      \"alpha3_code\" : \"USA\""+
				"	}"+
			    "}]"+
			"}";

		proc = Sfeirito.mock(test);
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.executeApi(APIEnum.TEST);
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		

		proc = Sfeirito.removeMock("com.example.ws.WebserviceAPI");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.executeApi(APIEnum.TEST);
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
	
}
