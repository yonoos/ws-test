package younes.module.hello;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import fr.jee.api.MyStartupable;
import fr.younes.services.CalService;

public class Hello implements CalService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7802905256280442444L;

	public int calculate(int a, int b) {
		return -999999; 
	}
	
	public String hola(MyStartupable servie) throws IOException {
		System.out.println(servie.getClass().getName());
		Properties props = new Properties();
		InputStream is = Hello.class.getResourceAsStream("/hello.properties");
		props.load(is);
		return "yeeeeeeeeeeeeeeeeeeeeeeees !!!!!!!    toto "+props;
	}
}
