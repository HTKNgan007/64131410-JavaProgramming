package GhiDoc_Character;

import java.io.FileReader;
import java.io.IOException;

public class App_DocFile {
	public static void main(String[] args) throws IOException {
		FileReader fReader = new FileReader("songque.txt");
		char buff[] = null;
		buff = new char[10];
		fReader.read(buff);
		fReader.close();
		for(int i = 0; i<10; i++) {
			System.out.print(buff[i]);
		}
		System.out.println("");
		System.out.println(String.valueOf(buff));
	}
}
