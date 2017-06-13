package com.sfeir.sfeirito.commands;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.ExecutionScriptTest;
import com.sfeir.sfeirito.Sfeirito;
import com.sfeir.sfeirito.utils.ExecutionScript;

public class FileTest extends ExecutionScriptTest{

	@Before
	public void initTest(){ 
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = Sfeirito.uploadFile("/Users/patrickvongpraseuth/git/CallScriptAndWS/src/test/resources/MyTextFile.txt","/mnt/sdcard/Download/");
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		//TODO : find file for assert
		
		Thread.sleep(1000);
		
		proc = Sfeirito.deleteFile("/mnt/sdcard/Download/MyTextFile.txt");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
	}
	
}
