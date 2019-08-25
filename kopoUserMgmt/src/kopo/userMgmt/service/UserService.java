package kopo.userMgmt.service;

import java.util.List;

import kopo.userMgmt.vo.UserVO;

public interface UserService {

	public void insertUser(UserVO user);
	
	public List<UserVO> getUserList();
	
	public void deleteUser(String id);
	
	public UserVO getUser(String id);
	
	public void updateUser(UserVO user);
}

