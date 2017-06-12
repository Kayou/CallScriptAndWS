package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

public class AirplaneTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
		commandFile = "commands/airplane.sh";
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = disableAirplane();
		List<String> readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		
		proc = enableAirplane();
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
	
	
	public Process enableAirplane() throws IOException, URISyntaxException{
		return execScript(commandFile, "0");
	}

	public Process disableAirplane() throws IOException, URISyntaxException{
		return execScript(commandFile, "1");
	}
}
