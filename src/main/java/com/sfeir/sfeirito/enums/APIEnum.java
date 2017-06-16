package com.sfeir.sfeirito.enums;

/**
 * 
 * Enumeration containing all api(s) available by the phone server
 * 
 * @author patrickvongpraseuth
 *
 */
public enum APIEnum {

	MOCK_POST("mockMethod"),
	MOCK_REMOVE("mockRemove"),
	TEST("runTests");

	private String serverUrl = "http://10.2.32.126:8080/";	
	
	private String apiName;
	
	APIEnum(String apiName) {
		this.apiName = apiName;
	}
	
	@Override
	public String toString() {
		return serverUrl + apiName;
	}

	public String getApiname() {
		return apiName;
	}
}
