package com.sfeir.sfeirito.enums;

public enum RotationEnum {
	LEFT(3), RIGHT(1), UP(0), DOWN(2);
	
	//values relative to adb command
	private int mode;
	
	RotationEnum(int mode){
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