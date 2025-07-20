package com.ruoyi.erweima.commm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    public static String post(String url, String jsonParam) {
        HttpURLConnection connection = null;
        OutputStream os = null;
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            os = connection.getOutputStream();
            os.write(jsonParam.getBytes(StandardCharsets.UTF_8));
            os.flush();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
            } else {
                log.error("HTTP request failed with code: {}", responseCode);
            }
        } catch (Exception e) {
            log.error("HTTP request error: {}", e.getMessage(), e);
        } finally {
            try {
                if (os != null) os.close();
                if (br != null) br.close();
                if (connection != null) connection.disconnect();
            } catch (IOException e) {
                log.error("Resource close error: {}", e.getMessage(), e);
            }
        }
        return result.toString();
    }
}