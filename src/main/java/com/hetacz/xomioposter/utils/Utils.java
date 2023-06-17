package com.hetacz.xomioposter.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.random.RandomGenerator;

@Slf4j
@UtilityClass
public class Utils {

    private final RandomGenerator RANDOM = new Random();

    //    private final ObjectMapper MAPPER = new ObjectMapper();

    public List<List<String>> readDataSet(String fileName) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(reader(fileName))) {
            return csvReader
                    .readAll()
                    .stream()
                    .map(Arrays::asList)
                    .toList();
        }
    }

    public String getRandomIP() {
        return "%d.%d.%d.%d".formatted(
                getFirstIpBlock(0, 256),
                randomMinMax(0, 256),
                randomMinMax(0, 256),
                randomMinMax(0, 256)
        );
    }

    public int randomMinMax(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }

    public String encodeQuery(String query) {
        return URLEncoder.encode(query, StandardCharsets.UTF_8);
    }

    private int getFirstIpBlock(int min, int max) {
        int result = randomMinMax(min, max);
        int[] forbidden = {0, 10, 127, 169, 172, 192, 198, 203, 224, 233};
        log.trace("First IP block drawn: {}", result);
        return Arrays.stream(forbidden).anyMatch(i -> i == result) || result > 239
                ? getFirstIpBlock(min, max)
                : result;
    }

    //    public <T> T parseJson(String json, Class<T> clazz) throws JsonProcessingException {
    //        return MAPPER.readValue(json, clazz);
    //    }
    //
    //    public JsonNode toJsonNode(String fileName) throws IOException {
    //        return MAPPER.readTree(reader(fileName));
    //    }

    @Contract("_ -> new")
    private @NotNull InputStreamReader reader(String fileName) {
        return new InputStreamReader(Objects.requireNonNull(Utils.class
                .getClassLoader()
                .getResourceAsStream(fileName)), StandardCharsets.UTF_8);

    }
}
