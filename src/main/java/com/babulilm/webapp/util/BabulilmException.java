package com.babulilm.webapp.util;

public class BabulilmException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private MessageEnum messageEnum;
	
	public BabulilmException(MessageEnum messageEnum) {
		this.messageEnum = messageEnum;
	}

	public MessageEnum getMessageEnum() {
		return messageEnum;
	}

	public void setMessageEnum(MessageEnum messageEnum) {
		this.messageEnum = messageEnum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
