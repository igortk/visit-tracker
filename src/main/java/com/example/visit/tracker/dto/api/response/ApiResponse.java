package com.example.visit.tracker.dto.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Getter
@JsonInclude(NON_NULL)
public class ApiResponse<DATA> {
    private DATA data;
    private Integer count;
    private String errorCode;
    private String messageMessage;
}
