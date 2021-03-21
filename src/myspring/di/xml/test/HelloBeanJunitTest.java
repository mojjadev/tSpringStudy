package myspring.di.xml.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {

	ApplicationContext context;
	
	@Before	
	public void init() {
		//1. Ioc 而⑦뀒�씠�꼫 �깮�꽦
		context = new GenericXmlApplicationContext("config/bean.xml");
	}
	
	@Test
	public void test2() {	
		Hello hello = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");
			
		assertSame(hello, hello2);
		
		//�뒪�봽留� 而⑦뀒�씠�꼫�뒗 �빐�떦�븯�뒗 bean媛앹껜瑜� �떛湲��넠�쑝濡� 愿�由ы븯怨� �엳�떎.
	}
	
	@Test @Ignore
	public void test1() {		
		//2. Hello Bean 媛��졇�삤湲�
		Hello hello = (Hello)context.getBean("hello");
		
		assertEquals("Hello Spring", hello.sayHello());
		System.out.println(hello.sayHello());
		hello.print();
		//3. StringPrinter Bean 媛��졇�삤湲�
		Printer print = (Printer)context.getBean("printer");
		System.out.println(print.toString()+"<==");
		
		Hello hello2 = context.getBean("hello",Hello.class);
		System.out.println(hello2.sayHello());
		hello2.print();
		System.out.println(print.toString()+"111111111<==");
		System.out.println(hello == hello2);
		
		Printer print1 = (Printer)context.getBean("printer", Printer.class);
		System.out.println(print1.toString()+"<==");
		assertEquals("Hello Spring", print1.toString());
		print1.print("hi");
	}

}
