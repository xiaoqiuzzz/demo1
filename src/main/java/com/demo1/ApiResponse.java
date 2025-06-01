package com.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;      // 状态码，0 表示成功，非0表示错误
    private String message; // 提示信息或错误描述
    private T data;         // 业务数据，泛型支持任意类型

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(0, message, data);
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }
}