package com.shiwulian.wechat.service.bs;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.bs.Customer;
import com.shiwulian.wechat.bean.bs.CustomerUser;
import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.bean.cs.CustomerCustomer;
import com.shiwulian.wechat.bean.fn.CustomerAccount;
import com.shiwulian.wechat.bean.request.CustomerRequest;
import com.shiwulian.wechat.bean.request.CustomerResgisterRequest;
import com.shiwulian.wechat.context.UserAuthContext;
import com.shiwulian.wechat.mapper.bs.CustomerMapper;
import com.shiwulian.wechat.mapper.bs.CustomerUserMapper;
import com.shiwulian.wechat.mapper.cs.CustomerAccountMapper;
import com.shiwulian.wechat.mapper.cs.CustomerCustomerMapper;
import com.shiwulian.wechat.util.ObjectId;

@Service
public class CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private CustomerUserMapper customerUserMapper;
	@Autowired
	private CustomerCustomerMapper customerCustomerMapper;
	@Autowired
	private CustomerAccountMapper customerAccountMapper;	
		
	public Customer selectByPrimaryKey(String id){
		return customerMapper.selectByPrimaryKey(id);
	}
	
	public int updateByPrimaryKeySelective(Customer record){
		return customerMapper.updateByPrimaryKeySelective(record);
	}
	public Customer selectByName(String cnName) {
		return customerMapper.selectByName(cnName);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertCustomer(CustomerResgisterRequest request,String actorName){
		Customer record = new Customer();
		String customerId = new ObjectId().toString();
		record.setId(customerId);
		record.setCnName(request.getCustomerName());
		record.setCreateTime(new Date());
		record.setRegDate(new Date());
		record.setCreateOperator(actorName);
		record.setApproveStatus(false);
		customerMapper.insertSelective(record);
		
		if(StringUtils.isNotBlank(request.getUid())){
			CustomerUser record1 = new CustomerUser();
			record1.setId(new ObjectId().toString());
			record1.setUserId(request.getUid());
			record1.setCustomerId(customerId);
			record1.setCreateOperator(actorName);// 创建用户
			record1.setCreateTime(new Date());
			customerUserMapper.insertSelective(record1);
		}
		CustomerCustomer ccRecord = new CustomerCustomer();//客户客户冗余
		ccRecord.setId(customerId);//id同客户（便于订单检索买方信息）
		ccRecord.setCustomerId(customerId);
		ccRecord.setIsSelf(Boolean.TRUE);
		ccRecord.setCnName(request.getCustomerName());
		ccRecord.setCreateOperator(actorName);
		customerCustomerMapper.insertSelective(ccRecord);

		CustomerAccount account = customerAccountMapper.selectByCustomerId(record.getId());//debug
		if(account == null){
			account = new CustomerAccount();
			account.setId(new ObjectId().toString());
			account.setCustomerId(record.getId());
			customerAccountMapper.insertSelective(account);
		}
	}
	
	public Customer selectById(String id){
		return customerMapper.selectByPrimaryKey(id);
	}

	public Triplet<Boolean, Object, String> exitOfComp(String mobile,User user) {
		if(StringUtils.isBlank(mobile)){
			return Triplet.with(false, mobile, "手机号不能为空");
		}
		CustomerUser record = customerUserMapper.selectByUid(user.getId());
		record.setIsDel(Boolean.TRUE);
		int i = customerUserMapper.updateByPrimaryKeySelective(record);
		if(i >= 1){
			return Triplet.with(true, mobile, "退出企业成功");
		}else{
			return Triplet.with(true, mobile, "退出企业失败! ");
		}
	}

	public Triplet<Boolean, Object, String> updateByRequest(CustomerRequest request) {
		//Customer customer = new Customer();
		//TODO V1.7 企业资料-5处修改
		return null;
	}

	/**
	 * 查询我的企业信息
	 * @param userId
	 * @return
	 */
	public Response<Object> selectMyCustomerByUid(String userId) {
		Response<Object> response = new Response<>(false);
		CustomerUser customerUser= customerUserMapper.selectByUid(userId);
		if(customerUser != null){
			Customer customer = customerMapper.selectByPrimaryKey(customerUser.getCustomerId());
			if(customer != null){
				response.setSuccess(true);
				response.setData(customer);
			}else{
				response.setMsg("查询企业信息失败！");
			}
		}else{
			response.setMsg("查询企业信息失败！");
		}
		return response;
	}

	/**
	 * 更新我的企业信息
	 * @param customer
	 * @return
	 */
	public Response<Object> saveMyCustomer(Customer customer) {
		customer.setUptOperator(UserAuthContext.getLocal().getId());
		customer.setUptTime(new Date());
		boolean success = customerMapper.updateByPrimaryKeySelective(customer) > 0;
		Response<Object> response = new Response<>(success);
		return response;
	}
}

