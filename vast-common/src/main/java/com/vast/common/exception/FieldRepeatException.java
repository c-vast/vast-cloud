package com.vast.common.exception;

import com.vast.common.enums.ResultCode;

public class FieldRepeatException extends BusinessException{
    public FieldRepeatException(ResultCode resultCode) {
        super(resultCode);
    }

    public FieldRepeatException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public FieldRepeatException(String message) {
        super(message);
        this.setCode(ResultCode.PARAM_VALIDATION_ERROR.getCode());
    }

    public FieldRepeatException(Integer code, String message) {
        super(code, message);
    }

    public FieldRepeatException(Integer code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
