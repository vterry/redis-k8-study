package com.sample.sampleredis.sampleredis.util;

import org.springframework.http.HttpHeaders;

public class UtilAuthorization {

    private static String TOKEN = "c2FtcGxldG9rZW4K";

    public static void authorize(HttpHeaders headers) throws Exception {
        if (!TOKEN.equals(headers.get("token").get(0))) {
            throw new Exception("Não autorizado");
        }
    }

    public static String requestAuthorization() {
        return TOKEN;
    }
}
