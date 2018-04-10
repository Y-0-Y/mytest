package cn.itcast.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.core.pojo.User;
import cn.itcast.core.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;



	
		/**
		 * 新增
		 * 	action="${pageContext.request.contextPath }/cust/list"
		 * @return 
		 */
		@RequestMapping("/insert.action")
		@ResponseBody
		public void list(User user){
			
			userServiceImpl.insertUser(user);

			
		}

}
