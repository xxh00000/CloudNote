package com.cloud.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.NoteService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/note")
public class AddNoteController {
	@Resource
    private NoteService service;
   @RequestMapping("/addNote.do")
   @ResponseBody
    public NoteResult addNote(String noteName,String bookId,String userId)
    {
	   NoteResult result=service.addNote(noteName, bookId, userId);
	   return result;
    }
}
