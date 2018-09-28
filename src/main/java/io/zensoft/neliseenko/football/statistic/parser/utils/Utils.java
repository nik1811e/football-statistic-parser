package io.zensoft.neliseenko.football.statistic.parser.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

public final class Utils {
  private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
  private static final String CONFIG_PROPERTIES = "configs/config.properties";

  private Utils() {
  }

  public static String readPropertiesValue(String key) {
    Properties prop = new Properties();

    try {
      prop.load(
              Utils.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES));
      return prop.getProperty(key);
    } catch (Exception ex) {
      LOGGER.error(Arrays.toString(ex.getStackTrace()));
    }
    return "";
  }
}
