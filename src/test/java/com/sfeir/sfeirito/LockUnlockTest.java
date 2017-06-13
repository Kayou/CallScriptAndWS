package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.enums.CommandPathEnum;

public class LockUnlockTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = lock();
		List<String> readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		Thread.sleep(1000);
		
		proc = unlock();
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		
	}
	
	
	public Process lock() throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.LOCK);
	}

	public Process unlock() throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.UNLOCK);
	}
}
