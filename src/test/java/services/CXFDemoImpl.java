package services;

public class CXFDemoImpl implements CXFDemo{

	@Override
	public String say(String word) {
		return "response:"+word;
	}

}
