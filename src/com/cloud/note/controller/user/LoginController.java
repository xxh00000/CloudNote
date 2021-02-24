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
public class LoginController {
	@Resource
	private UserService service;
	 @RequestMapping("/login.do")
	   @ResponseBody
	   public NoteResult execute(String name ,String password) throws NoSuchAlgorithmException
	   {
		  NoteResult result=service.checkLogin(name, password);
		  return result;
	   }
}
