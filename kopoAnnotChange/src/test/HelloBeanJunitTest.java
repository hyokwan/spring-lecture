package test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kopoInjection.xml.Hello;
import kopoInjection.xml.Printer;

import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class HelloBeanJunitTest {

	@Autowired
	private ApplicationContext context;
	
//	@Before
//	public void init() {
//		context = new GenericXmlApplicationContext("config/beans.xml");
//	}
	
	@Test
	public void bean1() {
		//Hello hello = (Hello)context.getBean("hello");
		Hello hello = context.getBean("hello", Hello.class);
		assertEquals("Hello kopo2", hello.sayHello());
		//System.out.println("test");
		hello.print();
	}
}
