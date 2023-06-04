package com.hetacz.xomioposter.base;

import com.hetacz.xomioposter.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Loop {

    private final Client client = new Client();
    private final int reps;
    private final int minWait;
    private final int maxWait;
    private final AtomicInteger errorCounter = new AtomicInteger(0);
    private static final int EXPECTED_STATUS_CODE = 200;

    public Loop(@NotNull Input input) {
        this.reps = input.reps();
        this.minWait = input.minWait();
        this.maxWait = input.maxWait();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < reps; i++) {
            log.debug("Loop iteration: {}", i + 1);
            int statusCode = client.sendPostRequest();
            if (statusCode != EXPECTED_STATUS_CODE) {
                int err = errorCounter.incrementAndGet();
                log.error("Error count: {}, status code: {} is not as expected: {}.", err, statusCode,
                        EXPECTED_STATUS_CODE);
            }
            Thread.sleep(Utils.randomMinMax(minWait, maxWait));
        }
    }
}
