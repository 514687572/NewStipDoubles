package com.stip.net.config;

import com.stip.net.base.BizException;
import com.stip.net.base.StipResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public StipResponse exceptionHandler(BizException e) {
        StipResponse resp = new StipResponse();

        resp.setStatus(StipResponse.STATUS_SYSTEM);
        resp.setData(e.getMessage());
        StipResponse.success(e.getMessage());

        return resp;
    }

    @ExceptionHandler
    public StipResponse exceptionHandler(Exception e) {
        StipResponse resp = new StipResponse();

        resp.setStatus(StipResponse.STATUS_SYSTEM);
        resp.setData(e.getMessage());
        StipResponse.success(e.getMessage());

        return resp;
    }
}
