package com.cloud.note.entity;

import java.io.Serializable;

public class NoteResult implements Serializable {
/*
 * 实现序列化接口，可以将数据读写进硬盘或者磁盘中
 */
	private Object data;//数据
	private int status;//状态
	private String msg;//消息
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
