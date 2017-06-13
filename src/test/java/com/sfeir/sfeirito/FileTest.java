package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.enums.CommandPathEnum;

public class FileTest extends ExecutionScriptTest{

	@Before
	public void initTest(){ 
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = uploadFile("/Users/patrickvongpraseuth/git/CallScriptAndWS/src/test/resources/MyTextFile.txt","/mnt/sdcard/Download/");
		List<String> readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		//TODO : find file for assert
		
		Thread.sleep(1000);
		
		proc = deleteFile("/mnt/sdcard/Download/MyTextFile.txt");
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);

	}
	
	
	public Process uploadFile(String fileSource, String fileDest) throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.FILE_UPLOAD, fileSource, fileDest);
	}

	public Process deleteFile(String fileDest) throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.FILE_DELETE, fileDest);
	}
}
