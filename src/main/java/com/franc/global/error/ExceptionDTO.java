package com.franc.global.error;

import jakarta.validation.constraints.NotNull;


public record ExceptionDTO(
        @NotNull Integer code,
        @NotNull String message
) {

    public static ExceptionDTO of(ErrorCode errorCode) {
        return new ExceptionDTO(errorCode.getCode(), errorCode.getMessage());
    }
}