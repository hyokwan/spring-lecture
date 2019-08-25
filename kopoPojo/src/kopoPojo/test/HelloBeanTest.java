package kopoPojo.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kopoPojo.xml.Hello;
import kopoPojo.xml.Printer;

public class HelloBeanTest {

	public static void main(String[] args) {
		//1. IoC 컨테이너 생성
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		//2. Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		
		// 결과 hello에 설정된 property인 name에 kopo가 대입되어 hello kopo 출력
		System.out.println(hello.sayHello());
		
		// hello 에 맵핑된 print -> console 프린터에 파라미터값이 hello kopo
		// 가 들어가서 console call + hello kopo 출력됨
		hello.print();
		
		Printer printer = context.getBean("printer", Printer.class);
		
		// beanid가 print로 설정된 부분에 stringPrinter가 맵핑됨 따라서 String call test 출력
		printer.print("test");
		
		Hello hello2 = context.getBean("hello",Hello.class);
		
		// hello 는 싱글톤
		System.out.println(hello == hello2);
	}

}
