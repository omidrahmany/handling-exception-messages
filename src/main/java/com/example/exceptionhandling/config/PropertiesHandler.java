package com.example.exceptionhandling.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Component
public class PropertiesHandler {

    private File[] files;

    @Autowired
    public PropertiesHandler(File[] files) {
        this.files = files;
    }

    public String getValue(String key, Object... arguments) {
        String ans = null;
        for (int i = 0; i < files.length; i++) {
            ans = this.getValue(files[i], key, arguments);
            if (ans != null) break;
        }
        return ans == null ? key : ans;
    }

    public String getValue(File file, String key, Object... arguments) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            return null;
            /*ExceptionBase exceptionBase = new ExceptionBase("Properties file is not available.", true);
            exceptionBase.setExceptionCode(ExceptionCode.NOT_FOUND);
            throw exceptionBase;*/
        }
        String value = properties.getProperty(key);
        if (value == null || arguments == null) return null;
        for (int i = 0; i < arguments.length; i++) {
            value = value.replace(String.format("{%d}", i), String.valueOf(arguments[i]));
        }
        return value;
    }

}
