package com.sfeir.sfeirito;

import java.io.IOException;
import java.net.URISyntaxException;

import com.sfeir.sfeirito.enums.CommandPathEnum;
import com.sfeir.sfeirito.enums.PermissionEnum;
import com.sfeir.sfeirito.enums.RotationEnum;
import com.sfeir.sfeirito.utils.ExecutionScript;

public class Sfeirito {

	public static Process enableAirplane() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.AIPLANE, "0");
	}

	public static Process disableAirplane() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.AIPLANE, "1");
	}
	
	public static Process getAlarms() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.ALARMS);
	}

	public static Process executeApi(String api) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.CALL_API, api);
	}

	public static Process uploadFile(String fileSource, String fileDest) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.FILE_UPLOAD, fileSource, fileDest);
	}

	public static Process deleteFile(String fileDest) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.FILE_DELETE, fileDest);
	}
	
	public static Process installApk(String apkPath) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.APK_INSTALL, apkPath);
	}

	public static Process uninstallApk(String packageName) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.APK_UNINSTALL, packageName);
	}

	public static Process lock() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.LOCK);
	}

	public static Process unlock() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.UNLOCK);
	}

	public static Process enableWifi() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.WIFI, "enable");
	}

	public static Process disableWifi() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.WIFI, "disable");
	}

	public static Process enableMobileData() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.MOBILE_DATA, "enable");
	}

	public static Process disableMobileData() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.MOBILE_DATA, "disable");
	}
	
	public static Process enablePermission(String appPackage, PermissionEnum permission) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.PERMISSION, "grant", appPackage, permission.toString());
	}

	public static Process disablePermission(String appPackage, PermissionEnum permission) throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.PERMISSION, "revoke", appPackage, permission.toString());
	}

	public static Process reboot() throws IOException, URISyntaxException{
		return ExecutionScript.execScript(CommandPathEnum.REBOOT);
	}

	/**
	 * 
	 * Rotate screen
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
