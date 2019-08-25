package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import kopo.userMgmt.dao.UserDao;
//import kopo.userMgmt.service.UserService;
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
	
	@Test @Ignore
	public void configTest() {
		SqlSession session = context.getBean("sqlSession", SqlSession.class);
		System.out.println(session.getClass().getName());
	}
	
	@Test 
	public void mybatisSelectTest() {
		SqlSession session = context.getBean("sqlSession", SqlSession.class);
		System.out.println(session.getClass().getName());

		UserVO vo = session.selectOne("userNS.selectUserById","haiteam");
		System.out.println(vo);
	}
}
