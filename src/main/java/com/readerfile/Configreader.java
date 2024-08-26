package com.readerfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configreader {
	static FileInputStream fis;
	
	public Properties ConfigFile() throws IOException {
		File f = new File("C:\\Users\\User\\eclipse-workspace\\open_MRS\\src\\main\\java\\com\\properties\\SwagData.properties");
	  fis = new FileInputStream(f);
	  
	  Properties p = new Properties();
	  p.load(fis);
	  
	return p;
	
	}
	public String getBrowser() throws IOException {
		String browser =ConfigFile().getProperty("browser");
		return browser;
	}
	public String getUrl() throws IOException {
		String url =ConfigFile().getProperty("url");
		return url;
	}
	public String getUserName() throws IOException {
		String userName =ConfigFile().getProperty("userName");
		return userName;
	}
	public String getPassword() throws IOException {
		String password =ConfigFile().getProperty("password");
		return password;
	}
	public String getHome() throws IOException {
		String home =ConfigFile().getProperty("home");
		return home;
	}
	
	public String getBlank() throws IOException {
		String blank =ConfigFile().getProperty("blanklogin");
		return blank;
	}
	public String getInvalidPass() throws IOException {
		String invalidPass =ConfigFile().getProperty("invalid");
		return invalidPass;
	}
	public String getInvalidEmail() throws IOException {
		String invalidPass =ConfigFile().getProperty("invalid");
		return invalidPass;
	}
	public String getFirstName() throws IOException {
		String firstName =ConfigFile().getProperty("firstName");
		return firstName;
	}
	public String getLastName() throws IOException {
		String lastName =ConfigFile().getProperty("lastName");
		return lastName;
	}
	public String getPostalCode() throws IOException {
		String postalCode =ConfigFile().getProperty("postalCode");
		return postalCode;
	}
	public String getFirstName2() throws IOException {
		String firstName =ConfigFile().getProperty("firstName2");
		return firstName;
	}
	public String getLastName2() throws IOException {
		String lastName =ConfigFile().getProperty("lastName2");
		return lastName;
	}
	public String getPostalCode2() throws IOException {
		String postalCode =ConfigFile().getProperty("postalCode2");
		return postalCode;
	}
	
	public String getFirstName3() throws IOException {
		String firstName =ConfigFile().getProperty("firstName3");
		return firstName;
	}
	public String getLastName3() throws IOException {
		String lastName =ConfigFile().getProperty("lastName3");
		return lastName;
	}
	public String getPostalCode3() throws IOException {
		String postalCode =ConfigFile().getProperty("postalCode3");
		return postalCode;
	}
	public String getFirstName4() throws IOException {
		String firstName =ConfigFile().getProperty("firstName4");
		return firstName;
	}
	public String getLastName4() throws IOException {
		String lastName =ConfigFile().getProperty("lastName4");
		return lastName;
	}
	public String getPostalCode4() throws IOException {
		String postalCode =ConfigFile().getProperty("postalCode4");
		return postalCode;
	}
	public String getFirstName5() throws IOException {
		String firstName =ConfigFile().getProperty("firstName5");
		return firstName;
	}
	public String getLastName5() throws IOException {
		String lastName =ConfigFile().getProperty("lastName5");
		return lastName;
	}
	public String getPostalCode5() throws IOException {
		String postalCode =ConfigFile().getProperty("postalCode5");
		return postalCode;
	}
}
