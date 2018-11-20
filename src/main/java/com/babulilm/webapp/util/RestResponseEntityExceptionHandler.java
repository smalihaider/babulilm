package com.babulilm.webapp.util;

import java.nio.file.AccessDeniedException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.babulilm.webapp.dto.MessageDto;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { AccessDeniedException.class })
	protected ResponseEntity<Object> handleAccessDeniedException(RuntimeException ex, WebRequest request) {
		return ResponseEntityGenerator.generateResponseEntity(new MessageDto(MessageEnum.BAB001), null,
				MessageEnum.BAB001.getHttpStatus());
	}

	@ExceptionHandler(value = { RuntimeException.class })
	protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
		return ResponseEntityGenerator.generateResponseEntity(new MessageDto(MessageEnum.BAB003), null,
				MessageEnum.BAB003.getHttpStatus());
	}

	@ExceptionHandler(value = { BabulilmException.class })
	protected ResponseEntity<Object> handleBabulilmException(BabulilmException ex, WebRequest request) {
		return ResponseEntityGenerator.generateResponseEntity(new MessageDto(ex.getMessageEnum()), null,
				ex.getMessageEnum().getHttpStatus());
	}
}