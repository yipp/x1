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
	private byte[] DATA;


	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public byte[] getDATA() {
		return DATA;
	}

	public void setDATA(byte[] DATA) {
		this.DATA = DATA;
	}

	public short getDataLength(){
		if(DATA != null){
			return (short) DATA.length;
		}
		return 0;
	}
}
