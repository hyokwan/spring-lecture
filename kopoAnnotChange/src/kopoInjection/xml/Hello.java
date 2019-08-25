package kopoInjection.xml;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import kopoInjection.xml.Printer;

@Component
public class Hello {

	// TODO Auto-generated method stub
	@Value("${myname}")
	private String name;
	
	//@Autowired
	//@Qualifier("stringPrinter")
	@Resource(name="${printer1}")
	private Printer printer;
	
	private List<String> names;
	
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public String sayHello() {
		return "Hello " + name;
	}
	public void print() {
		this.printer.print(sayHello());
	}
}
