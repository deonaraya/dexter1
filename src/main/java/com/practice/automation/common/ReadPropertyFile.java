package com.practice.automation.common;

import java.io.InputStream;

/**
 * Created by chandrad on 12/26/16.
 */
public class ReadPropertyFile {

    public void readProperty(){

        InputStream input = ReadPropertyFile.class.getClassLoader().getResourceAsStream("config.properties");
    }
}
