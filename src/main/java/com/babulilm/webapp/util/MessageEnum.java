package com.babulilm.webapp.util;

import org.springframework.http.HttpStatus;

public enum MessageEnum {
	BAB001("BAB001", "You are not authorized to access the resource", HttpStatus.UNAUTHORIZED),
	BAB002("BAB002", "Resource not found", HttpStatus.NOT_FOUND),
	BAB003("BAB003", "Something went wrong while processing your request", HttpStatus.INTERNAL_SERVER_ERROR);

	private final String messageCode;
	private final String messageDesc;
	private final HttpStatus httpStatusCode;

	private MessageEnum(String messageCode, String messageDesc, HttpStatus httpStatusCode) {
		this.messageCode = messageCode;
		this.messageDesc = messageDesc;
		this.httpStatusCode = httpStatusCode;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public String getMessageDesc() {
		return messageDesc;
	}

	public HttpStatus getHttpStatus() {
		return httpStatusCode;
	}
}
