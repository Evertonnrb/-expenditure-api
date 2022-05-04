package com.expenditure.domain.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundExceptionDetails {

    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String developerMessage;


}
