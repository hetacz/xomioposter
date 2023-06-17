package com.hetacz.xomioposter;

import com.hetacz.xomioposter.base.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {

    private static final String ASSERTION_MSG = "Should return 200";
    private final Client client = new Client();

    @Test
    void sendGetRequest() {
        assertEquals(200, client.sendGetRequest(), ASSERTION_MSG);
    }

    @Test
    void sendPostRequest() {
        assertEquals(200, client.sendPostRequest(), ASSERTION_MSG);
    }
}
