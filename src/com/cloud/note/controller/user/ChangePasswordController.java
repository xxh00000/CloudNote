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
public class ChangePasswordController {

	@Resource
	private UserService service;

	@RequestMapping("/changeUserPassword.do")
	@ResponseBody
	public NoteResult execute(String userId,String last_password,String new_password) throws NoSuchAlgorithmException
	{
		NoteResult result=service.changePassword(userId, last_password, new_password);
		return result;
	}
}
