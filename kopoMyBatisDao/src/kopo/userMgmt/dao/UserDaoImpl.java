package kopo.userMgmt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kopo.userMgmt.vo.UserVO;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	//private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SqlSession session;

	// 사용자 조회
	@Override
	public UserVO read(String id) {	
		UserVO user = session.selectOne("userNS.selectUserById", id);
		return user;
	}	
	

	public List<UserVO> readAll() {
		List<UserVO>  userList = session.selectList("userNS.selectUserList");
		return userList;
	}

	public void insert(UserVO user) {
		session.update("userNS.insertUser",user);
		System.out.println("insert Record Userid" + user.getUserId() + "Name" + user.getName());
	}
	
	@Override
	public void update(UserVO user) {
		session.update("userNS.updateUser",user);
	}

	@Override
	public void delete(String id) {
		session.delete("userNS.deleteUser",id);
		System.out.println("deleted Record Userid" + id);
	}	

}
