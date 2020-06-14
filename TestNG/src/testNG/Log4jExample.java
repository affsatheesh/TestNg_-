package testNG;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jExample {
  static Logger logger = Logger.getLogger(Log4jExample.class);
  
  public static void main(String[] arg) {
    PropertyConfigurator.configure("config.properties");
    logger.debug("this is debug");
    logger.info("this is debug");
    logger.error("this is debug");
    logger.fatal("this is debug");
  }
}
