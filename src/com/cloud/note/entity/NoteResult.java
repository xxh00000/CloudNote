package com.cloud.note.entity;

import java.io.Serializable;

public class NoteResult implements Serializable {
/*
 * ʵ�����л��ӿڣ����Խ����ݶ�д��Ӳ�̻��ߴ�����
 */
	private Object data;//����
	private int status;//״̬
	private String msg;//��Ϣ
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "NoteResult [data=" + data + ", status=" + status + ", msg=" + msg + "]";
	}
	
}
