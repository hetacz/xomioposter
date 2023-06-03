package com.hetacz.xomioposter;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import java.io.IOException;
import java.util.Arrays;

@Slf4j
public class Requester {

    private static final String ADDRESS = "http://localhost:8080/sample";

    public void sendGetRequest() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ClassicHttpRequest get = ClassicRequestBuilder
                    .get(ADDRESS)
                    .addHeader("X-Forwarded-For", "80.80.80.80")
                    .build();
            httpClient.execute(get, response -> {
                log.info("Response status: {}, {}", response.getCode(), response.getReasonPhrase());
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    log.info("Response content length: {}", entity.getContent());
                    log.info("Response content: {}", EntityUtils.toString(entity));
                }
                EntityUtils.consume(entity);
                return null;
            });
        } catch (IOException e) {
            log.warn("Error while sending GET request: {}", e.getMessage());
            throw new ConnectionException(e);
        }
    }

    public void sendPostRequest() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ClassicHttpRequest get = ClassicRequestBuilder
                    .post(ADDRESS)
                    .addHeader("X-Forwarded-For", "80.80.80.80")
                    .build();
            httpClient.execute(get, response -> {
                log.info("Response status: {}, {}", response.getCode(), response.getReasonPhrase());
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    log.info("Response content length: {}", entity.getContent());
                    log.info("Response content: {}", EntityUtils.toString(entity));
                }
                EntityUtils.consume(entity);
                return null;
            });
        } catch (IOException e) {
            log.warn("Error while sending GET request: {}", e.getMessage());
            throw new ConnectionException(e);
        }
    }
}
