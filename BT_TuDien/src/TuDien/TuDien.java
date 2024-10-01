package TuDien;

import java.util.HashMap;
import java.util.Scanner;

public class TuDien {
	public static void main() {
		HashMap<String, String>  tudien = new HashMap<String, String>();
		tudien.put("hello", "Xin chào");
		tudien.put("apple", "quả táo");
		tudien.put("dog", "Con chó");
		tudien.put("cat", "Con mèo");
		Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap tu tieng anh ");
        String tuTA = scanner.nextLine().toLowerCase(); 

        String tuTV = tudien.get(tuTA);

        if (tuTV != null) {
            System.out.println("Nghia cua \"" + tuTA + "\" là: " + tuTV);
        } else {
            System.out.println("khong ton tai");
        }

        scanner.close();
	}
}
