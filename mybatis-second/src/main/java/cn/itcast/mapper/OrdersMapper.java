package cn.itcast.mapper;

import java.util.List;

import cn.itcast.po.Orders;

public interface OrdersMapper {
	
	// 1.查询全部订单数据
	List<Orders> queryAllOrders();
	
	// 3.查询订单数据，并且关联查询出所属的用户数据  
	List<Orders> queryOrdersAndUsers();

	
	
}
