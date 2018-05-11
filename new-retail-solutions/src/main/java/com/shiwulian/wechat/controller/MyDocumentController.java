package com.shiwulian.wechat.controller;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.od.OrderDocument;
import com.shiwulian.wechat.bean.request.SaveDocumentRequest;
import com.shiwulian.wechat.context.UserAuthContext;
import com.shiwulian.wechat.service.od.OrderDocumentService;
import com.shiwulian.wechat.service.validators.SaveDocumentRequestValidator;
import com.shiwulian.wechat.util.ObjectId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="单据文件相关接口")
@Controller
@RequestMapping(value = "/myDoc")
public class MyDocumentController {
	private static final Logger logger = LoggerFactory.getLogger(MyOrderController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView info(String id) {
		ModelAndView mv = new ModelAndView("myDoc/index");
		mv.addObject("id",id);
		return mv;
	}
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView upload(String id) {
		ModelAndView mv = new ModelAndView("myDoc/info");
		mv.addObject("id",id);
		return mv;
	}

	@Autowired
	private OrderDocumentService orderDocumentService;

	/**
	 * 单据信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/docs",method = RequestMethod.GET)
	@ApiOperation(value = "查询单据文件列表", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> docs(String orderId) {
		Response<Object> response = new Response<>(false);
		try {
			List<OrderDocument> docs = orderDocumentService.selectList(orderId);
			response.setSuccess(docs != null && docs.size() > 0);
			response.setData(docs);
		} catch (Exception e) {
			logger.error("docs error {}", e);
		}
		return response;
	}
	
	/**
	 * 单据文件新增
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ApiOperation(value = "单据文件新增", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> save(@RequestBody SaveDocumentRequest request) {
		Response<Object> response = new Response<>(false);
		try {
			String actorName =UserAuthContext.getLocal().getUserName();
			Result validator = FluentValidator.checkAll().on(request, new SaveDocumentRequestValidator()).doValidate().result(ResultCollectors.toSimple());
			if(validator.isSuccess()){
				OrderDocument record = new OrderDocument();
				BeanUtils.copyProperties(request, record);
				record.setId(new ObjectId().toString());
				record.setCreateTime(new Date());
				record.setUploadTime(new Date());
				record.setUploadOperator(actorName);
				int rowEffects = orderDocumentService.insertSelective(record);
				response.setSuccess(rowEffects > 0);
			}else{
				response.setMsg(validator.getErrors().get(0));
			}			
		} catch (Exception e) {
			logger.error("docs error {}", e);
		}
		return response;
	}

	/**
	 * 单据文件删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/up/{id}",method = RequestMethod.GET)
	@ApiOperation(value = "单据文件删除", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> del(@PathVariable("id")String id) {
		Response<Object> response = new Response<>(false);
		try {
			String actorName =UserAuthContext.getLocal().getUserName();
			OrderDocument record = orderDocumentService.selectByPrimaryKey(id);
			if(record != null){
				record.setIsDel(Boolean.TRUE);
				record.setUploadOperator(actorName);
				record.setUptTime(new Date());
				int rowEffects = orderDocumentService.updateByPrimaryKeySelective(record);
				response.setSuccess(rowEffects > 0);
			}else{
				response.setMsg("单据文件不存在");
			}
		} catch (Exception e) {
			logger.error("up error {}", e);
		}
		return response;
	}
}
