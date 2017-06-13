package com.sfeir.sfeirito.commands;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.ExecutionScriptTest;
import com.sfeir.sfeirito.Sfeirito;
import com.sfeir.sfeirito.utils.ExecutionScript;

public class NetworkTest extends ExecutionScriptTest{

	@Before
	public void initTest(){ 
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = Sfeirito.disableWifi();
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		Thread.sleep(1000);
		
		proc = Sfeirito.enableWifi();
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		Thread.sleep(1000);
		
		proc = Sfeirito.disableMobileData();
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.enableMobileData();
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
}
