package cn.itcast.test;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mapper.OrdersMapper;
import cn.itcast.po.Orders;

/** 
 * @ClassName: OrdersMapperTest 
 * @Description: 订单mapper测试
 * @author 传智 小杨老师  
 * @date 2018-3-27 下午3:16:44 
 *  
 */
public class OrderMapperTest {
	
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
	 * 测试查询全部订单数据
	 */
	@Test
	public void queryAllOrdersTest(){
		
		// 1.创建sqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		// 2.获取mapper代理对象
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		
		List<Orders> list = mapper.queryAllOrders();
		for(Orders o:list){
			System.out.println(o);
		}
		
		// 3.释放资源
		sqlSession.close();
		
		
	}
	
	/**
	 * 测试查询订单数据，并且关联查询出所属的用户数据
	 */
	@Test
	public void queryOrdersAndUsersTest(){
		// 1.创建sqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		// 2.获取mapper代理对象
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		
		List<Orders> list = mapper.queryOrdersAndUsers();
		for(Orders o:list){
			System.out.println(o);
		}
		
		// 3.释放资源
		sqlSession.close();
	}


}
