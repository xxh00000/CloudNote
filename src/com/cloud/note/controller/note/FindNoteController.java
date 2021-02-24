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
public class FindNoteController {
@Resource
private NoteService service;
@RequestMapping("/findNote.do")
@ResponseBody
public NoteResult findNote(String noteId)
{
	NoteResult result=service.findNote(noteId);
   return result;
}

}
