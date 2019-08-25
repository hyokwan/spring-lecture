package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kopo.userMgmt.dao.UserDao;
import kopo.userMgmt.service.UserService;
import kopo.userMgmt.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/dataBeans.xml")
public class UserClient {
	
	@Autowired
	ApplicationContext context;

	@Test 
	public void dataSourceTest() {
		DataSource ds = (DataSource) context.getBean("datasource");
		try {
			System.out.println(ds.getConnection());
			System.out.println("connection 성공");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Autowired
	UserService service;
	
	@Test @Ignore
	public void getUserSelectTest() {
		UserVO user = service.getUser("haiteam");
		System.out.println(user);
		assertEquals("kimhyokwan", user.getName());
	}
	
	@Test @Ignore
	public void insertUserTest() {
		service.insertUser(new UserVO("ahn","ahnmin","female","seoul"));
		
		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
	
	@Test @Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("ahn","ahnminj","female","seoul"));
		
		UserVO user = service.getUser("ahn");
		System.out.println(user);
	}
	
	@Test 
	public void deleteUserTest() {
		service.deleteUser("ahn");
		
		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
}
