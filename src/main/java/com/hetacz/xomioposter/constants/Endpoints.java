package com.hetacz.xomioposter.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Endpoints {

    SAMPLE("/sample"),
    TEST("/test");

    private final String value;
}
