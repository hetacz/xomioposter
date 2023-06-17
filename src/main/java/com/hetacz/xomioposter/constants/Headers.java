package com.hetacz.xomioposter.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Headers {

    X_FORWARD_FOR("X-Forwarded-For"),
    USER_AGENT("User-Agent");
    //SEC_CH_UA("Sec-Ch-Ua");

    private final String value;
}
