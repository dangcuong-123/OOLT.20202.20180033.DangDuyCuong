package hust.soict.hedspi.garbage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class GarbageCreator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String text_path = "/home/cuong/eclipse-workspace/AimsProject/text.txt";
		FileInputStream file = new FileInputStream(text_path);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(file));
		
		String s = "";
		long start =  System.currentTimeMillis();
		String line = buffer.readLine();
		while (line != null) {
			System.out.println(line);
			s += line;
			line = buffer.readLine();
		}
		System.out.println(System.currentTimeMillis() - start);
	}

}
