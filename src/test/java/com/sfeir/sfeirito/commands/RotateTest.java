package com.sfeir.sfeirito.commands;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.ExecutionScriptTest;
import com.sfeir.sfeirito.Sfeirito;
import com.sfeir.sfeirito.enums.RotationEnum;
import com.sfeir.sfeirito.utils.ExecutionScript;

public class RotateTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = Sfeirito.rotate(RotationEnum.DOWN);
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.rotate(RotationEnum.LEFT);
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.rotate(RotationEnum.RIGHT);
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		
		proc = Sfeirito.rotate(RotationEnum.UP);
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
	
}
