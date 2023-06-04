package com.hetacz.xomioposter;

import com.hetacz.xomioposter.base.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {

    private final Client client = new Client();

    @Test
    void sendGetRequest() {
        assertEquals(200, client.sendGetRequest(), "Should return 200");
    }

    @Test
    void sendPostRequest() {
        assertEquals(200, client.sendPostRequest(), "Should return 200");
    }
}
