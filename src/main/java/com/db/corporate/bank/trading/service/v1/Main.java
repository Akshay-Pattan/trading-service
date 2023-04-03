package com.db.corporate.bank.trading.service.v1;

import com.db.corporate.bank.trading.service.v1.util.SignalSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

@SpringBootApplication
public class Main {

    private static final String FILE_NAME = "AllowedSignals.txt";
    private static final String COMMA_REGEX = ",";

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
        loadSignals();
    }

    private static void loadSignals() {
        SignalSingleton signalSingleton = SignalSingleton.getInstance();
        InputStream ioStream = Main.class.getClassLoader().getResourceAsStream(FILE_NAME);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ioStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                signalSingleton.setMappedSignals(Arrays.asList(line.split(COMMA_REGEX)));
            }
        } catch (IOException e) {
            System.exit(0);
        }
    }
}