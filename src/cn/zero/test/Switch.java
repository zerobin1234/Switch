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
	
	//��ȡ�ӿ���
	public int getInterfaceCount() {
		return interfaceCount;
	}

	//��ѧϰ
	private void Learning(String srcAddr, String iface) {
		if(!this.desAddrs.contains(srcAddr)) {
			this.desAddrs.add(srcAddr);
			this.ifaces.add(iface);
			System.out.printf("ѧ��MAC��ַ��%s����Ӧ�ӿ�Ϊ��%s\n", srcAddr, iface);
		}
	}
	
	//���
	private String Lookup(String desAddr, String srcIface) {
		if(this.desAddrs.contains(desAddr)) {
			String desIface = this.ifaces.get(this.desAddrs.indexOf(desAddr));
			if(srcIface.equals(desIface)) {
				return "ͬһ�ӿڣ���ͨ��������ת��";
			}
			return "��" + desIface + "ת��";
		}
		
		return "�����нӿ�ת��";
	}
	
	//ת��
	public String Forward(String srcAddr, String desAddr, String srcIface) {
		
		System.out.printf("Դ��%s, Ŀ�ģ�%s, Դ�ӿڣ�%s\n", srcAddr, desAddr, srcIface);
		Learning(srcAddr, srcIface);
		String result = Lookup(desAddr, srcIface);
		
		return result;
	}
	
}
