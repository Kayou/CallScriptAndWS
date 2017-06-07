package com.sfeir.sfeirito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ExecutionScriptTest {

	
	@Test
	public void testRunOk() throws Exception {
		// Given
		// Then
		Process proc = execScript("testExecScript.sh");
		// When
		List<String> readConsole = readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}
	
	protected Process execScript(String fileName) throws IOException, URISyntaxException{
		String pathScriptFile = Paths.get(ClassLoader.getSystemResource(fileName).toURI()).toString();
		
		Runtime runtime = Runtime.getRuntime();
		// Authorization d'execution
		runtime.exec("chmod +x "+pathScriptFile);
		// Execution du script
		return runtime.exec(pathScriptFile);
	}
	
	protected List<String> readConsole(Process proc) {
		List<String> consoleLine = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = "";
			try {
				while((line = reader.readLine()) != null) {
					System.out.println(line);
					consoleLine.add(line);
				}
			} finally {
				reader.close();
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return consoleLine;
	}
}
