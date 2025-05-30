package com.zcg.springboot_mybatis_plus;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.zcg.springboot_mybatis_plus.domain.Simple;
import com.zcg.springboot_mybatis_plus.domain.User;
import com.zcg.springboot_mybatis_plus.mapper.SimpleMapper;
import com.zcg.springboot_mybatis_plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private SimpleMapper simpleMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		Assert.isTrue(5 == userList.size(), "");
		userList.forEach(System.out::println);
		System.out.println("========================================");
		List<Simple> simpleList = simpleMapper.selectList(null);
		Assert.isTrue(5 == simpleList.size(), "");
		simpleList.forEach(System.out::println);
	}

}
