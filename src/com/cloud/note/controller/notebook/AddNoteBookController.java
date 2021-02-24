package com.cloud.note.controller.notebook;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.NoteBookService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/notebook")
public class AddNoteBookController {
   @Resource
	private NoteBookService noteBookService;
@RequestMapping("/addNoteBook.do")
@ResponseBody
public NoteResult execute(String bookName,String userId) {
	NoteResult result=noteBookService.addNoteBook(bookName, userId);
	return result;
}
}
