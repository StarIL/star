package com.shiwulian.wechat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.javatuples.Triplet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.bean.od.OrderTradeItem;
import com.shiwulian.wechat.bean.request.CreateOrderRequest;
import com.shiwulian.wechat.bean.request.PagedListRequest;
import com.shiwulian.wechat.bean.response.OrderDetailResponse;
import com.shiwulian.wechat.bean.response.OrderInfoResponse;
import com.shiwulian.wechat.bean.response.OrderWorkResponse;
import com.shiwulian.wechat.bean.response.PagedListResponse;
import com.shiwulian.wechat.context.UserAuthContext;
import com.shiwulian.wechat.core.annotation.Authorize;
import com.shiwulian.wechat.service.od.OrderExecutionplanService;
import com.shiwulian.wechat.service.od.OrderService;
import com.shiwulian.wechat.service.od.OrderTradeItemService;
import com.shiwulian.wechat.service.od.PlaceOrderService;
import com.shiwulian.wechat.service.sys.SequenceNumbersService;
import com.shiwulian.wechat.util.SysConfig.OddNumbersName;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="订单相关接口")
@Controller
@RequestMapping(value = "/myOrder")
public class MyOrderController {
	private static final Logger logger = LoggerFactory.getLogger(MyOrderController.class);

	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderTradeItemService orderTradeItemService;
	@Autowired
	private OrderExecutionplanService orderExecutionplanService;
	@Autowired
	private PlaceOrderService placeOrderService;
	@Autowired
	private SequenceNumbersService sequenceNumbersService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "myOrder/index";
	}
	
	@Authorize
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "myOrder/create";
	}
	
	@Authorize
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public ModelAndView info(HttpServletRequest res) {
		ModelAndView mv = new ModelAndView("myOrder/confirm");
		Map<String, String[]> parameterMap = res.getParameterMap();
		parameterMap.forEach((key,value) -> mv.addObject(key.trim(), value[0].trim()));
		return mv;
	}
	
	@Authorize
	@RequestMapping(value = "/cost", method = RequestMethod.GET)
	public ModelAndView cost(String id) {
		ModelAndView mv = new ModelAndView("myOrder/cost");
		mv.addObject("id", id);
		return mv;
	}
	
	@Authorize
	@RequestMapping(value = "/executive", method = RequestMethod.GET)
	public ModelAndView execInfo(String id) {
		ModelAndView mv = new ModelAndView("myOrder/executive");
		mv.addObject("id", id);
		return mv;
	}
	
	@Authorize
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView success(HttpServletRequest res) {
		ModelAndView mv = new ModelAndView("myOrder/success");
		String tp = res.getParameter("tp");
	    mv.addObject("tp",tp);
		return mv;
	}
	
	@Authorize
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(String id) {
		ModelAndView mv = new ModelAndView("myOrder/detail");
		mv.addObject("id",id);
		return mv;
	}
	
	@Authorize //需要公司拦截
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	@ApiOperation(value = "创建订单", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> create(@RequestBody CreateOrderRequest request
			,HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response = new Response<>(false);
		try {
			User user = UserAuthContext.getLocal();
			String orderNo = sequenceNumbersService.createNo(OddNumbersName.ORDER);
			Triplet<Boolean, Object,String> pair = placeOrderService.create(request, user,orderNo);
			response.setSuccess(pair.getValue0());
			response.setData(orderNo);
			response.setMsg(pair.getValue2());
		} catch (Exception e) {
			logger.error("create-order error {}", e);
			response.setMsg("下单出现异常! ");
		}
		return response;
	}

	@Authorize //需要公司拦截
	@RequestMapping(value = "/pagedList",method = RequestMethod.POST)
	@ApiOperation(value = "订单列表", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> pagedList(@RequestBody PagedListRequest request) {
		Response<Object> response = new Response<>(false);
		try {
			request.setCustomerId(UserAuthContext.getLocal().getCustomerId());
			List<PagedListResponse> orders = orderService.pagedList(request);
			if (orders != null && orders.size() > 0) {
				Map<String, Object> map = new HashMap<>();
				Page<PagedListResponse> pages = (Page<PagedListResponse>) orders;
				map.put("pagedList", pages.getResult());
				map.put("totalPage", pages.getPages());
				map.put("totalCount", pages.getTotal());
				response.setSuccess(Boolean.TRUE);
				response.setData(map);
			}
		} catch (Exception e) {
			logger.error("pagedList error {}", e);
		}
		return response;
	}
	
	@Authorize
	@RequestMapping(value = "/queryProducts",method = RequestMethod.POST)
	@ApiOperation(value = "订单列表搜索--产品下拉", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> queryProducts(){
		Response<Object> response = new Response<>(false);
		try {
			String cid = UserAuthContext.getLocal().getCustomerId();
			List<String> result = orderService.selectProducts(cid);
			response.setSuccess(result != null && result.size() > 0);
			response.setData(result);
		} catch (Exception e) {
			logger.error("queryProducts error {}", e);
		}
		return response;
	}

	@Authorize
	@RequestMapping(value = "/queryDetail/{id}",method = RequestMethod.GET)
	@ApiOperation(value = "订单详情", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryDetail(@PathVariable("id") String id) {
		Response<Object> response = new Response<>(false);
		try {
			String cid = UserAuthContext.getLocal().getCustomerId();
			OrderDetailResponse detail = orderService.detail(cid,id,true);
			response.setSuccess(detail != null);
			response.setData(detail);
		} catch (Exception e) {
			logger.error("detail error {}", e);
		}
		return response;
	}
	
	@Authorize
	@RequestMapping(value = "/execctiveInfo/{id}",method = RequestMethod.GET)
	@ApiOperation(value = "订单执行进度", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> execctiveInfo(@PathVariable("id") String id) {
		Response<Object> response = new Response<>(false);
		try {
			String cid = UserAuthContext.getLocal().getCustomerId();
			OrderDetailResponse detail = orderService.detail(cid,id,false);
			response.setSuccess(detail != null);
			response.setData(detail);
		} catch (Exception e) {
			logger.error("detail error {}", e);
		}
		return response;
	}

	@Authorize
	@RequestMapping(value = "/items/{id}",method = RequestMethod.GET)
	@ApiOperation(value = "订单产品信息", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> items(@PathVariable("id") String id) {
		Response<Object> response = new Response<>(false);
		try {
			List<OrderTradeItem> items = orderTradeItemService.selectList(id);
			response.setSuccess(items != null && items.size() > 0);
			response.setData(items);
		} catch (Exception e) {
			logger.error("items error {}", e);
		}
		return response;
	}
	
	/**
	 * 执行调度
	 * 
	 * @param id
	 * @return
	 */
	@Authorize
	@RequestMapping(value = "/plans/{id}",method = RequestMethod.GET)
	@ApiOperation(value = "执行调度", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> plans(@PathVariable("id")String id,@RequestParam(required = false,defaultValue="") Integer limit) {
		Response<Object> response = new Response<>(false);
		try {
			List<OrderWorkResponse> planWorks = orderExecutionplanService.selectParam(id,limit);
			response.setSuccess(planWorks != null && planWorks.size() > 0);
			response.setData(planWorks);
		} catch (Exception e) {
			logger.error("plans error {}", e);
		}
		return response;
	}
	
	/**
	 * 我的 - 订单信息
	 */
	@Authorize //需要公司拦截
	@RequestMapping(value = "/queryInfo",method = RequestMethod.GET)
	@ApiOperation(value = "我的->订单信息", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> orderInfo() {
		Response<Object> response = new Response<>(false);
		try {
			String customerId = UserAuthContext.getLocal().getCustomerId();
			if(StringUtils.isNotBlank(customerId)){
				OrderInfoResponse orderInfo = orderService.queryOrderInfo(customerId);
				response.setData(orderInfo);
				response.setSuccess(true);
			}else{
				response.setMsg("没有注册公司");
			}
		} catch (Exception e) {
			logger.error("orderInfo error {}", e);
		}
		return response;
	}
}
