package org.x1.utils.net.model;

import org.springframework.stereotype.Component;

@Component
public class Request {
	/**
	 * id
	 */
	private short id;
	/**
	 * 数据
	 */
	private byte[] data;


	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public short getDataLength(){
		if(data != null){
			return (short) data.length;
		}
		return 0;
	}
}
