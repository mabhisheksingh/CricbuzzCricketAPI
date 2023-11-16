package com.cricketcrickbuzz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomError {
    private String timestamp;
    private String  path;
    private String Status;
    private String error;
    private String requestId;

}
