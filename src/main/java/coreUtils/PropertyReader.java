package coreUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
  //String browser;
  static Properties prop;
  public static String propertyFilePath=System.getProperty("user.dir")+"src/test/resources/config/config.properties";
  public static String getProperty() throws IOException {
	  prop=new Properties();
	  FileInputStream file=new FileInputStream(propertyFilePath);
	  prop.load(file);
	  if(prop.containsKey("browser")) {
		  System.out.println(prop.getProperty("browser"));
	  }
	  return prop.getProperty("browser");
  }
}
