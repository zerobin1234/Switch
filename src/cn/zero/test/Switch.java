package cn.zero.test;

import java.util.ArrayList;

public class Switch {
	
	private int interfaceCount;
	private ArrayList<String> ifaces;
	private ArrayList<String> desAddrs;

	
	public Switch(int interfaceCount) {
		this.interfaceCount = interfaceCount;
		ifaces = new ArrayList<String>();
		desAddrs = new ArrayList<String>();

	}
	
	//获取接口数
	public int getInterfaceCount() {
		return interfaceCount;
	}

	//自学习
	private void Learning(String srcAddr, String iface) {
		if(!this.desAddrs.contains(srcAddr)) {
			this.desAddrs.add(srcAddr);
			this.ifaces.add(iface);
			System.out.printf("学到MAC地址：%s，对应接口为：%s\n", srcAddr, iface);
		}
	}
	
	//查表
	private String Lookup(String desAddr, String srcIface) {
		if(this.desAddrs.contains(desAddr)) {
			String desIface = this.ifaces.get(this.desAddrs.indexOf(desAddr));
			if(srcIface.equals(desIface)) {
				return "同一接口，不通过交换机转发";
			}
			return "向" + desIface + "转发";
		}
		
		return "向所有接口转发";
	}
	
	//转发
	public String Forward(String srcAddr, String desAddr, String srcIface) {
		
		System.out.printf("源：%s, 目的：%s, 源接口：%s\n", srcAddr, desAddr, srcIface);
		Learning(srcAddr, srcIface);
		String result = Lookup(desAddr, srcIface);
		
		return result;
	}
	
}
