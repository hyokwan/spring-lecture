package kopoPojo.test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kopoPojo.xml.Hello;
import kopoPojo.xml.Printer;

public class HelloBeanJunitTest {

	private ApplicationContext context;
	
	@Before
	public void init() {
		context = new GenericXmlApplicationContext("config/beans.xml");
	}
	
	@Test
	public void bean1() {
		Hello hello = (Hello)context.getBean("hello");
		assertEquals("Hello kopo", hello.sayHello());
		System.out.println("test");
		hello.print();
	}
}
