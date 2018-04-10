package cn.itcast.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.core.mapper.UserMapper;
import cn.itcast.core.pojo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	
	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
		
	}


	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
		System.out.println("1111");
	}


	public UserServiceImpl() {
		super();
		System.out.println();
	}



	
	

	
}
