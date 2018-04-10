package cn.itcast.test;



import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mapper.UserMapper;
import cn.itcast.po.User;

/** 
 * @ClassName: UserMapperTest 
 * @Description: mapper代理开发方法测试
 * @author 传智 小杨老师  
 * @date 2018-3-26 下午5:33:09 
 *  
 */
public class UserMapperTest {
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	/**
	 * 初始化SqlSessionFactory对象
	 * @throws IOException 
	 */
	@Before
	public void init() throws IOException{
		// 1.加载sqlMapConfig.xml文件
		// resource参数：指定配置文的位置
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		
		// 2.读取配置文件内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
 
		/**
		 * sqlSessionFactory对象：它是mybatis框架的核心对象，是线程安全的，一个应用中，
		 * 通常只需要一个（单例设计模式）
		 */
		sqlSessionFactory = builder.build(inputStream);
	}
	
	/**
	 * 测试根据用户id查询用户
	 */
	@Test
	public void queryUserByIdTest(){
		
		// 1.创建sqlSession对象
		SqlSession sqlSession;
		
			sqlSession = this.sqlSessionFactory.openSession();
			
			// 2.从sqlSession对象，获取mapper代理对象
			// getMapper方法：获取mapper代理对象
			// class：被代理接口的字节码
			try {	
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			System.out.println("===="+mapper.getClass().getName());
			
			User user = mapper.queryUserById(2);
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			sqlSession.close();
		}
		
		// 3.释放资源
		
		
	}

}

