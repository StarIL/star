package com.shiwulian.wechat.bean.request;


public class CreateOrderRequest {

	private Boolean deliveryAgent = false;//送货

	private Boolean warehouseAgent = false;//仓储
	
	private Boolean warehouseDeliveryAgent = false;//送货+仓储

	private Integer importAgent = 1;//进口代理(1=贸易代理,2=进口清关)

	private Boolean payImportTaxAgent = false;//垫付税费
	
	private Boolean cargoMortgageFinancingAgent = false;//货押融资

	private Integer servicesCate;//品类

	private String warehouseId;//仓库
	private String destinationId;//门点

	private Integer startCountryId;//起运国
	private String startCountryName;//国名(冗余)
	private Integer dischargePortId;//起运港
	private String dischargePortName;//港名(冗余)
	
	private Integer financingPercent;//融资比例

	public Boolean getCargoMortgageFinancingAgent() {
		return cargoMortgageFinancingAgent;
	}

	public void setCargoMortgageFinancingAgent(Boolean cargoMortgageFinancingAgent) {
		this.cargoMortgageFinancingAgent = cargoMortgageFinancingAgent;
	}

	public Boolean getDeliveryAgent() {
		return deliveryAgent;
	}

	public void setDeliveryAgent(Boolean deliveryAgent) {
		this.deliveryAgent = deliveryAgent;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public Integer getDischargePortId() {
		return dischargePortId;
	}

	public void setDischargePortId(Integer dischargePortId) {
		this.dischargePortId = dischargePortId;
	}

	public String getDischargePortName() {
		return dischargePortName;
	}

	public void setDischargePortName(String dischargePortName) {
		this.dischargePortName = dischargePortName;
	}

	public Integer getFinancingPercent() {
		return financingPercent;
	}

	public void setFinancingPercent(Integer financingPercent) {
		this.financingPercent = financingPercent;
	}

	public Integer getImportAgent() {
		return importAgent;
	}

	public void setImportAgent(Integer importAgent) {
		this.importAgent = importAgent;
	}

	public Boolean getPayImportTaxAgent() {
		return payImportTaxAgent;
	}

	public void setPayImportTaxAgent(Boolean payImportTaxAgent) {
		this.payImportTaxAgent = payImportTaxAgent;
	}

	public Integer getServicesCate() {
		return servicesCate;
	}

	public void setServicesCate(Integer servicesCate) {
		this.servicesCate = servicesCate;
	}

	public Integer getStartCountryId() {
		return startCountryId;
	}

	public void setStartCountryId(Integer startCountryId) {
		this.startCountryId = startCountryId;
	}

	public String getStartCountryName() {
		return startCountryName;
	}

	public void setStartCountryName(String startCountryName) {
		this.startCountryName = startCountryName;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Boolean getWarehouseAgent() {
		return warehouseAgent;
	}

	public void setWarehouseAgent(Boolean warehouseAgent) {
		this.warehouseAgent = warehouseAgent;
	}

	public Boolean getWarehouseDeliveryAgent() {
		return warehouseDeliveryAgent;
	}

	public void setWarehouseDeliveryAgent(Boolean warehouseDeliveryAgent) {
		this.warehouseDeliveryAgent = warehouseDeliveryAgent;
	}
}
