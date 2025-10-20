package com.workintech.s18d2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiResponse<T> {
    private String message;
    private T data;
    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
