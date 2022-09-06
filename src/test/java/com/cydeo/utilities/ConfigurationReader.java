package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // 1 Create the object of Properties
    private static Properties properties = new Properties();

    static {

        try {
            //2 We need to open the file in java memory: FileInputStream
            FileInputStream file = new FileInputStream("configiration.properties");

            //3 Load the properties object using FileInputStream
            properties.load(file);
            file.close();

        } catch (IOException e) {
            System.out.println("Error occured while reading configuration file");
            e.printStackTrace();
        }
    }

    public static  String getProperties(String keyword) {
        return properties.getProperty(keyword);
    }
}
