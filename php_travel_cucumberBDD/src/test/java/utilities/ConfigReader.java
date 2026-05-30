package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties init_prop() {
        Properties prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/config/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            System.out.println("Config file not found!");
            e.printStackTrace();
        }
        return prop;
    }
}