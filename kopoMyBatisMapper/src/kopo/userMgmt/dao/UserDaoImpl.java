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
	private UserMapper userMapper;

	// 사용자 조회
	@Override
	public UserVO read(String id) {	
		UserVO user = userMapper.selectUserById(id);
		return user;
	}	
	

	public List<UserVO> readAll() {
		List<UserVO>  userList = userMapper.selectUserList();
		return userList;
	}

	public void insert(UserVO user) {
		userMapper.insertUser(user);
		System.out.println("insert Record Userid" + user.getUserId() + "Name" + user.getName());
	}
	
	@Override
	public void update(UserVO user) {
		userMapper.updateUser(user);
	}

	@Override
	public void delete(String id) {
		userMapper.deleteUser(id);
		System.out.println("deleted Record Userid" + id);
	}	

}
