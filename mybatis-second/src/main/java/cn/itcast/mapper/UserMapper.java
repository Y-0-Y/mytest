package cn.itcast.mapper;

import cn.itcast.po.User;

/**
 * @ClassName: UserMapper 
 * @author Y应Y
 *
 */
public interface UserMapper {
	
	/**
	 * 根据用户查找id
	 * @return
	 */
	User queryUserById(Integer id);
	
	/**
	 * 新增一个用户
	 */
	void insertUser();
	
}
