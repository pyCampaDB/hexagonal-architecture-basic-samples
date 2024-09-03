package com.services.ms.student.app.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCatalog {
    STUDENT_NOT_FOUND("ERR_STUDENT_001", "Student not found"),
    INVALID_STUDENT("ERR_STUDENT_002","Invalid student parameters"),
    GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred");
    private final String code;
    private final String message;
}
