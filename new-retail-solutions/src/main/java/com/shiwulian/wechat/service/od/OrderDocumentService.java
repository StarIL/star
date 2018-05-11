package com.shiwulian.wechat.service.od;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiwulian.wechat.bean.od.OrderDocument;
import com.shiwulian.wechat.mapper.od.OrderDocumentMapper;

@Service
public class OrderDocumentService {

	@Autowired
	private OrderDocumentMapper orderDocumentMapper;

	public OrderDocument selectByPrimaryKey(String id) {
		return orderDocumentMapper.selectByPrimaryKey(id);
	}
	
	public List<OrderDocument> selectList(String orderId) {
		return orderDocumentMapper.selectList(orderId);
	}
	
	public int updateByPrimaryKeySelective(OrderDocument record) {
		return orderDocumentMapper.updateByPrimaryKeySelective(record);
	}
	
	public int insertSelective(OrderDocument record) {
		return orderDocumentMapper.insertSelective(record);
	}
}
