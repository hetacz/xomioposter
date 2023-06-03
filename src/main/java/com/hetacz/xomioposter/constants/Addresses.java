package com.hetacz.xomioposter.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Addresses {

    _8080("http://localhost:8080"),
    _8081("http://localhost:8081");

    private final String value;
}
