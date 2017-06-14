package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;

import com.sfeir.sfeirito.enums.CommandPathEnum;
import com.sfeir.sfeirito.enums.PermissionEnum;
import com.sfeir.sfeirito.enums.RotationEnum;
import com.sfeir.sfeirito.utils.ExecutionScript;

/**
 * 
 * Class allowing to execute behaviors to a connected phone
 * 
 * @author patrickvongpraseuth
 *
 */
public class Sfeirito {

	/**
	 * 
	 * Enable airplane mode
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process enableAirplane() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.AIPLANE, "0");
	}

	/**
	 * 
	 * Disable airplane mode
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process disableAirplane() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.AIPLANE, "1");
	}
	
	/**
	 * 
	 * Get phone's alarms
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process getAlarms() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.ALARMS);
	}

	/**
	 * 
	 * Make a webservice call with an url
	 * 
	 * @param api
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process executeApi(String api) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.CALL_API, api);
	}

	/**
	 * 
	 * Upload a file from computer to phone
	 * 
	 * @param fileSource
	 * @param fileDest
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process uploadFile(String fileSource, String fileDest) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.FILE_UPLOAD, fileSource, fileDest);
	}

	/**
	 * 
	 * Delete file from phone with a path
	 * 
	 * @param fileDest
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process deleteFile(String fileDest) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.FILE_DELETE, fileDest);
	}
	
	/**
	 * 
	 * Install an application with an apk file
	 * 
	 * @param apkPath
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process installApk(String apkPath) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.APK_INSTALL, apkPath);
	}

	/**
	 * 
	 * Uninstall an application thanks to its package name
	 * 
	 * @param packageName
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process uninstallApk(String packageName) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.APK_UNINSTALL, packageName);
	}

	/**
	 * 
	 * Lock phone and turn off screen
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process lock() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.LOCK);
	}

	/**
	 * 
	 * Unlock phone with a swipe
	 * Assume that the phone is not locked with a password or screen pattern
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process unlock() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.UNLOCK);
	}

	/**
	 * 
	 * Enable Internet connexion from wifi parameters
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process enableWifi() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.WIFI, "enable");
	}

	/**
	 * 
	 * Disable Internet connexion from wifi parameters
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process disableWifi() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.WIFI, "disable");
	}

	/**
	 * 
	 * Enable Internet connexion from mobile data
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process enableMobileData() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.MOBILE_DATA, "enable");
	}

	/**
	 * 
	 * Disable Internet connexion from mobile data
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process disableMobileData() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.MOBILE_DATA, "disable");
	}
	
	/**
	 * 
	 * Add permission to an application
	 * 
	 * @param appPackage
	 * @param permission
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process enablePermission(String appPackage, PermissionEnum permission) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.PERMISSION, "grant", appPackage, permission.toString());
	}

	/**
	 * 
	 * Remove permission to an application
	 * 
	 * @param appPackage
	 * @param permission
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process disablePermission(String appPackage, PermissionEnum permission) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.PERMISSION, "revoke", appPackage, permission.toString());
	}

	/**
	 * 
	 * Reboot phone
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process reboot() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.REBOOT);
	}

	/**
	 * 
	 * Rotate screen relative to {@link RotationEnum}
	 * 
	 * WARNING : Lanscapes rotation only in apps (not in home)
	 * 
	 * @param rotation
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static Process rotate(RotationEnum rotation) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.ROTATE, rotation.toString());
	}

}
