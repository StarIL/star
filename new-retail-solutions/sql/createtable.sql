#BS_用户表
DROP TABLE IF EXISTS `bs_user`;
CREATE TABLE `bs_user` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `nickname` varchar(50) COMMENT '昵称',
  `portrait` varchar(200) DEFAULT '' COMMENT '头像',
  `gender` bit(1) DEFAULT b'0' COMMENT '性别',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `password` varchar(100) DEFAULT NULL COMMENT '加密后的密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `verify_mobile` bit(1) DEFAULT b'0' COMMENT '手机号是否验证',
  `verify_email` bit(1) DEFAULT b'0' COMMENT '邮箱是否认证',
  `user_type` int(1) DEFAULT '1' COMMENT '类型：1、商户管理;2、员工;3、系统管理',
  `team_id` varchar(24) DEFAULT '1' COMMENT '团队id',
  `create_from` int(1) DEFAULT NULL COMMENT '创号方式：1、注册;2、新增员工;3、管理员维护',
  `create_user` varchar(50) DEFAULT NULL COMMENT '推荐人用户名',
  `create_time` datetime COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `is_del` bit(1) DEFAULT b'0' COMMENT '删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BS_用户';

#BS_团队(商家)表
DROP TABLE IF EXISTS `bs_team`;
CREATE TABLE `bs_team` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `cn_name` varchar(200) DEFAULT NULL COMMENT '中文名称',
  `portrait` varchar(200) DEFAULT '' COMMENT '头像',
  `province_id` int(11) DEFAULT '0' COMMENT '省ID',
  `province_name` varchar(30) DEFAULT NULL COMMENT '省名（冗余）',
  `city_id` int(11) DEFAULT '0' COMMENT '市ID',
  `city_name` varchar(40) DEFAULT NULL COMMENT '市名（冗余）',
  `county_id` int(11) DEFAULT '0' COMMENT '区ID',
  `county_name` varchar(60) DEFAULT NULL COMMENT '区县名（冗余）',
  `cn_address` varchar(200) DEFAULT NULL COMMENT '地址',
  `phone` varchar(20) DEFAULT NULL COMMENT '座机',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `approve_status` bit(1) DEFAULT b'0' COMMENT '是否认证',
  `approve_time` datetime DEFAULT NULL COMMENT '认证时间',
  `license_name` varchar(50) DEFAULT NULL COMMENT '营业执照名称',
  `license_url` varchar(200) DEFAULT '' COMMENT '营业执照',
  `user_id` varchar(20) DEFAULT NULL COMMENT '用户id',
  `is_sys` bit(1) DEFAULT NULL COMMENT '是否管理',
  `reg_date` date DEFAULT NULL COMMENT '收费注册日期',
  `valid_month` int(5) DEFAULT NULL COMMENT '收费激活月数',
  `valid_month_surplus` int(5) DEFAULT NULL COMMENT '收费剩余月数',
  `valid` int(1) DEFAULT b'1' COMMENT '生效：0、临时;1、免费;2、收费;',
  `create_time` datetime COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `is_del` bit(1) DEFAULT b'0' COMMENT '删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BS_客户';

