package GhiDoc_Character;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App_BufferRd {
	public static void main(String[] args) throws IOException {
		FileReader fReader = new FileReader("songque.txt");
		BufferedReader buffR = new BufferedReader(fReader);
		
		String dong1 =buffR.readLine();
		
		System.out.println(dong1);
		
	}
}
