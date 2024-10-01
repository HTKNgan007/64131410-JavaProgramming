package GhiDoc_Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class App {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("https://ntu.edu.vn/default.aspx");
		//Gui yeu cau ket noi
		URLConnection connection = url.openConnection();
		
		InputStream in = connection.getInputStream();
		
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(ir);
		String line;
		while(true){
			line = bufferedReader.readLine();
			if(line == null) break;
			System.out.println(line);
		}
		
	}
}
