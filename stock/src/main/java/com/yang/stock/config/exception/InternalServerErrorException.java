package com.yang.stock.config.exception;


import com.yang.stock.config.result.ResultCode;

import java.util.Map;

public class InternalServerErrorException extends BaseException {
    public InternalServerErrorException() {
        super(ResultCode.INTERNAL_SERVER_ERROR);
    }

    public InternalServerErrorException(Map<String, ?> errors) {
        super(ResultCode.INTERNAL_SERVER_ERROR, errors);
    }
}
