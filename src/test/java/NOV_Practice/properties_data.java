package NOV_Practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.Properties;



public class properties_data {
	Properties p = new Properties();
	
	String path = "src/test/resources/com/pro/testdata.properties";
	
	public properties_data() throws Exception {
	BufferedReader buf = new BufferedReader(new FileReader(path));
	p.load(buf);
	
	}
	
	public String geturl(){
		String url  = p.getProperty("url");
		return url;
		
	}
	
}
