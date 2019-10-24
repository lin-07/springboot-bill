package com.lq.springboot.entities;

import lombok.Data;

import java.util.Date;

/**
 * 帐单实体类
 * @Title: Provider
 * @Description: com.mengxuegu.springboot.entities
 * @Auther: www.mengxuegu.com
 * @Version: 1.0
 */
@Data
public class Bill {

    private Integer bid;
    // 账单编码
    private String billCode;
    // 商品名称
    private String billName;
    // 商品单位
    private String billCom;
    // 商品数量
    private Integer billNum;
    // 总金额
    private Double money;
    // 供应商
    private Integer pid;
    // 是否付款 0 未付款， 1已付款
    private Integer pay;
    // 创建时间
    private Date createDate;
}
