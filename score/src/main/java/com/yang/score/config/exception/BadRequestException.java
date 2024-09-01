package com.yang.score.config.exception;


import com.yang.score.config.result.ResultCode;

import java.util.Map;

public class BadRequestException extends BaseException {


    public BadRequestException() {
        super(ResultCode.BAD_REQUEST);
    }

    public BadRequestException(Map<String, ?> errors) {
        super(ResultCode.BAD_REQUEST, errors);
    }
}
