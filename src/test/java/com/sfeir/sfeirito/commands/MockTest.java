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


		String teste = "{"+
				"\"classname\" : \"com.example.Operation\","+
				"\"method\" : \"addition\","+
			    "\"in\" : [],"+
			    "\"out\" : [{"+
			    "	\"classname\" : \"java.lang.Integer\","+
			    "	\"value\" : \"6\" "+
			    "}]"+
			"}";
		
		Process proc = Sfeirito.mock(teste);
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		
		teste = "{"+
				"\"classname\" : \"com.example.Operation\","+
				"\"method\" : \"substraction\","+
			    "\"in\" : [],"+
			    "\"out\" : [{"+
			    "	\"classname\" : \"java.lang.Integer\","+
			    "	\"value\" : \"1\" "+
			    "}]"+
			"}";
		
		proc = Sfeirito.mock(teste);
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
 
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
