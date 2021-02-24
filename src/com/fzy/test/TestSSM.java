package com.fzy.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cloud.note.dao.UserDao;
import com.cloud.note.entity.User;

public class TestSSM {
	@Test
public void test01()
{
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=ac.getBean("userDao",UserDao.class);
//	List<User> users=dao.findAll();
	//User user=new User("1111","werw","2017481","454",null);
      //dao.save(user);
    int count=dao.selectCountByName("fzyxxh");
    System.out.println(count);

}
}
