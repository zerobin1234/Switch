package cn.zero.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Frame {

	private String frame;
	private String desAddr;
	private String srcAddr;
	private String netType;
	private String data;
	private String checkSequence;
	
	public Frame(String frame) {
		this.frame = frame;
		String[] strs = this.frame.split("\t");
		this.desAddr = strs[1];
		this.srcAddr = strs[2];
		this.netType = strs[3];
		this.data = strs[4];
		this.checkSequence = strs[5];
	}
	
	public String getDesAddr() {
		return desAddr;
	}

	public String getSrcAddr() {
		return srcAddr;
	}

	public String getNetType() {
		return netType;
	}

	public String getData() {
		return data;
	}

	public String getCheckSequence() {
		return checkSequence;
	}

}
