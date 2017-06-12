package com.sfeir.sfeirito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public abstract class ExecutionScriptTest {
	
	protected String commandFile; 
	
	@Test
	public abstract void testRunOk() throws Exception;
	
	protected Process execScript(String fileName, String... args) throws IOException, URISyntaxException{
 
		String pathScriptFile = Paths.get(ClassLoader.getSystemResource(fileName).toURI()).toString();
		
		Runtime runtime = Runtime.getRuntime(); 
		
		// Authorization d'execution
		runtime.exec("chmod +x "+pathScriptFile);
		 
		String arguments = Arrays.toString(args); 
		if(arguments.length() > 0){
			arguments = arguments.substring(1,arguments.length() - 1);
		}
		if(args.length > 1){
			arguments = arguments.replace(","," ");
		}
		
		// Execution du script
		return runtime.exec(pathScriptFile + " "+ arguments);
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
