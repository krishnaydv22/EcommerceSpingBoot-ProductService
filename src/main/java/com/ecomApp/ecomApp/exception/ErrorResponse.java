package com.ecomApp.ecomApp.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private  String message;
    private int status;
    private LocalDateTime time;
}
