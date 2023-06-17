package com.justeryt.discordbot.resource;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class LoadToken {
    public static String filename = "config.yml";
    public static Yaml yaml = new Yaml();

    public static String getToken() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(filename);
        Map data = yaml.load(inputStream);
        return data.get("token").toString();
    }
    public static String getApiKey() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(filename);
        Map data = yaml.load(inputStream);
        return data.get("ApiToken").toString();
    }
}
