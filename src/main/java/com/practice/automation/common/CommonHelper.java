package com.practice.automation.common;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by chandrad on 12/26/16.
 */
public class CommonHelper {

    public static String getPropData(String item) throws IOException {
        Properties prop = new Properties();
        InputStream input = CommonHelper.class.getClassLoader().getResourceAsStream("config.properties");
        prop.load(input);
        return prop.getProperty(System.getProperty("environment") + "." + item);
    }


    public static String getUniqueEmail(String name){
        String value = name + new SimpleDateFormat("ss").format(new Date()) + "@mailinator.com";
        return value;
    }

    @Test
    public void dd(){
        System.out.println(getUniqueEmail("chandra"));

    }


}