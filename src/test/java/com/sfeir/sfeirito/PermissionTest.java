package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.enums.CommandPathEnum;
import com.sfeir.sfeirito.enums.PermissionEnum;

public class PermissionTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = disablePermission("com.saschaha.one", PermissionEnum.CAMERA);
		List<String> readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		
		proc = enablePermission("com.saschaha.one", PermissionEnum.CAMERA);
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
	
	
	public Process enablePermission(String appPackage, PermissionEnum permission) throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.PERMISSION, "grant", appPackage, permission.toString());
	}

	public Process disablePermission(String appPackage, PermissionEnum permission) throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.PERMISSION, "revoke", appPackage, permission.toString());
	}
}
