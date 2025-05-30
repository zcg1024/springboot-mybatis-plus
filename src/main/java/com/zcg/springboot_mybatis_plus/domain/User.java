package com.zcg.springboot_mybatis_plus.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * PROJECT_NAME: springboot-mybatis-plus
 * ClassName: User
 * Package: com.zcg.springboot_mybatis_plus.domain
 * Description:
 *
 * @Author CaigaoZhang
 * @Flag Effort, Struggle !
 * @Create 2025-04-22 13:51:43 星期二
 * @Version 1.0
 */
@Data
@TableName(value = "\"user\"")  // H2 需要双引号
//@TableName(value = "USER")      // 统一用大写
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private String email;
    private Boolean enabled;
    private String lang;
}