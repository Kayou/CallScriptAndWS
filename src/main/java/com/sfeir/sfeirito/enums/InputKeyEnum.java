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
	HOME(3), BACK(4), OK(66);
	
	//values relative to adb command
	private int mode;
	
	InputKeyEnum(int mode){
		this.mode = mode;
	}

	public int getMode() {
		return mode;
	}
	
	@Override
	public String toString() {
		return String.valueOf(mode);
	}
}