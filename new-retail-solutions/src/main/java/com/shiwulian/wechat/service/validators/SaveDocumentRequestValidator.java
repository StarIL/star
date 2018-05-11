package com.shiwulian.wechat.service.validators;

import org.apache.commons.lang3.StringUtils;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.shiwulian.wechat.bean.request.SaveDocumentRequest;

public class SaveDocumentRequestValidator extends ValidatorHandler<SaveDocumentRequest> implements Validator<SaveDocumentRequest> {
	@Override
	public boolean validate(ValidatorContext context, SaveDocumentRequest request) {
		if (StringUtils.isBlank(request.getBillNo())) {
			context.addErrorMsg("请填写单据编号");
			return false;
		}
		if (request.getBillId() == null && request.getBillId() <= 0) {
			context.addErrorMsg("请选择类型");
			return false;
		}
		if (StringUtils.isBlank(request.getBillFileUrl()) || StringUtils.isBlank(request.getBillFileName())) {
			context.addErrorMsg("请上传单据文件");
			return false;
		}
		return true;
	}
}
