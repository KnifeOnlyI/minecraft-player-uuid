package fr.koi.minecraftplayeruuid.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Service to manage HTTP requests
 */
public final class HttpService {
    private HttpService() {
    }

    /**
     * Fetch the return data at the specified URL (JSON format)
     *
     * @param url       The URL
     * @param valueType The value type to get
     * @param <T>       The type
     *
     * @return The data fetch and convert to the specified type
     *
     * @throws IOException In case of HTTP or JSON error
     */
    public static <T> T get(URL url, Class<T> valueType) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("accept", "application/json");

        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(responseStream, valueType);
    }
}
