package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.enums.CommandPathEnum;

public class NetworkTest extends ExecutionScriptTest{

	@Before
	public void initTest(){ 
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = disableWifi();
		List<String> readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		Thread.sleep(1000);
		
		proc = enableWifi();
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		Thread.sleep(1000);
		
		proc = disableMobileData();
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = enableMobileData();
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
	
	
	public Process enableWifi() throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.WIFI, "enable");
	}

	public Process disableWifi() throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.WIFI, "disable");
	}

	
	public Process enableMobileData() throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.MOBILE_DATA, "enable");
	}

	public Process disableMobileData() throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.MOBILE_DATA, "disable");
	}
}
