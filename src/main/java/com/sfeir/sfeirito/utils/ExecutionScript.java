package com.sfeir.sfeirito.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sfeir.sfeirito.enums.CommandPathEnum;

/**
 * 
 * Class util as unix terminal
 * 
 * @author patrickvongpraseuth
 *
 */
public class ExecutionScript {
	
	/**
	 * 
	 * Execute shell scripts with arguments
	 * 
	 * @param commandFile
	 * @param args
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process execScript(CommandPathEnum commandFile, String... args) throws IOException, URISyntaxException{

		String pathScriptFile = Paths.get(ClassLoader.getSystemResource(commandFile.toString()).toURI()).toString();
		
		Runtime runtime = Runtime.getRuntime(); 
		
		// Allow script to be executed
		runtime.exec("chmod +x "+pathScriptFile);
		 
		String arguments = Arrays.toString(args); 
		if(arguments.length() > 0){
			arguments = arguments.substring(1,arguments.length() - 1);
		}
		if(args.length > 1){
			String tmp = "";
			for(String arg : args){
				tmp += arg.trim()+" ";
			}
			arguments = tmp;
		}
		
		// script's execution
		return runtime.exec(pathScriptFile + " "+ arguments);
	}
	
	/**
	 * 
	 * Read process content ( result of a command's execution)
	 * 
	 * @param proc
	 * @return
	 */
	public static List<String> readConsole(Process proc) {
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
