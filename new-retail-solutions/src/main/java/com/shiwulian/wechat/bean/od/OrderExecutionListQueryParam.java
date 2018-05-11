package com.shiwulian.wechat.bean.od;

public class OrderExecutionListQueryParam {
	/* **************************** 日期 ****************************/
	//受理日期
	private String acceptStartDate;
	private String acceptEndDate;
	//到港日期
	private String etaStartDate;
	private String etaEndDate;
	//到单日期
	private String recDocumentStartDate;
	private String recDocumentEndDate;
	//申报日期
	private String declarationStartDate;
	private String declarationEndDate;
	//代理完成日期
	private String agentCompleteStartTime;
	private String agentCompleteEndTime;
	//清关完成日期
	private String eclareCompleteStartTime;
	private String eclareCompleteEndTime;
	//送货完成日期
	private String deliveryCompleteStartTime;
	private String deliveryCompleteEndTime;
	//仓储完成日期
	private String storageCompleteStartTime;
	private String storageCompleteEndTime;
	//还款完成日期
	private String financeCompleteStartTime;
	private String financeCompleteEndTime;
	//服务完成日期
	private String serviceCompleteStartDate;
	private String serviceCompleteEndDate;
	//结算完成日期
	private String settleCompleteStartDate;
	private String settleCompleteEndDate;
	//订单完成日期
	private String orderCompleteStartDate; 
	private String orderCompleteEndDate;
	//下单日期
	private String createStartDate;
	private String createEndDate;
	/* **************************** 服务 ****************************/
	//进口代理：1:贸易代理； 2、进口清关
	private Integer importAgent;
	//送货
	private Boolean deliveryAgent;
	//仓储
	private Boolean warehouseAgent;
	//垫付进口税费
	private Boolean payImportTaxAgent;
	//货押融资
	private Boolean cargoMortgageFinancingAgent;
	/* **************************** 状态 ****************************/
	//内部状态
	private Integer serviceStatusSelf;

	/* **************************** 拍档 ****************************/
	//拍档
	private String partnerId; 
	//代理拍档
	private String agentPartnerId;
	//清关拍档
	private String eclarePartnerId;
	//送货拍档
	private String deliveryPartnerId;
	//仓储拍档
	private String storagePartnerId;
	
	//客户
	private String customerId;
	//客服userName
	private String serviceOperator;
	//口岸id(目的港id)
	private Integer dischargePortId;
	
	//订单号
	private String orderCode;
	//提单号
	private String billNo;
	//报关单号
	private String customsNo;
	//报检号
	private String inspectionNo;
	//贸易合同号
	private String contractNo;
	//品类[1：活鲜2：冻品]
	private Integer serviceCateType;
	
