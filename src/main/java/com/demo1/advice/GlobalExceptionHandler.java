package com.demo1.advice;

import com.demo1.ApiResponse;
import com.demo1.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Object>> handleBusinessException(BusinessException businessException) {
        return ResponseEntity
                .status(123)
                .body(ApiResponse.error(businessException.getCode(), businessException.getMessage()));
    }
//    @ExceptionHandler(BusinessException.class)
//    public ApiResponse<Object> handleBusinessException(BusinessException businessException) {
//        return ApiResponse.error(businessException.getCode(), businessException.getMessage());
//    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleOtherExceptions(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error(500, "服务器内部错误：" + exception.getMessage()));
    }
}
