package kopo.userMgmt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kopo.userMgmt.vo.UserVO;

@Repository("userDao")
public class UserDaoImplJDBC implements UserDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	class UserMapper implements RowMapper<UserVO> {
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
			user.setUserId(rs.getString("userid"));
			user.setName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			return user;
		}
	}
	
	// 사용자 조회
	@Override
	public UserVO read(String id) {	
		String SQL = "select userid, name, gender, city "
				+ "from users where userid = ?";
		try {
			UserVO user = jdbcTemplate.queryForObject(SQL,
					new Object[] { id }, new UserMapper());
			return user;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}	
	
	// 사용자 추가
	public void insert(UserVO user) {
		String SQL = "insert into users "+
					 "(userid, name, gender,city) "+
				     "values (?, ?, ?, ?)";
		
		jdbcTemplate.
			update(SQL, user.getUserId(), user.getName(), user.getGender(), user.getCity());
		
		System.out.println("Record UserId=" + user.getUserId() + " Name=" + user.getName());
	}

	public List<UserVO> readAll() {
		String SQL = "select * from users"; 
		List<UserVO>  userList = jdbcTemplate.query(SQL, new UserMapper());
		return userList;
	}

	//@Override
	public void delete(String id) {
		String SQL = "delete from "
				+ " users "
				+ " where userid = ?"; 
		jdbcTemplate.update(SQL, id); 
		System.out.println("Record with ID = " + id ); 
	}

	
	
	
	
	//@Override
	public void update(UserVO user) {
		String SQL = "update users  "
				+ "set name = ?,"
				+ " gender = ?,"
				+ " city = ? "
				+ "where userid = ?"; 
		jdbcTemplate.update(SQL, user.getName(), user.getGender(), user.getCity(),user.getUserId()); 
		System.out.println("Record with ID = " + user.getUserId() ); 
	}



}
