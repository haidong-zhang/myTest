package services;

import javax.jws.WebService;

@WebService
public interface CXFDemo {
	public String say(String word);
}
