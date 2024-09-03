package com.hexagonal.tasks.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AdditionalTaskInfo {
    private final Long userId;
    private final String username;

    private final String userEmail;
}
