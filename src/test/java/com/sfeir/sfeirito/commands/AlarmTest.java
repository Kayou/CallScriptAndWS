package com.sfeir.sfeirito.commands;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.ExecutionScriptTest;
import com.sfeir.sfeirito.Sfeirito;
import com.sfeir.sfeirito.utils.ExecutionScript;

public class AlarmTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = Sfeirito.getAlarms();
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

	}
	
}
