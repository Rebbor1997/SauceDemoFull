package core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ReadProperties {
    private static ReadProperties instance;
    protected static Properties properties;

    private ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }
    public String getTestRailURL() {
        return properties.getProperty("testrail");
    }
    public String getApiUsername() {
        return properties.getProperty("username");
    }
    public String getApiPassword() {
        return properties.getProperty("password");
    }


    public String getURL() {
        return properties.getProperty("url");
    }
    public String getBrowserName() {
        return properties.getProperty("browser");
    }
    public boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }
    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}
