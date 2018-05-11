package com.shiwulian.wechat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.bean.request.CustomerBillRequest;
import com.shiwulian.wechat.bean.sa.CustomerBill;
import com.shiwulian.wechat.context.UserAuthContext;
import com.shiwulian.wechat.core.annotation.Authorize;
import com.shiwulian.wechat.service.sa.CustomerBillService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="我的账单")
@Controller
@RequestMapping(value = "/myBill")
public class MyBillController {

	private static final Logger logger = LoggerFactory.getLogger(MyBillController.class);
	
	@Autowired
	private CustomerBillService customerBillService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "myBill/index";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(String id) {
		ModelAndView mv = new ModelAndView("myBill/detail");
	    mv.addObject("id",id);
		return mv;
	}
	
	
	@Authorize //需要公司拦截
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	@ApiOperation(value = "查询我的账单列表", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> queryList(@RequestBody CustomerBillRequest request) {
		Response<Object> response = new Response<>(false);
		try {
			if (null == request) {
				response.setSuccess(false);
				response.setMsg("请求参数不能为空");
				return response;
			}
			String customerId = UserAuthContext.getLocal().getCustomerId();
			PageHelper.startPage(request.getCurrentPage(), request.getPageSize(), null);
			List<CustomerBill> customerBillList = this.customerBillService.queryList(request, customerId);
			if (null != customerBillList && !customerBillList.isEmpty()) {
				Map<String, Object> map = new HashMap<>();
				Page<CustomerBill> pages = (Page<CustomerBill>) customerBillList;
				map.put("pagedList", pages.getResult());
				map.put("totalPage", pages.getPages());
				map.put("totalCount", pages.getTotal());
				response.setSuccess(Boolean.TRUE);
				response.setData(map);
				response.setMsg("查询我的账单成功");
			}
		} catch (Exception e) {
			logger.error("查询我的账单失败:{}", e);
			response.setSuccess(false);
			response.setMsg("查询我的账单失败,失败原因为：" + e.getMessage());
		}
		return response;
	}
	
	@Authorize //需要公司拦截
	@RequestMapping(value = "/queryBillDetail")
	@ApiOperation(value = "查询账单详情", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryBillDetail(String customerBillId) {
		Response<Object> response = new Response<>(false);
		try {
			response.setData(this.customerBillService.queryBillDetail(customerBillId));
			response.setSuccess(true);
			response.setMsg("查询账单详情成功");
		} catch (Exception e) {
			logger.error("查询账单详情失败:{}", e);
			response.setSuccess(false);
			response.setMsg("查询账单详情失败,失败原因为：" + e.getMessage());
		}
		return response;
	}
	
	@Authorize //需要公司拦截
	@RequestMapping(value = "/confirmBill",method = RequestMethod.POST)
	@ApiOperation(value = "确认账单", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> confirmBill(String customerBillId, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		Response<Object> response = new Response<>(false);
		try {
			User user = UserAuthContext.getLocal();
			return this.customerBillService.confirmBill(customerBillId, user.getUserName());
		} catch (Exception e) {
			logger.error("确认账单失败：{}", e);
			response.setSuccess(false);
			response.setMsg("确认账单失败,失败原因：" + e.getMessage());
		}
		return response;
	}
	
	@Authorize //需要公司拦截
	@RequestMapping(value = "/myBillStatistics", method = RequestMethod.POST)
	@ApiOperation(value = "我的账单统计", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> myBillStatistics() {
		Response<Object> response = new Response<>(false);
		CustomerBillRequest request = new CustomerBillRequest();
		Map<String, Object> map = new HashMap<>();
		try {
			String customerId = UserAuthContext.getLocal().getCustomerId();
			//待确认
			request.setStatus(1);//待确认
			request.setIsExpected(false);//非预期false
			List<CustomerBill> customerBillConfirmList = this.customerBillService.queryList(request, customerId);
			map.put("pendingConfirmCount", customerBillConfirmList != null ? customerBillConfirmList.size() : 0);
			//代付款
			request.setStatus(2);//代付款
			request.setIsExpected(false);//非预期false
			List<CustomerBill> customerBillPaymentList = this.customerBillService.queryList(request, customerId);
			map.put("pendingPaymentCount", customerBillPaymentList != null ? customerBillPaymentList.size() : 0);
			//预期
			request.setStatus(-1);
			request.setIsExpected(true);//预期true
			List<CustomerBill> customerBillExpectedList = this.customerBillService.queryList(request, customerId);
			map.put("pendingExpectedCount", customerBillExpectedList != null ? customerBillExpectedList.size() : 0);
			response.setSuccess(true);
			response.setData(map);
			response.setMsg("查询我的账单统计成功");
		} catch (Exception e) {
			logger.error("查询我的账单统计失败:{}", e);
			response.setSuccess(false);
			response.setMsg("查询我的账单统计失败,失败原因为：" + e.getMessage());
		}
		return response;
	}
	
}
