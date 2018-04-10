package cn.itcast.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.po.User;

public class MybatisTest {
	
	
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws IOException{
		
		
			InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = builder .build(inputStream);
		
	}

	/**
	 * 测试根据用户id查询用户
	 */
	@Test
	public void queryUserByIdTest() throws Exception {
		//1.加载sqlMapconfig.xml文件
		//InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		
		//2.读取配置文件内容
		//SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		/**
		 * sqlSessionFactory对象：它是mybatis框架的核心对象，是线程安全的，一个应用中，
		 * 通常只需要一个（单例设计模式）
		 */
		//SqlSessionFactory sqlSessionFactory = builder .build(inputStream);
		
		// 3.使用sqlSessionFactory对象，创建SqlSession对象
				// sqlSession：它是提供给我们操作数据库CRUD的对象
				// 它是线程不安全，每一个执行的方法，都需要创建自己的sqlSession
				SqlSession sqlSession = this.sqlSessionFactory.openSession();
				
				// 4.使用sqlSession对象，调用方法执行
				// selectOne方法：查询单条记录
				// statement参数：执行的sql语句（名称空间+"."+sql语句的id）
				// parameter参数：传入的参数值
				Object user = sqlSession.selectOne("test.queryUserById", 1);
				System.out.println(user);
				
				// 5.释放资源
				sqlSession.close();

		
		
	}
	
	
	
	
	/**
	 * 测试根据用户username查询用户
	 */
	@Test
	public void queryUserByUsernameTest() throws Exception {
	InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		
		//2.读取配置文件内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		/**
		 * sqlSessionFactory对象：它是mybatis框架的核心对象，是线程安全的，一个应用中，
		 * 通常只需要一个（单例设计模式）
		 */
		SqlSessionFactory sqlSessionFactory = builder .build(inputStream);
		
		// 3.使用sqlSessionFactory对象，创建SqlSession对象
				// sqlSession：它是提供给我们操作数据库CRUD的对象
				// 它是线程不安全，每一个执行的方法，都需要创建自己的sqlSession
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				// 4.使用sqlSession对象，调用方法执行
				// selectOne方法：查询单条记录
				// statement参数：执行的sql语句（名称空间+"."+sql语句的id）
				// parameter参数：传入的参数值
				Object user = sqlSession.selectOne("test.queryUserByName", "张三丰");
				System.out.println(user);
				
				// 5.释放资源
				sqlSession.close();

		
	}
	
	
	@Test
	public void insertUserTest(){
		// 1.创建sqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		// 2.使用sqlSession对象，调用方法执行
		// insert方法：新增记录
		// statement参数：执行的sql语句（名称空间+"."+sql语句id）
		// 创建用户对象
		User user = new User();
		user.setId(3);
		user.setUsername("林姑娘");
		user.setSex("2");
		user.setBirthday(new Date());
		user.setAddress("中原人");
		
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		// 3.释放资源
		sqlSession.close();
	}
	

	
	
	
	
	
}
