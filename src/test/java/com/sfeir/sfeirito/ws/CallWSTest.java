package com.sfeir.sfeirito.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sfeir.sfeirito.enums.APIEnum;

public class CallWSTest {

	@Test
	public void callOkTest() throws Exception {
		// Given
		// When
		//List<String> callApi = callApi("https://code.google.com/apis/console");
		List<String> callApi = callApi(APIEnum.TEST.toString());
		// Then
		Assert.assertNotNull(callApi);
		Assert.assertFalse(callApi.isEmpty());
	}

	protected List<String> callApi(String api) throws IOException {
		List<String> result = new ArrayList<String>();

		URL url = new URL(api);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			result.add(output);
		}

		conn.disconnect();

		return result;

	}
}
