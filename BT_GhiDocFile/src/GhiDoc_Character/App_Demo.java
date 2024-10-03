package GhiDoc_Character;

import java.io.FileWriter;
import java.io.IOException;

public class App_Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//tao file van ban, ghi vao
		FileWriter fw;
		fw = new FileWriter("songque.txt");
		fw.write("Song que nuoc chay doi bo...\n");
		fw.write("De anh 9 dai 10 kho thuong em...");
		
		fw.flush();
		fw.close();
		
	}

}