#BS_商品
DROP TABLE IF EXISTS `bs_good`;
CREATE TABLE `bs_good` (
  `id` varchar(24) NOT NULL DEFAULT '' COMMENT 'id',
  `goodname` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `category_id` int(11) DEFAULT NULL COMMENT '分类id',
  `pic_url` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `valid` bit(1) DEFAULT b'1' COMMENT '生效(作废)',
  `team_id` varchar(20) DEFAULT NULL COMMENT '团队id',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(24) DEFAULT NULL COMMENT '创建用户',
  `create_time` datetime COMMENT '创建时间',
  `upt_user` varchar(20) DEFAULT NULL COMMENT '修改用户',
  `upt_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(1) DEFAULT '0' COMMENT '状态：0、草稿；1、生效；2、作废',
  `is_del` bit(1) DEFAULT b'0' COMMENT '删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BS_商品';

#BS_商品规格
DROP TABLE IF EXISTS `bs_good_spec`;
CREATE TABLE `bs_good_spec` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `good_id` varchar(24) DEFAULT NULL COMMENT '商品ID',
  `spec_name` varchar(100) DEFAULT NULL COMMENT '规格',
  `valid` bit(1) DEFAULT b'1' COMMENT '生效',
  `is_del` bit(1) DEFAULT b'0' COMMENT '删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BS_商品规格';


#BS_供应商
DROP TABLE IF EXISTS `bs_supplier`;
CREATE TABLE `bs_supplier` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `cn_name` varchar(200) DEFAULT NULL COMMENT '中文名称',
  `province_id` int(11) DEFAULT '0' COMMENT '省ID',
  `province_name` varchar(30) DEFAULT NULL COMMENT '省名（冗余）',
  `city_id` int(11) DEFAULT '0' COMMENT '市ID',
  `city_name` varchar(40) DEFAULT NULL COMMENT '市名（冗余）',
  `county_id` int(11) DEFAULT '0' COMMENT '区ID',
  `county_name` varchar(60) DEFAULT NULL COMMENT '区县名（冗余）',
  `cn_address` varchar(200) DEFAULT NULL COMMENT '地址',
  `phone` varchar(20) DEFAULT NULL COMMENT '座机',
  `wechat` varchar(20) DEFAULT NULL COMMENT '微信',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `team_id` varchar(20) DEFAULT NULL COMMENT '团队id',
  `valid` bit(1) DEFAULT b'1' COMMENT '生效',
  `create_time` datetime COMMENT '创建时间',
  `is_del` bit(1) DEFAULT b'0' COMMENT '删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BS_供应商';

#AC_平台缴费表
DROP TABLE IF EXISTS `ac_team_account`;
CREATE TABLE `ac_team_account` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `team_id` varchar(24) NOT NULL COMMENT '团队ID',
  `capital` decimal(18,2) DEFAULT '0.00' COMMENT '缴费余额',
  `month` int(11) DEFAULT '0.00' COMMENT '缴费月数',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime COMMENT '创建时间',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='AC_平台缴费表';

#AC_团队账户
DROP TABLE IF EXISTS `ac_team_account`;
CREATE TABLE `ac_team_account` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `team_id` varchar(24) NOT NULL COMMENT '团队ID',
  `capital` decimal(18,2) DEFAULT '0.00' COMMENT '资金余额',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime COMMENT '创建时间',  
  `upt_user` varchar(20) DEFAULT NULL COMMENT '修改用户',
  `upt_time` datetime DEFAULT NULL COMMENT '修改时间',
  `valid` bit(1) DEFAULT b'1' COMMENT '有效',
  `is_del` bit(1) DEFAULT b'0' COMMENT '删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='AC_团队账户';

#AC_团队账户出入金
DROP TABLE IF EXISTS `ac_team_account_bill`;
CREATE TABLE `ac_team_account_bill` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `team_id` varchar(24) NOT NULL COMMENT '团队ID', 
  `account_id` varchar(24) NOT NULL COMMENT 'id', 
  `bill_type` int(1) DEFAULT '1' COMMENT '出/入金:1、入金；2、出金；3、余额变更',
  `amount` decimal(18,2) DEFAULT NULL COMMENT '金额,出金为负',
  `come_bill_id` varchar(24) DEFAULT NULL COMMENT '来源单据ID',
  `come_bill_type` int(1) DEFAULT '1' DEFAULT NULL COMMENT '来源单据类型:1、入库；2、销货',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime COMMENT '创建时间',  
  `valid` bit(1) DEFAULT b'1' COMMENT '有效',
  `is_del` bit(1) DEFAULT b'0' COMMENT '删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='AC_团队账户出入金';


#GD_商品存量
DROP TABLE IF EXISTS `gd_good_storage`;
CREATE TABLE `gd_good_storage` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `good_id` varchar(24) NOT NULL COMMENT '商品id', 
  `amount` decimal(18,2) DEFAULT NULL COMMENT '数量',
  `valid` bit(1) DEFAULT b'1' COMMENT '有效',
  `is_del` bit(1) DEFAULT b'0' COMMENT '删除',
  `upt_user` varchar(20) DEFAULT NULL COMMENT '修改用户',
  `upt_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='GD_商品存量';

#GD_商品入库
DROP TABLE IF EXISTS `gd_good_storage_add`;
CREATE TABLE `gd_good_storage_add` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `good_id` varchar(24) NOT NULL COMMENT '商品id', 
  `good_storage_id` varchar(24) NOT NULL COMMENT '商品存量id', 
  `amount` decimal(18,2) DEFAULT NULL COMMENT '数量',
  `sale_price` decimal(18,2) DEFAULT NULL COMMENT '进价',
  `total_price` decimal(18,2) DEFAULT NULL COMMENT '总价',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime COMMENT '创建时间',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='GD_商品入库';

#GD_销售主表
DROP TABLE IF EXISTS `gd_sale_good`;
CREATE TABLE `gd_sale_good` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `user_id` varchar(24) NOT NULL COMMENT '商品id', 
  `team_id` varchar(24) NOT NULL COMMENT '商家id', 
  `sale_total_price` decimal(18,2) DEFAULT NULL COMMENT '总价',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime COMMENT '创建时间',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='GD_销售主表';


#GD_销售主表详表
DROP TABLE IF EXISTS `gd_sale_good_item`;
CREATE TABLE `gd_sale_good_item` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `sale_id` varchar(24) NOT NULL COMMENT '销售主表id',
  `good_id` varchar(24) NOT NULL COMMENT '商品id', 
  `good_storage_id` varchar(24) NOT NULL COMMENT '商品存量id', 
  `good_storage_add_id` varchar(24) NOT NULL COMMENT '商品入库id', 
  `amount` decimal(18,2) DEFAULT NULL COMMENT '数量',
  `sale_price` decimal(18,2) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(18,2) DEFAULT NULL COMMENT '总价',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='GD_销售主表详表';


#TM_团队(商家)会员
DROP TABLE IF EXISTS `tm_team_member`;
CREATE TABLE `tm_team_member` (
  `id` varchar(24) NOT NULL COMMENT 'id',
  `cn_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `reg_date` date DEFAULT NULL COMMENT '注册日期',
  `valid` bit(1) DEFAULT b'1' COMMENT '生效',
  `create_time` datetime COMMENT '创建时间',
  `last_loading_time` datetime DEFAULT NULL COMMENT '最后一次查询时间',
  `is_del` bit(1) DEFAULT b'0' COMMENT '删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TM_团队会员';