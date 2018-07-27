-- ----------------------------
-- Table structure for my_goods
-- ----------------------------
DROP TABLE IF EXISTS `my_goods`;
CREATE TABLE `my_goods` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `code` varchar(12) NOT NULL DEFAULT '' COMMENT '商品编码',
  `name` varchar(64) DEFAULT '' COMMENT '商品名称',
  `type` tinyint(2) DEFAULT '0' COMMENT '商品类型(10-普通商品、20-促销商品)',
  `status` tinyint(1) DEFAULT '0' COMMENT '商品状态(0-上架、1-下架)',
  `spec` varchar(12) DEFAULT '' COMMENT '规格',
  `unit` varchar(6) DEFAULT '' COMMENT '单位',
  `origin` varchar(12) DEFAULT '' COMMENT '产地',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Table structure for my_goods_class
-- ----------------------------
DROP TABLE IF EXISTS `my_goods_class`;
CREATE TABLE `my_goods_class` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `code` varchar(6) NOT NULL DEFAULT '' COMMENT '分类编码',
  `name` varchar(32) DEFAULT '' COMMENT '分类名称',
  `level` tinyint(1) NOT NULL DEFAULT '0' COMMENT '分类级别',
  `p_code` varchar(8) DEFAULT '' COMMENT '父分类',
  `sort` tinyint(1) DEFAULT '0' COMMENT '顺序',
  `is_display_flg` bit(1) DEFAULT b'0' COMMENT '是否显示(0-不显示、1-显示)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类表';

-- ----------------------------
-- Table structure for my_goods_images
-- ----------------------------
DROP TABLE IF EXISTS `my_goods_images`;
CREATE TABLE `my_goods_images` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `goods_code` varchar(12) NOT NULL DEFAULT '' COMMENT '商品编码',
  `img_url` varchar(64) DEFAULT '' COMMENT '图片链接',
  `width` int(11) DEFAULT '0' COMMENT '宽度',
  `height` int(11) DEFAULT '0' COMMENT '高度',
  `type` varchar(12) DEFAULT '' COMMENT '图片类型(MAIN-主图、SMALL-分类小图、MIDDLE-首页中图、DETAIL-商品详情图)',
  `sort` tinyint(1) DEFAULT '0' COMMENT '顺序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- ----------------------------
-- Table structure for my_goods_inventory
-- ----------------------------
DROP TABLE IF EXISTS `my_goods_inventory`;
CREATE TABLE `my_goods_inventory` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `goods_code` varchar(12) NOT NULL DEFAULT '' COMMENT '商品编码',
  `goods_name` varchar(64) DEFAULT '' COMMENT '商品名称',
  `current_qty` int(11) DEFAULT '0' COMMENT '现货库存',
  `order_qty` int(11) DEFAULT '0' COMMENT '预占库存',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品库存表';

-- ----------------------------
-- Table structure for my_goods_price
-- ----------------------------
DROP TABLE IF EXISTS `my_goods_price`;
CREATE TABLE `my_goods_price` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `goods_code` varchar(12) NOT NULL DEFAULT '' COMMENT '商品编码',
  `normal_price` int(11) NOT NULL DEFAULT '0' COMMENT '正常售价',
  `cost_price` int(11) DEFAULT '0' COMMENT '成本价',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品价格表';
