package com.hetacz.xomioposter.base;

import com.hetacz.xomioposter.constants.Address;
import com.hetacz.xomioposter.constants.Endpoints;
import com.hetacz.xomioposter.constants.Headers;
import com.hetacz.xomioposter.constants.HttpMethods;
import com.hetacz.xomioposter.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

@Slf4j
public class Client {

    private static final String PAYLOAD = """
            {
              "id": "1",
              "name": "Yo mama"
            }
            """;

    private static final String USER_AGENT = """
            Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36
            """;
    private static final String SEC_CH_UA = """
            "Not.A/Brand";v="8", "Chromium";v="114", "Google Chrome";v="114"
            """;

    public int sendGetRequest() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ClassicHttpRequest get = ClassicRequestBuilder
                    .get(Address._8080.getValue() + Endpoints.SAMPLE.getValue())
                    .addHeader(Headers.X_FORWARD_FOR.getValue(), Utils.getRandomIP())
                    .build();
            return httpClient.execute(get, response -> {
                log.info("Response status: {}, {}", response.getCode(), response.getReasonPhrase());
                int statusCode = response.getCode();
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    log.info("Response content: {}", EntityUtils.toString(entity));
                }
                EntityUtils.consume(entity);
                return statusCode;
            });
        } catch (IOException e) {
            return handleException(HttpMethods.GET, e);
        }
    }

    public int sendPostRequest() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ClassicHttpRequest post = ClassicRequestBuilder
                    .post(Address._8080.getValue() + Endpoints.TEST.getValue())
                    .setEntity(PAYLOAD, ContentType.APPLICATION_JSON)
                    //.addHeader(Headers.SEC_CH_UA.getValue(), SEC_CH_UA)
                    .addHeader(Headers.USER_AGENT.getValue(), USER_AGENT)
                    .addHeader(Headers.X_FORWARD_FOR.getValue(), Utils.getRandomIP())
                    .build();
            return httpClient.execute(post, response -> {
                log.info("Response status: {}, {}", response.getCode(), response.getReasonPhrase());
                int statusCode = response.getCode();
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    log.info("Response content: {}", EntityUtils.toString(entity));
                }
                EntityUtils.consume(entity);
                return statusCode;
            });
        } catch (IOException e) {
            return handleException(HttpMethods.POST, e);
        }
    }

    private int handleException(@NotNull HttpMethods get, @NotNull IOException e) {
        log.warn("Error while sending {} request: {}", get.getValue(), e.getMessage());
        return -1;
    }
}
