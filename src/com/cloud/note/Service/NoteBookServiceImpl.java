package com.cloud.note.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloud.note.dao.NoteBookDao;
import com.cloud.note.entity.NoteBook;
import com.cloud.note.entity.NoteResult;
import com.cloud.note.util.NoteUtil;

@Service
public class NoteBookServiceImpl implements NoteBookService {

	@Resource
	private NoteBookDao bookDao;
	
	
	@Override
	public NoteResult loadBooks(String userId) {
	      List<NoteBook> books=bookDao.findByUserId(userId);
	     
	      System.out.print("1111");
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setMsg("加载成功");
	      result.setData(books);
	      return result;
	}


	@Override
	public NoteResult addNoteBook(String bookName, String userid) {
		NoteResult result=new NoteResult();
		NoteBook book=new NoteBook();
		book.setCn_user_id(userid);
		book.setCn_notebook_name(bookName);
		String bookId=NoteUtil.createId();
		book.setCn_notebook_id(bookId);
		int typeId=new Random().nextInt(10);
		String typeId1=Integer.toString(typeId);
		book.setCn_notebook_type_id(typeId1);
		book.setCn_notebook_desc("书籍描述");
		Timestamp time=new Timestamp(System.currentTimeMillis());
		book.setCn_notebook_createtime(time);
		bookDao.InsertNoteBook(book);
		result.setStatus(0);
		result.setMsg("插入成功");
		result.setData(bookId);
		return result;
	}
       
}
