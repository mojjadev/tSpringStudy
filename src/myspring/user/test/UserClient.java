package myspring.user.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/bean.xml")
public class UserClient {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserService service;
	
	@Test @Ignore
	public void dataSourceTest() {
		DataSource ds = context.getBean("dataSource", DataSource.class);
		try {
			System.out.println(ds.getConnection());
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test @Ignore
	public void getUserTest() {
		UserVO user = service.getUser("gildong");
		System.out.println(user);
		
		for (UserVO user1 : service.getUserList()) {
			System.out.println(user1);
		}
		
		assertEquals("홍길동", user.getName());
		
		
	}
	
	@Test @Ignore
	public void insertUserTest() {
		UserVO user = new UserVO();
		user.setUserId("duli1");
		user.setName("둘리2");
		user.setGender("man");
		user.setCity("서울");		
		try {
			service.insertUser(user);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		for (UserVO user1 : service.getUserList()) {
			System.out.println(user1);
		}		
	}
	@Test @Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("gildong", "홍길동", "남", "부산"));
		for (UserVO user1 : service.getUserList()) {
			System.out.println(user1);
		}
		
	}
	
	@Test
	public void deleteUserTest() {
		service.deleteUser("duli");
		for (UserVO user1 : service.getUserList()) {
			System.out.println(user1);
		}
		
	}
	

}
