package com.shiwulian.wechat.bean.sa;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 应收账单实体类
 * @author ZhangSuYun
 * @date 2018-01-11
 */
public class CustomerBill {
    private String id;
    private String billCode;//账单编号
    private Date billDate;//账单日期
    private Date periodDate;
    private String customerId;
    private String partnerId;
    private BigDecimal amount;//账单金额
    private Integer status;//账单状态:1、待审;2、确认;3、核销
    private Date confirmTime;
    private String confirmOperator;
    private Date payTime;
    private String payOperator;
    private String invoiceId;
    private String createOperator;
    private Date createTime;
    private String uptOperator;
    private Date uptTime;
    private Boolean isDel;
    private Integer currencyId;//币种ID
    private BigDecimal invoiceAmount;//开票金额(冗余) 
    private Boolean invoiceIscomplete;//开票完成
    private Boolean billType;//类型：0、客户；1、拍档
    private String paypartnerId;//应付拍档ID
    private String outbankId;//支付银行ID
    private String inbankId;//收款银行ID
    private int expectedDays;//预期天数
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public Date getPeriodDate() {
		return periodDate;
	}
	public void setPeriodDate(Date periodDate) {
		this.periodDate = periodDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
	public String getConfirmOperator() {
		return confirmOperator;
	}
	public void setConfirmOperator(String confirmOperator) {
		this.confirmOperator = confirmOperator;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public String getPayOperator() {
		return payOperator;
	}
	public void setPayOperator(String payOperator) {
		this.payOperator = payOperator;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getCreateOperator() {
		return createOperator;
	}
	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUptOperator() {
		return uptOperator;
	}
	public void setUptOperator(String uptOperator) {
		this.uptOperator = uptOperator;
	}
	public Date getUptTime() {
		return uptTime;
	}
	public void setUptTime(Date uptTime) {
		this.uptTime = uptTime;
	}
	public Boolean getIsDel() {
		return isDel;
	}
	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}
	public Integer getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}
	public BigDecimal getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public Boolean getInvoiceIscomplete() {
		return invoiceIscomplete;
	}
	public void setInvoiceIscomplete(Boolean invoiceIscomplete) {
		this.invoiceIscomplete = invoiceIscomplete;
	}
	public Boolean getBillType() {
		return billType;
	}
	public void setBillType(Boolean billType) {
		this.billType = billType;
	}
	public String getPaypartnerId() {
		return paypartnerId;
	}
	public void setPaypartnerId(String paypartnerId) {
		this.paypartnerId = paypartnerId;
	}
	public String getOutbankId() {
		return outbankId;
	}
	public void setOutbankId(String outbankId) {
		this.outbankId = outbankId;
	}
	public String getInbankId() {
		return inbankId;
	}
	public void setInbankId(String inbankId) {
		this.inbankId = inbankId;
	}
	public int getExpectedDays() {
		return expectedDays;
	}
	public void setExpectedDays(int expectedDays) {
		this.expectedDays = expectedDays;
	}
}