package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.enums.CommandPathEnum;
import com.sfeir.sfeirito.enums.RotationEnum;

public class RotateTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = rotate(RotationEnum.DOWN);
		List<String> readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = rotate(RotationEnum.LEFT);
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = rotate(RotationEnum.RIGHT);
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		
		proc = rotate(RotationEnum.UP);
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

	}
	
	/**
	 * 
	 * Rotate screen
	 * 
	 * WARNING : Lanscapes rotation only in apps (not in home)
	 * 
	 * @param rotation
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public Process rotate(RotationEnum rotation) throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.ROTATE, rotation.toString());
	}

}
