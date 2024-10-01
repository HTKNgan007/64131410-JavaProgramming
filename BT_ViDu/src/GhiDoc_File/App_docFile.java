package GhiDoc_File;

import java.io.FileInputStream;
import java.io.IOException;

public class App_docFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
			FileInputStream fin = null;
			fin = new FileInputStream("num.clc");
			int byteRead;
			while(true){
				byteRead = fin.read();
				if(byteRead == -1) break;
				System.out.println(byteRead);
				System.out.println(" ");
			}
			System.out.println("Done!!");

	}

}
