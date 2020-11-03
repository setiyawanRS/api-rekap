package com.bkkbn.siga.util.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bkkbn.siga.response.BaseResponse;
import com.bkkbn.siga.util.error.handling.CustomException;

@ControllerAdvice
public class ControllerExceptionAdvice {
    private Logger logger = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

    private ResponseEntity<Object> buildResponseEntity(BaseResponse baseResponse) {
        return new ResponseEntity<>(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    private ResponseEntity<Object> customException(CustomException e) {
        logger.error("BusinessException ", e);
        return new ResponseEntity<> (new BaseResponse(e.getErrorCode(), e.getErrorMessage()), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(Exception.class) 
    private ResponseEntity<Object> errException(Exception e) {
    	logger.info("error info : {}", e.getMessage());
        logger.error(e.getMessage(), e);
        BaseResponse baseDto = new BaseResponse("Error Application", "Error Application");
        return this.buildResponseEntity(baseDto);
    }

}