package test;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kopoInjection.xml.Hello;
import kopoInjection.xml.Printer;

public class HelloBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		
		
		/////////////  Setter Injection //////////////
		Hello hello = (Hello)context.getBean("hello");
		System.out.println(hello.sayHello());
		
		/////////////  Collection Injection //////////////
		Hello linstInject = (Hello)context.getBean("collectListInjection");
		List<String> list = linstInject.getNames();
		
		for (int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
/*		for (String value:list) {
			System.out.println(value);
		}*/
		
		DataSource ds = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(ds.getConnection());
			System.out.println("connection 성공");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
