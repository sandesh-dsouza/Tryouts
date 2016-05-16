package com.marshmc.common.services.xml.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlRootElement(name ="token")
public class Token implements Serializable{

	private String key;

	@XmlElement
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Token(String key) {
		super();
		this.key = key;
	}

	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
