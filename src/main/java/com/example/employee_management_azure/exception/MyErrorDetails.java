package com.example.employee_management_azure.exception;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class MyErrorDetails {
    private LocalDateTime timeStamp;
    private String details;
    private String description;

}
