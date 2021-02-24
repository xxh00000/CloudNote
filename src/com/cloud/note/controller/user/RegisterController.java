package com.cloud.note.controller.user;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.UserService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/user")
public class RegisterController {
	@Resource
	private UserService service;
	
   @RequestMapping("/register.do")//http://localhost:8081/SDAU_CloudNote/user/register.do
	@ResponseBody//将返回的内容转化为JSON
   public NoteResult execute(String name,String password,String nick) throws Exception
   {
	   NoteResult result=service.register(name,password,nick);
	return result;
	
    }
  
}
