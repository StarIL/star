package com.shiwulian.wechat.service.fn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.bs.CustomerUser;
import com.shiwulian.wechat.bean.bs.Partner;
import com.shiwulian.wechat.bean.fn.CustomerAccountBill;
import com.shiwulian.wechat.bean.fn.Receipt;
import com.shiwulian.wechat.bean.request.CustomerAccountBillRequest;
import com.shiwulian.wechat.bean.sa.CustomerBill;
import com.shiwulian.wechat.context.UserAuthContext;
import com.shiwulian.wechat.mapper.bs.CustomerUserMapper;
import com.shiwulian.wechat.mapper.bs.PartnerMapper;
import com.shiwulian.wechat.mapper.fn.CustomerAccountBillMapper;
import com.shiwulian.wechat.mapper.fn.ReceiptMapper;
import com.shiwulian.wechat.mapper.sa.CustomerBillMapper;

@Service
public class CustomerAccountBillService {

	@Autowired
	CustomerAccountBillMapper customerAccountBillMapper;
	@Autowired
	CustomerUserMapper customerUserMapper;
	@Autowired
	PartnerMapper partnerMapper;
	@Autowired
	CustomerBillMapper customerBillMapper;
	@Autowired
	ReceiptMapper receiptMapper;
	
	/**
	 * 查询我的资金流水
	 * @param accountBillRequest
	 * @return
	 */
	public Response<Object> queryMyAccountBill(CustomerAccountBillRequest accountBillRequest) throws Exception{
		Response<Object> response = new Response<Object>(false);
		CustomerUser customerUser= customerUserMapper.selectByUid(UserAuthContext.getLocal().getId());
		accountBillRequest.setCustomerId(customerUser.getCustomerId());
		PageHelper.startPage(accountBillRequest.getCurrentPage(), accountBillRequest.getPageSize());
		List<CustomerAccountBill> accountBills = customerAccountBillMapper.selectByConditions(accountBillRequest);
		for (CustomerAccountBill customerAccountBill : accountBills) {
			if(customerAccountBill.getBillType() == 1){//入今
				Receipt receipt = receiptMapper.selectByPrimaryKey(customerAccountBill.getComeBillId());
				customerAccountBill.setPayeeAndDrawee(receipt.getPayee());
			}else if(customerAccountBill.getBillType() == 2){//出金
				CustomerBill bill = customerBillMapper.selectByPrimaryKey(customerAccountBill.getComeBillId());
				Partner partner = partnerMapper.selectByPrimaryKey(bill.getPartnerId());
				if(partner != null){
					customerAccountBill.setPayeeAndDrawee(partner.getPartnerName() == null ? "":partner.getPartnerName());
				}
			}else{
				customerAccountBill.setPayeeAndDrawee(null);
			}
		}
		return response;
	}
	
}
