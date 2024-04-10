#todo
你的建表语句,包含索引


CREATE TABLE `orders`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT,
    `order_id`   varchar(100) DEFAULT NULL COMMENT '订单id',
    `buyer_id`   varchar(50)  DEFAULT NULL COMMENT '买家id',
    `seller_id`  varchar(50)  DEFAULT NULL COMMENT '卖家id',
    `order_time` datetime     DEFAULT NULL COMMENT '订单时间',
    PRIMARY KEY (`id`),
    KEY          `idx_order` (`order_id`),
    KEY          `idx_order_time` (`order_time`),
    KEY          `idx_buy_time` (`buyer_id`,`order_time`),
    KEY          `idx_sell_time` (`seller_id`,`order_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

表中还有其他订单数据
可以建其他两张表,单独记录  买家-订单表  buyer_orders
                        卖家-订单表  seller_orders
用于快速定位订单号 (表内索引 买/卖家和订单id 时间 联合索引)
同时可以按照 周/月 去分表
也可以将订单数据放入于 tidb  便于拓展


将订单数据放入数仓 es/clickHouse进行计算 得到排行榜


秒杀无锁设计:
可以用lua脚本来执行,redis单线程执行lua脚本不会被其他指令打断,所以具有原子性
商品记录库存
用户秒杀的时候 使用lua脚本  , 使用setnx来保证幂等

大致lua流程:
1.首先获取商品库存,如果无商品,则返回无库存
2.进行购买,库存减去购买数
3.用户购买后用setnx 记录 redisKey：product:userId  1 ,用于保障幂等
