package com.cloud.note.dao;

import java.util.List;

import com.cloud.note.entity.NoteBook;

public interface NoteBookDao {
        //�����û�ID��ѯ��ǰ�û��ıʼǱ�
	public List<NoteBook> findByUserId(String userId);
	//ӵ���û�ID,�ʼǱ�ID������ʱ�䣬�ʼǱ����ƣ��������ñʼǱ��Ĺ���
	public void InsertNoteBook(NoteBook book);
    //������ڵ�ʱ�䣬 TimeStamp time=new TimeStamp(System.currentTimeMillis());
	
}
