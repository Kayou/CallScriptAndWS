package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;

import com.sfeir.sfeirito.enums.CommandPathEnum;

public class RebootTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = reboot();
		
		//assert a implementer
	}
	
	
	public Process reboot() throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.REBOOT);
	}
}
