package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.enums.CommandPathEnum;

public class CallApiTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = execute("http://10.2.32.126:8080/runTests");
		List<String> readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		
	}
	
	
	public Process execute(String api) throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.CALL_API, api);
	}

}
