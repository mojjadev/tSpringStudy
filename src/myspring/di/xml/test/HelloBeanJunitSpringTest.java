package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/bean.xml")
public class HelloBeanJunitSpringTest {
	@Autowired
	ApplicationContext context;
	
	@Test @Ignore
	public void test2() {	
		Hello hello = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");
			
		assertSame(hello, hello2);
		
		//스프링 컨테이너는 해당하는 bean객체를 싱글톤으로 관리하고 있다.
	}
	
	@Test 
	public void test1() {		
		//2. Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		
		assertEquals("Hello Spring", hello.sayHello());
		System.out.println(hello.sayHello());
		hello.print();
		//3. StringPrinter Bean 가져오기
		Printer print = (Printer)context.getBean("printer");
		System.out.println(print.toString()+"<==");
		
		Hello hello2 = context.getBean("hello",Hello.class);
		System.out.println(hello2.sayHello());
		hello2.print();
		System.out.println(print.toString()+"111111111<==");
		System.out.println(hello == hello2);
		
		Printer print1 = (Printer)context.getBean("printer", Printer.class);
		System.out.println(print1.toString()+"<==");
//		assertEquals("Hello Spring", print1.toString());
		print1.print("hi");
		
		Hello hello3 = context.getBean("hello2",Hello.class);		
		assertEquals(3, hello3.getNames().size());
		List<String> list = hello3.getNames();
		for (String value : list) {
			System.out.println(value);
		}
	}

}
