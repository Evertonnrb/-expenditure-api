package com.expenditure.domain.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetail {
    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String developerMessage;
}
