package com.sfeir.sfeirito.enums;

public enum CommandPathEnum {

	AIPLANE("airplance.sh"),
	ALARMS("alarms.sh"),
	CALL_API("call_api.sh"),
	LOCK("lock.sh"),
	UNLOCK("unlock.sh"),
	REBOOT("reboot.sh"),
	ROTATE("rotate.sh"),
	WIFI("wifi.sh"), 
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
