package com.sl.automobile;

import com.sl.automobile.mapper.UserMapper;
import com.sl.automobile.pojo.UserTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
//		List<User> us = userMapper.findAll();
//		System.out.println(us);
//		UserTable byId = userMapper.findById(1);
//		System.out.println(byId);
//		UserTable aa = userMapper.findByName("vv");
//		System.out.println(aa);
//		UserTable aa = userMapper.findByUnameUpwd("aa", "123");
//		System.out.println(aa);

//		Mon Sep 16 17:38:38 CST 2019\
//		Date date = new Date();
//		UserTable user = new UserTable(0, "aaa", "1234", "man", null, "a.jpg", "lollol", 1, "jack","123567");
////		int i = userMapper.insertUser(user);
////		System.out.println(i);
//		int i = userMapper.updateByUser(user);
//		System.out.println(i);
//		int i1 = userMapper.deleteById(2);
//		System.out.println(i1);
		int aaa = userMapper.deleteByName("aaa");
		System.out.println(aaa);
	}

}
