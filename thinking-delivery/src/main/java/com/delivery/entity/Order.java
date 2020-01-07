package com.delivery.entity;

import java.util.Date;

public class Order {
	
	private Long id;
	private Long buid;//商家ID
	private Long muid;//会员ID
	private Double totalPrice; //总价
	private Date updateTime;
	private Date createTime;
}
