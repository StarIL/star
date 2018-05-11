package com.shiwulian.wechat.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.sys.BillType;
import com.shiwulian.wechat.mapper.sys.BillTypeMapper;


@Service
public class BillTypeService {
	@Autowired
	private BillTypeMapper billTypeMapper;

	public List<BillType> selectList(List<Integer> ids) {
		return billTypeMapper.selectList(ids);
	}
}
