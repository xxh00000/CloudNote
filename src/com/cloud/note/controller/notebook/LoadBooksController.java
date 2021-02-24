package com.cloud.note.controller.notebook;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.NoteBookService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/notebook")
public class LoadBooksController {
 
	@Resource
	private NoteBookService bookService;
	
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult execute(String userId) {
		NoteResult result=bookService.loadBooks(userId);
		return result;
		
	}
}
