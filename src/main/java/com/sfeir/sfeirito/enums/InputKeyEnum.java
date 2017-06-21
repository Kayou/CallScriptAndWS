package com.sfeir.sfeirito.enums;

/**
 * 
 * Enumeration containing keys to be simulated in phone
 * with an adb command
 * 
 * @author patrickvongpraseuth
 *
 */
public enum InputKeyEnum {
	HOME("KEYCODE_HOME"), 
	BACK("KEYCODE_BACK"), 
	RECENT_APPS("KEYCODE_APP_SWITCH"), 
	OK("KEYCODE_ENTER");
	
	//values relative to adb command
	private String mode;
	
	InputKeyEnum(String mode){
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}
	
	@Override
	public String toString() {
		return mode;
	}
}