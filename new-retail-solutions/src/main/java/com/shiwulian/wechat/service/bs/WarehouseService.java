package com.shiwulian.wechat.service.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.bs.Warehouse;
import com.shiwulian.wechat.bean.response.SelectResponse;
import com.shiwulian.wechat.bean.response.WarehouseResponse;
import com.shiwulian.wechat.mapper.bs.WarehouseMapper;


@Service
public class WarehouseService {

	@Autowired
	private WarehouseMapper warehouseMapper;
	
	public Warehouse selectByPrimaryKey(String id){
		return warehouseMapper.selectByPrimaryKey(id);
	} 
	public List<Warehouse> selectList(){
		return warehouseMapper.selectList();
	}
	
	public List<Warehouse> selectAll(){
		List<Warehouse> warehouseList = warehouseMapper.selectList();
		return warehouseList;
	}
	
	public List<WarehouseResponse> selectResponse(){
		List<WarehouseResponse> result=new ArrayList<>();
		List<Warehouse> warehouses = warehouseMapper.selectList();
		if(warehouses != null && warehouses.size() > 0){
			List<Integer> locations=warehouses.stream().map(q -> q.getCityId()).distinct().collect(Collectors.toList());
			locations.forEach(q->{
				WarehouseResponse warehouse=new WarehouseResponse();
				if(warehouses.parallelStream().anyMatch(p->p.getCityId().equals(q))){
					List<Warehouse> names=warehouses.parallelStream().filter(p->p.getCityId().equals(q)).collect(Collectors.toList());
					if(names.size()>0){
						warehouse.setCityId(q);
						warehouse.setCityName(names.get(0).getCityName());
						warehouse.setText(names.get(0).getCityName());
						warehouse.setNames(names);
						result.add(warehouse);
					}
				}
			});
		}
		return result;
	}
	
	public List<SelectResponse> convertToSelect() {
		List<Warehouse> whs = warehouseMapper.selectList();
		List<SelectResponse> srs = new ArrayList<>();
		whs.forEach(q ->{
			SelectResponse sr = new SelectResponse();
			sr.setText(q.getCityId());
			sr.setValue(q.getName());
			srs.add(sr);
		});
		return srs;
	}
	public Warehouse queryByLocationAndName(String location,String name){
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("location", location);
		return warehouseMapper.queryByLocationAndName(map);
	}
}
