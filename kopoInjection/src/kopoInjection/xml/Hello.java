package kopoInjection.xml;

import java.util.List;
import java.util.Map;

import kopoInjection.xml.Printer;


public class Hello {

	// TODO Auto-generated method stub
	private String name;
	private Printer printer;
	private List<String> names;
	private Map<String, Integer> ages;

	public Map<String, Integer> getAges() {
		return ages;
	}

	public void setAges(Map<String, Integer> ages) {
		this.ages = ages;
	}

	public Hello() { }
	
	public Hello(String name, Printer printer) {
		super();
		this.name = name;
		this.printer = printer;
	}
	
	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public String sayHello() {
		return "Hello " + name;
	}
	public void print() {
		this.printer.print(sayHello());
	}
}
