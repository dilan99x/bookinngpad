package com.candela.bookingpad.exception;

public enum ErrorCodeEnum {

    API_NOT_FOUND_CODE("10000", "resource not found"),
    INVALID_SOURCE_AND_TARGET("100001", "Either source or target object is invalid....! "),
    INVALID_SOURCE_AND_TARGET_LIST("100002", "Either source list or target object list are invalid....! "),
    ORGANIZATION_NOT_FOUND("11000", "Organization not found"),
    ORGANIZATION_TYPE_NOT_FOUND("11001", "Organization type not found"),
    ORGANIZATION_TYPE_BY_NAME_FOUND("12000", "Organization type found for the specified name"),
    ORGANIZATION_FOUND_BY_NAME("11002", "Organization found by the specified name"),

    //Location based
    LOCATION_ALREADY_AVAILABLE("12000", "Location already available with given properties"),
    LOCATION_ID_NOT_AVAILABLE("12001", "Location with the specified id is not found");

    private String code;
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
