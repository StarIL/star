package com.shiwulian.wechat.service.bs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.javatuples.Triplet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.shiwulian.wechat.bean.bs.Customer;
import com.shiwulian.wechat.bean.bs.CustomerUser;
import com.shiwulian.wechat.bean.bs.Partner;
import com.shiwulian.wechat.bean.bs.PartnerUser;
import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.bean.fn.CustomerAccount;
import com.shiwulian.wechat.bean.request.UserRegisterRequest;
import com.shiwulian.wechat.bean.request.UserUpdateReuqest;
import com.shiwulian.wechat.bean.response.UserInfoResponse;
import com.shiwulian.wechat.mapper.bs.CustomerMapper;
import com.shiwulian.wechat.mapper.bs.CustomerUserMapper;
import com.shiwulian.wechat.mapper.bs.PartnerMapper;
import com.shiwulian.wechat.mapper.bs.PartnerUserMapper;
import com.shiwulian.wechat.mapper.bs.UserMapper;
import com.shiwulian.wechat.mapper.cs.CustomerAccountMapper;
import com.shiwulian.wechat.util.ObjectId;
import com.shiwulian.wechat.util.RegExpUtil;

@Service
public class UserService {	
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CustomerUserMapper customerUserMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private CustomerAccountMapper customerAccountMapper;
	@Autowired
	private PartnerMapper partnerMapper;
	@Autowired
	private PartnerUserMapper partnerUserMapper;

	public int updateByPrimaryKeySelective(User record) {
		User oldD = userMapper.selectByPrimaryKey(record.getId());
		BeanUtils.copyProperties(record, oldD);
		return userMapper.updateByPrimaryKey(oldD);
	}
	public User selectByPrimaryKey(String id){
		return userMapper.selectByPrimaryKey(id);
	}
	
	public  int insertSelective(User record){
		return userMapper.insertSelective(record);
	}
	
	public User selectByUserName(String userName){
		return userMapper.selectByUserName(userName);
	}
	
	public User selectByMobile(String mobile){
		return userMapper.selectByMobile(mobile);
	}

