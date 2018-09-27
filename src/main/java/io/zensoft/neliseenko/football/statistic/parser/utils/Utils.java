package io.zensoft.neliseenko.football.statistic.parser.utils;

import java.io.IOException;
import java.util.Properties;

public class Utils {

  private static final String CONFIG_PROPERTIES = "configs/config.properties";

  public String readPropertiesValue(String key) {
    Properties prop = new Properties();

    try {
      prop.load(
              this.getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES));
      return prop.getProperty(key);
    } catch (IOException ex) {
      System.err.println(ex.getMessage());
    }
    return "";
  }
}