	public String getAcceptStartDate() {
		return acceptStartDate;
	}
	public void setAcceptStartDate(String acceptStartDate) {
		this.acceptStartDate = acceptStartDate;
	}
	public String getAcceptEndDate() {
		return acceptEndDate;
	}
	public void setAcceptEndDate(String acceptEndDate) {
		this.acceptEndDate = acceptEndDate;
	}
	public String getEtaStartDate() {
		return etaStartDate;
	}
	public void setEtaStartDate(String etaStartDate) {
		this.etaStartDate = etaStartDate;
	}
	public String getEtaEndDate() {
		return etaEndDate;
	}
	public void setEtaEndDate(String etaEndDate) {
		this.etaEndDate = etaEndDate;
	}
	public String getRecDocumentStartDate() {
		return recDocumentStartDate;
	}
	public void setRecDocumentStartDate(String recDocumentStartDate) {
		this.recDocumentStartDate = recDocumentStartDate;
	}
	public String getRecDocumentEndDate() {
		return recDocumentEndDate;
	}
	public void setRecDocumentEndDate(String recDocumentEndDate) {
		this.recDocumentEndDate = recDocumentEndDate;
	}
	public String getDeclarationStartDate() {
		return declarationStartDate;
	}
	public void setDeclarationStartDate(String declarationStartDate) {
		this.declarationStartDate = declarationStartDate;
	}
	public String getDeclarationEndDate() {
		return declarationEndDate;
	}
	public void setDeclarationEndDate(String declarationEndDate) {
		this.declarationEndDate = declarationEndDate;
	}
	public String getAgentCompleteStartTime() {
		return agentCompleteStartTime;
	}
	public void setAgentCompleteStartTime(String agentCompleteStartTime) {
		this.agentCompleteStartTime = agentCompleteStartTime;
	}
	public String getAgentCompleteEndTime() {
		return agentCompleteEndTime;
	}
	public void setAgentCompleteEndTime(String agentCompleteEndTime) {
		this.agentCompleteEndTime = agentCompleteEndTime;
	}
	public String getEclareCompleteStartTime() {
		return eclareCompleteStartTime;
	}
	public void setEclareCompleteStartTime(String eclareCompleteStartTime) {
		this.eclareCompleteStartTime = eclareCompleteStartTime;
	}
	public String getEclareCompleteEndTime() {
		return eclareCompleteEndTime;
	}
	public void setEclareCompleteEndTime(String eclareCompleteEndTime) {
		this.eclareCompleteEndTime = eclareCompleteEndTime;
	}
	public String getDeliveryCompleteStartTime() {
		return deliveryCompleteStartTime;
	}
	public void setDeliveryCompleteStartTime(String deliveryCompleteStartTime) {
		this.deliveryCompleteStartTime = deliveryCompleteStartTime;
	}
	public String getDeliveryCompleteEndTime() {
		return deliveryCompleteEndTime;
	}
	public void setDeliveryCompleteEndTime(String deliveryCompleteEndTime) {
		this.deliveryCompleteEndTime = deliveryCompleteEndTime;
	}
	public String getStorageCompleteStartTime() {
		return storageCompleteStartTime;
	}
	public void setStorageCompleteStartTime(String storageCompleteStartTime) {
		this.storageCompleteStartTime = storageCompleteStartTime;
	}
	public String getStorageCompleteEndTime() {
		return storageCompleteEndTime;
	}
	public void setStorageCompleteEndTime(String storageCompleteEndTime) {
		this.storageCompleteEndTime = storageCompleteEndTime;
	}
	public String getFinanceCompleteStartTime() {
		return financeCompleteStartTime;
	}
	public void setFinanceCompleteStartTime(String financeCompleteStartTime) {
		this.financeCompleteStartTime = financeCompleteStartTime;
	}
	public String getFinanceCompleteEndTime() {
		return financeCompleteEndTime;
	}
	public void setFinanceCompleteEndTime(String financeCompleteEndTime) {
		this.financeCompleteEndTime = financeCompleteEndTime;
	}
	public String getServiceCompleteStartDate() {
		return serviceCompleteStartDate;
	}
	public void setServiceCompleteStartDate(String serviceCompleteStartDate) {
		this.serviceCompleteStartDate = serviceCompleteStartDate;
	}
	public String getServiceCompleteEndDate() {
		return serviceCompleteEndDate;
	}
	public void setServiceCompleteEndDate(String serviceCompleteEndDate) {
		this.serviceCompleteEndDate = serviceCompleteEndDate;
	}
	public String getSettleCompleteStartDate() {
		return settleCompleteStartDate;
	}
	public void setSettleCompleteStartDate(String settleCompleteStartDate) {
		this.settleCompleteStartDate = settleCompleteStartDate;
	}
	public String getSettleCompleteEndDate() {
		return settleCompleteEndDate;
	}
	public void setSettleCompleteEndDate(String settleCompleteEndDate) {
		this.settleCompleteEndDate = settleCompleteEndDate;
	}
	public String getOrderCompleteStartDate() {
		return orderCompleteStartDate;
	}
	public void setOrderCompleteStartDate(String orderCompleteStartDate) {
		this.orderCompleteStartDate = orderCompleteStartDate;
	}
	public String getOrderCompleteEndDate() {
		return orderCompleteEndDate;
	}
	public void setOrderCompleteEndDate(String orderCompleteEndDate) {
		this.orderCompleteEndDate = orderCompleteEndDate;
	}
	public String getCreateStartDate() {
		return createStartDate;
	}
	public void setCreateStartDate(String createStartDate) {
		this.createStartDate = createStartDate;
	}
	public String getCreateEndDate() {
		return createEndDate;
	}
	public void setCreateEndDate(String createEndDate) {
		this.createEndDate = createEndDate;
	}
	public Integer getImportAgent() {
		return importAgent;
	}
	public void setImportAgent(Integer importAgent) {
		this.importAgent = importAgent;
	}
	public Boolean getDeliveryAgent() {
		return deliveryAgent;
	}
	public void setDeliveryAgent(Boolean deliveryAgent) {
		this.deliveryAgent = deliveryAgent;
	}
	public Boolean getWarehouseAgent() {
		return warehouseAgent;
	}
	public void setWarehouseAgent(Boolean warehouseAgent) {
		this.warehouseAgent = warehouseAgent;
	}
	public Boolean getPayImportTaxAgent() {
		return payImportTaxAgent;
	}
	public void setPayImportTaxAgent(Boolean payImportTaxAgent) {
		this.payImportTaxAgent = payImportTaxAgent;
	}
	public Boolean getCargoMortgageFinancingAgent() {
		return cargoMortgageFinancingAgent;
	}
	public void setCargoMortgageFinancingAgent(Boolean cargoMortgageFinancingAgent) {
		this.cargoMortgageFinancingAgent = cargoMortgageFinancingAgent;
	}
	public Integer getServiceStatusSelf() {
		return serviceStatusSelf;
	}
	public void setServiceStatusSelf(Integer serviceStatusSelf) {
		this.serviceStatusSelf = serviceStatusSelf;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getAgentPartnerId() {
		return agentPartnerId;
	}
	public void setAgentPartnerId(String agentPartnerId) {
		this.agentPartnerId = agentPartnerId;
	}
	public String getEclarePartnerId() {
		return eclarePartnerId;
	}
	public void setEclarePartnerId(String eclarePartnerId) {
		this.eclarePartnerId = eclarePartnerId;
	}
	public String getDeliveryPartnerId() {
		return deliveryPartnerId;
	}
	public void setDeliveryPartnerId(String deliveryPartnerId) {
		this.deliveryPartnerId = deliveryPartnerId;
	}
	public String getStoragePartnerId() {
		return storagePartnerId;
	}
	public void setStoragePartnerId(String storagePartnerId) {
		this.storagePartnerId = storagePartnerId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getServiceOperator() {
		return serviceOperator;
	}
	public void setServiceOperator(String serviceOperator) {
		this.serviceOperator = serviceOperator;
	}
	public Integer getDischargePortId() {
		return dischargePortId;
	}
	public void setDischargePortId(Integer dischargePortId) {
		this.dischargePortId = dischargePortId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getCustomsNo() {
		return customsNo;
	}
	public void setCustomsNo(String customsNo) {
		this.customsNo = customsNo;
	}
	public String getInspectionNo() {
		return inspectionNo;
	}
	public void setInspectionNo(String inspectionNo) {
		this.inspectionNo = inspectionNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Integer getServiceCateType() {
		return serviceCateType;
	}
	public void setServiceCateType(Integer serviceCateType) {
		this.serviceCateType = serviceCateType;
	}
	
}
