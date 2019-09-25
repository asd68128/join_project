package com.sl.automobile;

import com.sl.automobile.pojo.UserTable;
import com.sl.automobile.service.SendSmsService;
import com.sl.automobile.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CallerApplicationTests {

	@Autowired
	private SendSmsService sendSmsService;
	@Test
	public void contextLoads() {
		/*String s = sendSmsService.sendSms("18576019116");
		System.out.println("ok");*/


		boolean b = sendSmsService.checkSmsCode("18576019116", "860475");
		System.out.println(b);


	}

}
