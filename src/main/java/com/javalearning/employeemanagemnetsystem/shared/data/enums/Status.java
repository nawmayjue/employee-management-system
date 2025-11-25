package com.javalearning.employeemanagemnetsystem.shared.data.enums;

import java.util.Arrays;
import java.util.List;

public enum Status {
    INVALID (0, "Invalid"),
    ACTIVE (1, "Active"),
    INACTIVE (3, "Inactive");

    private final Integer code;
    private final String description;

    Status (Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode(){
        return code;
    }

    public String getDescription(){
        return description;
    }

    public static List<StatusInfo> listInfo(){
        return Arrays.stream(
                Status.values()).map(
                        status -> new StatusInfo(status.getCode(), status.getDescription())

        ).toList();
    }

}
