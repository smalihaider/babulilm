package com.babulilm.webapp.dto;

import com.babulilm.webapp.util.MessageEnum;

public class MessageDto {
	private String messageCode;
	private String messageDesc;

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageDesc() {
		return messageDesc;
	}

	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}

	public MessageDto(MessageEnum messageEnum) {
		this.messageCode = messageEnum.getMessageCode();
		this.messageDesc = messageEnum.getMessageDesc();
	}
}
