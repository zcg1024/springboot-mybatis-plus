package com.zcg.springboot_mybatis_plus.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * PROJECT_NAME: springboot-mybatis-plus
 * ClassName: Simple
 * Package: com.zcg.springboot_mybatis_plus.domain
 * Description:
 *
 * @Author CaigaoZhang
 * @Flag Effort, Struggle !
 * @Create 2025-04-22 22:50:45 星期二
 * @Version 1.0
 */
@Data
@TableName(value = "\"t_simple\"")  // H2 需要双引号
public class Simple {
    private Long id;
    private String username;
    private String password;
    private String email;
}
