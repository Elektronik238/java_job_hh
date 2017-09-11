package ru.kuzn_evg;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetJSON {
    public static String load(URL url) {
        if (url == null)
            return null;
        StringBuilder sb = new StringBuilder();
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "java_job_hh/0.1 (elektronik238@gmail.com)");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();
            String inputLine;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
                while ((inputLine = in.readLine()) != null)
                    sb.append(inputLine);
            } catch (IOException e) {
                System.out.println("Произошла ошибка ответа сервера");
                return null;
            }
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("Произошла ошибка подключения к серверу");
            return null;
        }
        return sb.toString();
    }
}
