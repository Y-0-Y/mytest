package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 * 
 * @author Y应Y
 *
 */
public class JdbcDemo {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.创建数据库连接对象
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/75_mybati", "root", "root");
			//3.定义sql语句
			String sql = "select * from user where id=?";
			//4.创建statement语句对象
			psmt=con.prepareStatement(sql);
			//5.设置参数
			psmt.setInt(1, 1);
			//6.执行
			rs = psmt.executeQuery();
			//7.处理结果集
			while(rs.next()){
				System.out.println("用户id"+rs.getInt("id")+",用户名称:"+rs.getString("username"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//8.释放资源
			try{
				if(rs != null){ rs.close();}
				if(psmt != null){ psmt.close();}
				if(con != null){ con.close();}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
		

	}

}
