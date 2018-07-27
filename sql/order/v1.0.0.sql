-- ----------------------------
-- Table structure for my_order
-- ----------------------------
DROP TABLE IF EXISTS `my_order`;
CREATE TABLE `my_order` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `order_code` varchar(20) DEFAULT '' COMMENT '订单编码',
  `user_id` int(11) DEFAULT '0' COMMENT '用户编号',
  `order_status` tinyint(2) DEFAULT '0' COMMENT '订单状态(10-创建)',
  `order_channel` tinyint(2) DEFAULT '0' COMMENT '订单渠道(10-B2B、20-中行、30-工行)',
  `order_type` tinyint(2) DEFAULT '0' COMMENT '订单类型(10-商品、20-预售、30-拼团、90-退换货)',
  `total_amount` int(11) DEFAULT '0' COMMENT '订单总金额',
  `expired_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '失效时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Table structure for my_order_item
-- ----------------------------
DROP TABLE IF EXISTS `my_order_item`;
CREATE TABLE `my_order_item` (
  `id` bigint(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `order_code` varchar(20) DEFAULT '' COMMENT '订单编号',
  `item_code` varchar(4) DEFAULT '' COMMENT '项目编码',
  `goods_code` varchar(12) DEFAULT '' COMMENT '商品编码',
  `goods_name` varchar(64) DEFAULT '' COMMENT '商品名称',
  `goods_type` tinyint(2) DEFAULT '0' COMMENT '商品类型',
  `order_nbr` int(11) DEFAULT '0' COMMENT '下单数量',
  `unit_price` int(11) DEFAULT '0' COMMENT '单价',
  `discount_amount` int(11) DEFAULT '0' COMMENT '优惠金额',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

-- ----------------------------
-- Table structure for my_order_pay
-- ----------------------------
DROP TABLE IF EXISTS `my_order_pay`;
CREATE TABLE `my_order_pay` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `order_code` varchar(20) DEFAULT '' COMMENT '订单编码',
  `pay_model` tinyint(2) DEFAULT '0' COMMENT '支付方式(10-在线支付、20-积分支付、30-授信支付)',
  `pay_amount` int(11) DEFAULT '0' COMMENT '支付金额',
  `pay_channel` varchar(10) DEFAULT '' COMMENT '支付渠道(Weixin-微信,Alipay-阿里)',
  `pay_flow_code` varchar(20) DEFAULT '' COMMENT '支付流水号',
  `pay_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '支付时间',
  `pay_aspect` tinyint(2) DEFAULT '0' COMMENT '支付方向(10-正向、20-逆向)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单支付表';
