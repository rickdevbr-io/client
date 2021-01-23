package br.com.company.client.erros;

import org.springframework.http.HttpHeaders;
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
    
}
