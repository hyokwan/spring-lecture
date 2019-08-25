package kopo.user.dao;

import java.util.List;
import kopo.user.vo.UserVO;

@MyMapper
public interface UserMapper {

	UserVO selectUserById(String id);
	List<UserVO> selectUserList();
	void insertUser(UserVO userVO);
	void updateUser(UserVO userVO);
	void deleteUser(String id);
}
