package br.com.company.client.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class BusinessExceptionDto {

    private Date timestamp;
    private String message;
    private int status;
    private String error;
    private String path;

}
