package com.xhhxd.retail.util;

import java.util.ArrayList;
import java.util.List;

public class SysConfig {
	
	public static String aliyun_endpoint = "";
	public static String aliyun_accessKeyId = "";
	public static String aliyun_accessKeySecret = "";
	public static String aliyun_bucketName = "";
	public static String aliyun_bucketHost = "";
	
	public static String verifyCode="000000";
	
	/**
	 *变更拍档的类型
	 */
	public enum PartnerType{
		UNKNOWN(0,"默认-客户的拍档"),AGENT(1,"代理拍档"),ECLARE(2,"清关拍档"),DELIVERY(3,"送货拍档"),STORAGE(4,"仓储拍档");
		
		private String name;
		private int value;
		
		private PartnerType(int value,String name){
			this.name = name;
			this.value = value;
		}
		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String getName(int value) {
			for (PartnerType c : PartnerType.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}

	/**
	 * 服务订单状态
	 *
	 */
	public enum OrderStatus {
		
		/*
		 *服务订单状态(-10: 已关闭,10:发货中,20:清关中,30:配送中,40:结算中,50:已结算,60:已完成,0:受理中-默认) 
		 */
		CANCEL(-10,"已关闭"),PLACEORDER(0,"受理中"),ACCEPANCE(20, "发货中"), 
		TRANSPORT_F(30, "清关中"),CLEARANCE(40,"配送中"),TRANSPORT_I(50,"结算中"),SETTLEMENT(60,"已结算"),COMPLETE(70,"已完成");

		private String name;
		private int value;

		private OrderStatus(int value, String name) {
			this.name = name;
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String getName(int value) {
			for (OrderStatus c : OrderStatus.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}

	public enum CorpStatus{
		UNKNOWN(0, "默认"), THREEEINONE(10, "三证合一"),CERTIFICATE(20,"三证");
		private String name;
		private int value;

		private CorpStatus(int value, String name) {
			this.name = name;
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String getName(int value) {
			for (CorpStatus c : CorpStatus.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}
	
	public enum UserType {
		CUSTOMER(1, "客户"), COMPANY(2, "食务链"),SUPPLIER(3, "供应商");

		private String name;
		private int value;

		private UserType(int value, String name) {
			this.name = name;
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String getName(int value) {
			for (UserType c : UserType.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}

	public enum RelationType {
		SUPPLIER(1, "供应商"), CUSTOMER(2, "客户");

		private String name;
		private int value;

		private RelationType(int value, String name) {
			this.name = name;
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String getName(int value) {
			for (RelationType c : RelationType.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}

	public enum TransportType {
		OCEAN(1, "海运"), AIR(2, "空运");
		private int value;
		private String name;

		private TransportType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String getName(int value) {
			for (TransportType c : TransportType.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}
	/**
	 * 内部状态
	 *
	 */
	public enum ServiceStatus {
		ENQUIRY(-20,"已询价"),CANCEL(-10,"已关闭"),PLACEORDER(0,"待受理"),AUDIT(10, "审核中"), ACCEPANCE(20, "发货中"),TRANSPORT_F(30,"清关中"),
		CLEARANCE(40,"配送中"),TRANSPORT_I(50,"结算中"), SETTLEMENT(60,"已结算"),COMPLETE(70,"已完成");

		private String name;
		private int value;

		private ServiceStatus(int value, String name) {
			this.name = name;
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String getName(int value) {
			for (ServiceStatus c : ServiceStatus.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}

	/**
	 * 单号名称
	 * 
	 * @byTable t_sequencenumbers
	 */
	public enum OddNumbersName {
		/**
		 * 贸易服务订单
		 */
		TRADINGORDERNO("t_trading_order_no_",""),
		/**
		 * 账单
		 */
		CUSTOMERBILL("customer_bill_no_",""),
		/**
		 * 收款
		 */
		RECEIPT("receipt_no_",""),
		/**
		 * 付款申请
		 */
		PAYMENT("payment_no_",""),
		/**
		 * 协议号
		 */
		AGREEMENT("agreement_no_",""),
		/**
		 * 订单
		 */
		ORDER("order_no_","I")
		;

		private String value;
		/**
		 * 单号开头字母
		 */
		private String startValue;

		private OddNumbersName(String value,String startValue) {
			this.value = value;
			this.startValue = startValue;
		}

		public String getValue() {
			return value;
		}
		public String getStartValue() {
			return startValue;
		}
	}
	
	/**
	 * 服务类型
	 *
	 */
	public enum ServiceType {
		/**
		 * 贸易货款
		 */
		TRADE_PAYMENT(1,"贸易货款"),
		/**
		 * 贸易代理
		 */
		TRADE_AGENT(2,"贸易代理"),
		/**
		 * 进口清关
		 */
		IMPORT_CLEARANCE(3,"进口清关"),
		/**
		 * 送货
		 */
		DELIVER_GOODS(4,"送货"),
		/**
		 * 仓储
		 */
		STORAGE(5,"仓储"),
		/**
		 * 垫付进口税费
		 */
		ADVANCE_TAXES_AND_FEES(6,"垫付进口税费"),
		/**
		 * 货押融资
		 */
		FREIGHT_FINANCING(7,"货押融资");

		private Integer value;
		private String name;

		private ServiceType(Integer value,String  name) {
			this.name = name;
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		/**
		 * 根据订单选择服务判断执行信息
		 */
		public static List<Integer> getServerTypeIdsByAgent(Integer importAgent, Boolean warehouseAgent,
				Boolean deliveryAgent,Boolean cargoMortgageFinancingAgent,Boolean payimporttaxagent){
			List<Integer> serverTypeList = new ArrayList<>();
			if(importAgent!=null&&importAgent == 1){
				serverTypeList.add(TRADE_AGENT.getValue());
				serverTypeList.add(IMPORT_CLEARANCE.getValue());
			}
			else if(importAgent!=null&&importAgent == 2)
				serverTypeList.add(IMPORT_CLEARANCE.getValue());
			if(warehouseAgent!=null&&warehouseAgent)
				serverTypeList.add(STORAGE.getValue());
			if(deliveryAgent!=null&&deliveryAgent)
				serverTypeList.add(DELIVER_GOODS.getValue());
			if(cargoMortgageFinancingAgent!=null&&cargoMortgageFinancingAgent)
				serverTypeList.add(FREIGHT_FINANCING.getValue());
			if(payimporttaxagent!=null&&payimporttaxagent)
				serverTypeList.add(ADVANCE_TAXES_AND_FEES.getValue());
			return serverTypeList;
		}
		public static String getName(Integer value) {
			for (ServiceType c : ServiceType.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}
	
	/**
	 * 应收账单状态
	 * 
	 * 0待审,1确认,2核销
	 * 
	 * @author wuhongxiang
	 *
	 */
	public enum CustomerBillStatus{
		/**
		 * 待审
		 */
		NOT_CONFIRM(1, "待审"),
		/**
		 * 确认
		 */
		CONFIRM(2, "确认"),
		/**
		 * 核销
		 */
		WRITE_OFF(3,"核销");
		
		private String name;
		private int value;

		private CustomerBillStatus(int value, String name) {
			this.name = name;
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String getName(int value) {
			for (CustomerBillStatus c : CustomerBillStatus.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}
	
	/**
	 * 付款申请状态
	 * 
	 * 1、草稿；2、审核；3、待付；4、财审；5、已付
	 * 
	 * @author wuhongxiang
	 *
	 */
	public enum PaymentStatus{
		/**
		 * 草稿
		 */
		NONPAYMENT(0, "未出"),
		/**
		 * 草稿
		 */
		DRAFT(1, "草稿"),
		/**
		 * 审核
		 */
		VALID(2, "审核"),
		/**
		 * 待付
		 */
		WAITTING_PAY(3, "待付"),
		/**
		 * 财审
		 */
		FINANCIAL_VALID(4,"财审"),
		/**
		 * 已付
		 */
		PAID(5,"已付");
		
		private String name;
		private int value;

		private PaymentStatus(int value, String name) {
			this.name = name;
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String getName(int value) {
			for (CustomerBillStatus c : CustomerBillStatus.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}
	/**
	 * 付款类型
	 * @author Administrator
	 *付款类型:1、货款;2、关税;3、费用;4、其他
	 */
	public enum PaymentType{
		PAYMENTfORGOODS(1,"货款"),TARIFF(2,"关税"),COST(3,"费用"),OTHER(4,"其他");
		private int value;
		private String name;
		
		public int getValue() {
			return value;
		}
		public String getName() {
			return name;
		}
		private PaymentType(int value, String name) {
			this.value = value;
			this.name = name;
		}
	}
	public enum WorkStatus{
		/**
		 * 计划
		 */
		PLAN(1, "计划"),
		/**
		 * 执行
		 */
		EXECUTE(2, "执行"),
		/**
		 * 完成
		 */
		ENTER(3, "完成"),
		/**
		 * 忽略
		 */
		DISABLE(4,"忽略"),
		;
		private String name;
		private int value;
		private WorkStatus(int value, String name) {
			this.name = name;
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public String getName() {
			return name;
		}
		public static String getName(int value) {
			for (CustomerBillStatus c : CustomerBillStatus.values()) {
				if (c.getValue() == value) {
					return c.name;
				}
			}
			return null;
		}
	}
}