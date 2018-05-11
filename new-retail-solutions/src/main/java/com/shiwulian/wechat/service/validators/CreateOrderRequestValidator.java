package com.shiwulian.wechat.service.validators;

import org.apache.commons.lang3.StringUtils;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.shiwulian.wechat.bean.request.CreateOrderRequest;

public class CreateOrderRequestValidator extends ValidatorHandler<CreateOrderRequest> implements Validator<CreateOrderRequest> {
	@Override
	public boolean validate(ValidatorContext context, CreateOrderRequest request) {
		if(request.getStartCountryId()!=null&& StringUtils.isBlank(request.getStartCountryName())){
			context.addErrorMsg("起运国必须选择! ");
			return false;
		}
		if(request.getDischargePortId()!=null&& StringUtils.isBlank(request.getDischargePortName())){
			context.addErrorMsg("目的港必须选择! ");
			return false;
		}
		if(request.getWarehouseAgent() || request.getWarehouseDeliveryAgent()){
			if(null != request.getWarehouseId()){
				context.addErrorMsg("仓库必须选择! ");
				return false;
			}
		}
		if(request.getDeliveryAgent() || request.getWarehouseDeliveryAgent()){
			if(null != request.getDestinationId()){
				context.addErrorMsg("门点必须选择! ");
				return false;
			}
		}
		if(request.getCargoMortgageFinancingAgent()){
			if(null != request.getFinancingPercent()){
				context.addErrorMsg("融资比例必须选择! ");
				return false;
			}
		}
		return true;
	}
}
