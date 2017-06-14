package com.sfeir.sfeirito.enums;

public enum CommandPathEnum {

	AIPLANE("airplane.sh"),
	ALARMS("alarms.sh"),
	CALL_API("call_api.sh"),
	LOCK("lock.sh"),
	UNLOCK("unlock.sh"),
	REBOOT("reboot.sh"),
	ROTATE("rotate.sh"),
	WIFI("wifi.sh"), 
	PERMISSION("permission.sh"), 
	APK_INSTALL("install.sh"),
	APK_UNINSTALL("uninstall.sh"),  
	FILE_UPLOAD("upload_file.sh"), 
	FILE_DELETE("delete_file.sh"), 
	MOBILE_DATA("mobile_data.sh");

	private String directory = "commands/";	
	private String filename;
	
	CommandPathEnum(String filename) {
		this.filename = filename;
	}
	
	@Override
	public String toString() {
		return directory + filename;
	}

	public String getFilename() {
		return filename;
	}
}
