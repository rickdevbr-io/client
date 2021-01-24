package br.com.company.client.exceptions;

import java.util.Date;
import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdviceException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { BusinessException.class })
    protected ResponseEntity<Object> handleConflict(BusinessException businessException, WebRequest request) {
        return handleExceptionInternal(businessException, businessException.getMessage(), new HttpHeaders(), businessException.getStatus(), request);
    }
    
    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }    

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
    	
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return new ResponseEntity<>(
            new BusinessExceptionDto(
                new Date(),
                ex.getMessage(),
                Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR).value(),
                Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR).getReasonPhrase(),
                request.getDescription(false)
            ),
            headers,
            Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR)
        );
    }
}
