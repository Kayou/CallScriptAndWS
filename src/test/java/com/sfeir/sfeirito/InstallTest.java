package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.enums.CommandPathEnum;

public class InstallTest extends ExecutionScriptTest{

	@Before
	public void initTest(){
	}
	
	
	@Override
	public void testRunOk() throws Exception {
		Process proc = installApk("/Users/patrickvongpraseuth/git/CallScriptAndWS/src/test/resources/com.saschaha.one_v37_b39374.apk");
		List<String> readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
		
		proc = uninstallApk("com.saschaha.one");
		readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
	
	
	public Process installApk(String apkPath) throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.APK_INSTALL, apkPath);
	}

	public Process uninstallApk(String packageName) throws IOException, URISyntaxException{
		return execScript(CommandPathEnum.APK_UNINSTALL, packageName);
	}
}
