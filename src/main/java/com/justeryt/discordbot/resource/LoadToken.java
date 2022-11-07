package com.justeryt.discordbot.resource;

import org.yaml.snakeyaml.Yaml;

import java.io.*;

public class LoadToken {

    public static String getToken() throws FileNotFoundException {
        String filename = "testconfig.yml";
        InputStream inputStream = new FileInputStream(new File(filename));

        Yaml yaml = new Yaml();
        String data = yaml.load(inputStream);
        return data.split("token=")[1];
    }
}
