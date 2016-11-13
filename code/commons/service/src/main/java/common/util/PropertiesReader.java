package common.util;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

public class PropertiesReader {
	
	public Properties file;

	public Properties getFile() {
		return file;
	}

	public void setFile(Properties file) {
		this.file = file;
	}
	
	
	public String getString(String key){
		return file.getProperty(key);
	}
}
