package com.adso.siat_v1.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<Object> generateResponseSuccess(String message, HttpStatus status,
			Object responseObj) {
		Map<String, Object> map = resultGenerateResponseSuccess(message, status, responseObj);
		return new ResponseEntity<>(map, status);
	}

	private static Map<String, Object> resultGenerateResponseSuccess(String message, HttpStatus status,
			Object responseObj) {

		Map<String, Object> map = new LinkedHashMap<>();
		map.put("code", status.value());
		map.put("success", true);
		map.put("message", message);
		map.put("data", responseObj);
		return map;
	}

	public static ResponseEntity<Object> generateResponseError(String message, HttpStatus status) {
		Map<String, Object> map = resultGenerateResponseError(message, status);
		return new ResponseEntity<>(map, status);
	}

	public static Map<String, Object> resultGenerateResponseError(String message, HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", status != null && status.value() != 200 ? status.value() : 400);
		map.put("success", false);
		map.put("message", message);
		return map;
	}

}
