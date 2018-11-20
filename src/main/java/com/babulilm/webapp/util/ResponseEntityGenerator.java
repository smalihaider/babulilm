package com.babulilm.webapp.util;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityGenerator {
	public static ResponseEntity<Object> generateResponseEntity(Object payload, Map<String, String> headers,
			HttpStatus httpStatusCode) {

		HttpHeaders httpHeaders = new HttpHeaders();

		if (headers != null) {
			headers.forEach((headerName, headerValue) -> {
				httpHeaders.add(headerName, headerValue);
			});
		}

		return new ResponseEntity<>(payload, httpHeaders, httpStatusCode);
	}
}
