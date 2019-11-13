package cn.zero.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Ethereal {

	//定义一个交换机，3个接口
	static Switch switch1 = new Switch(3);
	
	//加载文件的内容
	public static String LoadFile(String filePath) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(filePath));
		StringBuffer strbuf = new StringBuffer();
		
		String str;
		while((str = in.readLine()) != null) {
			strbuf.append(str);
		}
		in.close();
		
		return strbuf.toString();
	}
	
	//将文件的内容解析成一帧一帧
	public static ArrayList<String> ParseFileToFrames(String fileContent) {
		
		String[] strs = fileContent.split("10101011");
		ArrayList<String> frames = new ArrayList<String>();
		for(String temp : strs) {
			if(!temp.isEmpty()) {
				frames.add(temp);
			}
		}
		return frames;
	}
	
	//发送一个帧给交换机
	public static String SendFrame(Switch mySwitch, String frame, String srcIface) {
		
		Frame a = new Frame(frame);
		String result = mySwitch.Forward(a.getSrcAddr(), a.getDesAddr(), srcIface);
		
		return result;
	}
	
	//模拟数据链路层对网络上的帧进行处理
	public static void EtherealHandle(ArrayList<String> frames1, ArrayList<String> frames2) {
		
		Random rd = new Random();
		for(int i = 0; i < frames1.size() || i < frames2.size(); i++) {
			if(i < frames1.size()) {
				int id = rd.nextInt(switch1.getInterfaceCount());
				String result = SendFrame(switch1, frames1.get(i), "接口" + id);
				System.out.println(result);
				System.out.println("-------------------------------------------------");
			}
			if(i < frames2.size()) {
				int id = rd.nextInt(switch1.getInterfaceCount());
				String result = SendFrame(switch1, frames2.get(i), "接口" + id);
				System.out.println(result);
				System.out.println("-------------------------------------------------");
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		String fileContent1 = LoadFile("C:\\Users\\ASUS\\Desktop\\1.txt");
		ArrayList<String> frames1 = ParseFileToFrames(fileContent1);
		String fileContent2 = LoadFile("C:\\Users\\ASUS\\Desktop\\2.txt");
		ArrayList<String> frames2 = ParseFileToFrames(fileContent2);
		EtherealHandle(frames1, frames2);
	}

}
