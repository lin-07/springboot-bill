package com.lq.springboot.entities;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 * @Title: Provider
 * @Description: com.mengxuegu.springboot.entities
 * @Auther: www.mengxuegu.com
 * @Version: 1.0
 */
@Data
public class User {

    private Integer id;
    //用户名
	private String username;
    //真实姓名
    private String realName;
    //用户密码
    private String password;
    //性别：1 女  2 男
    private Integer gender;
    //生日
    private Date birthday;
    //1管理员  2经理  3普通用户
    private Integer userType;
}
