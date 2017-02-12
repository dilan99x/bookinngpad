package com.candela.bookingpad.mapper;

import com.candela.bookingpad.exception.APIException;
import com.candela.bookingpad.exception.ErrorCodeEnum;

import java.util.List;

public abstract class BaseMapper<Source extends Object, Target extends Object> {

    public abstract Target mapToDto(Source source, Target target) throws APIException;

    public abstract List<Target> mapToDto(List<Source> tSources, List<Target> targets) throws APIException;

    public void validate(Source source, Target target) throws APIException {
        if (source == null || target == null) {
            throw new APIException(ErrorCodeEnum.INVALID_SOURCE_AND_TARGET);
        }
    }

    public void validateList(List<Source> source, List<Target> target) throws APIException {
        if (source == null || target == null) {
            throw new APIException(ErrorCodeEnum.INVALID_SOURCE_AND_TARGET_LIST);
        }
    }
}
