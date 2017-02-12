package com.candela.bookingpad.exception;

public class APIException extends Exception{

    private ErrorCodeEnum codeEnum;
    private Object[] params;

    public APIException(ErrorCodeEnum codeEnum) {
        this.codeEnum = codeEnum;
    }

    public APIException(ErrorCodeEnum codeEnum, Object[] params) {
        this.codeEnum = codeEnum;
        this.params = params;
    }

    public ErrorCodeEnum getCodeEnum() {
        return codeEnum;
    }

    public Object[] getParams() {
        return params;
    }
}
