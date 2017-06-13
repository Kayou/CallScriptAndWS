package com.sfeir.sfeirito.commands;

import org.junit.Before;

import com.sfeir.sfeirito.ExecutionScriptTest;
import com.sfeir.sfeirito.Sfeirito;

public class RebootTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = Sfeirito.reboot();
		
		//assert a implementer
	}
}