	public Triplet<Boolean,Object,String> uptMobile(String oldMobile,String mobile) {
		User user = userMapper.selectByMobile(mobile);
		if(user == null){//已经修改,那么查不到
			return Triplet.with(false, oldMobile, "修改手机失败! 请不要重复提交");
		}
		user.setMobile(mobile);
		user.setUptOperator(user.getUserName());
		user.setUptTime(new Date());
		int i = userMapper.updateByPrimaryKeySelective(user);
		if(i == 1){
			return Triplet.with(true, mobile, "修改手机成功! ");
		}else{
			return Triplet.with(false, mobile, "修改手机失败, 请稍候再试! ");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Triplet<Boolean, User,String> register(UserRegisterRequest request,Integer userType) {		
		User record = new User();
		record.setId(new ObjectId().toString());
		record.setUserName(request.getUserName());
		record.setRealName(request.getUserName());
		record.setMobile(request.getMobile());
		String password = DigestUtils.sha256Hex(request.getPassword());
		record.setPassword(password);
		record.setUserType(userType);
		record.setCreateOperator(request.getUserName());
		record.setCreateTime(new Date());
		record.setIsDel(Boolean.FALSE);
		record.setValid(Boolean.TRUE);
		int rowEffects = userMapper.insertSelective(record);
		return Triplet.with(rowEffects > 0, record,rowEffects > 0 ? "注册成功":"注册失败，请稍后重试");
	}

	public Triplet<Boolean, Object, String> uptEmail(String mobile, String email) {
		User user = userMapper.selectByMobile(mobile);
		if(user == null){
			return Triplet.with(false, mobile, "修改邮箱失败! 手机号错误");
		}
		user.setEmail(email);
		user.setUptOperator(user.getUserName());
		user.setUptTime(new Date());
		int i = userMapper.updateByPrimaryKeySelective(user);
		if(i >= 1){
			//TODO 发送认证邮件
			return Triplet.with(true, mobile, "修改邮箱成功!");
		}else{
			return Triplet.with(false, mobile, "修改邮箱失败!");
		}
	}

	public Triplet<Boolean, User, String> uptPwd(String mobile, String password) {
		if(!RegExpUtil.match("^[a-zA-Z0-9]{6,18}$", password) || StringUtils.isBlank(password)){
			return Triplet.with(false, null,"密码为6-18位字母与数字组合！");
		}
		User user = userMapper.selectByMobile(mobile);
		if(user == null){
			return Triplet.with(false, null, "修改密码失败! 手机号错误");
		}
		String hexPassword = DigestUtils.sha256Hex(password);
		user.setPassword(hexPassword);
		user.setUptOperator(user.getUserName());
		user.setUptTime(new Date());
		int i = userMapper.updateByPrimaryKeySelective(user);
		if(i >= 1){
			return Triplet.with(true, user, "修改密码成功!");
		}else{
			return Triplet.with(false, user, "修改密码失败!");
		}
	}
	
	public UserInfoResponse queryInfo(User user) {
		UserInfoResponse response = new UserInfoResponse();		
		CustomerUser customerUser = customerUserMapper.selectByUid(user.getId());
		if(customerUser != null){
			Customer customer = customerMapper.selectByPrimaryKey(customerUser.getCustomerId());
			response.setCustomer(customer);//用户所属公司
			User operator = userMapper.selectByUserName(customer.getServiceOperator());
			response.setOperator(operator);//公司客服
			if(StringUtils.isNotBlank(customer.getId())){
				CustomerAccount customerAccount = customerAccountMapper.selectByCustomerId(customer.getId());
				response.setCapital(customerAccount.getCapital());//账户余额
			}
		}else{
			//TODO 未加入公司
		}
		response.setUser(user);//用户
		return response;
	}
	
	public UserInfoResponse queryOperator(User user) {
		UserInfoResponse response = new UserInfoResponse();		
		Customer userComp = customerMapper.selectByPrimaryKey(user.getCustomerId());
		User operator = userMapper.selectByUserName(userComp.getServiceOperator());
		response.setOperator(operator);//公司客服
		PartnerUser partnerUser = partnerUserMapper.selectByUid(operator.getId());
		String partnerId = partnerUser.getPartnerId();
		Partner partner = partnerMapper.selectByPrimaryKey(partnerId);
		response.setPartner(partner);//客服拍档
		return response;
	}
	
	/**
	 * 我的同事(除自己)
	 */
	public List<User> colleagues(String userId){
		CustomerUser customerUser = customerUserMapper.selectByUid(userId);
		if(customerUser == null) return null;
		List<User> colleagues = userMapper.colleagues(customerUser.getCustomerId());
		return colleagues.stream().filter(q->{return !StringUtils.equals(q.getId(),userId);}).collect(Collectors.toList());
	}

	/**
	 * 加入新同事
	 */
	public Triplet<Boolean, Object, String> newColleague(String id,String mobile){
		if(StringUtils.isBlank(mobile)) return Triplet.with(false, mobile, "加入同事失败! 手机号不能为空! ");
		User my = userMapper.selectByPrimaryKey(id);
		CustomerUser customerUser = customerUserMapper.selectByUid(my.getId());
		if(null == customerUser) return Triplet.with(false, mobile, "加入同事失败! id错误");
		customerUser.setId(new ObjectId().toString());
		User colleague = userMapper.selectByMobile(mobile);
		if(null == colleague) return Triplet.with(false, mobile, "加入同事失败! 手机号错误");
		customerUser.setUserId(colleague.getId());
		customerUser.setCreateOperator(my.getUserName());
		customerUser.setCreateTime(new Date());
		customerUser.setIsDel(false);
		customerUserMapper.insertSelective(customerUser);
		return Triplet.with(true, mobile, "加入同事成功");
	}	
	/**
	 * 修改用户信息(五种方式)
	 */
	public Triplet<Boolean, Object, String> uptUser(String id,UserUpdateReuqest request){
		User user = userMapper.selectByPrimaryKey(id);
		String portrait = request.getPortrait();//图片
		if(StringUtils.isNotBlank(portrait)){
			user.setPortrait(portrait);
		}
		String realName = request.getRealName();//姓名
		if(StringUtils.isNotBlank(realName)){
			user.setRealName(realName);
		}
		String englishName = request.getEnglishName();//英文名
		if(StringUtils.isNotBlank(englishName)){
			user.setEnglishName(englishName);
		}
		Boolean gender = request.getGender();//性别
		if(null != gender){
			user.setGender(gender);
		}
		String birthday = request.getBirthday();//生日
		if(StringUtils.isNoneBlank(birthday)){
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(request.getBirthday());
				user.setBirthday(date);
			} catch (ParseException e) {
				return Triplet.with(false, null, "日期修改失败! 格式必须是'yyyy-MM-dd'");
			}
		}
		userMapper.updateByPrimaryKey(user);
		return Triplet.with(true, null, "修改成功! ");
	}
}
