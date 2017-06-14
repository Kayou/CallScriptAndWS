package com.sfeir.sfeirito.enums;

/**
 * 
 * Permissions able to change
 * 
 * @author patrickvongpraseuth
 *
 */
public enum PermissionEnum {
	RECORD_AUDIO("android.permission.RECORD_AUDIO"),
	ACCESS_FINE_LOCATION("android.permission.ACCESS_FINE_LOCATION"),
	SEND_SMS("android.permission.SEND_SMS"),
	RECEIVE_SMS("android.permission.RECEIVE_SMS"),
	CAMERA("android.permission.CAMERA");
	
	private String permission;
	
	PermissionEnum(String permission){
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
	@Override
	public String toString() {
		return String.valueOf(permission);
	}
}