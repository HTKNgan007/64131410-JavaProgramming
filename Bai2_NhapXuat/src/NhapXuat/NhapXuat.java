package NhapXuat;
import java.util.Scanner;

public class NhapXuat {
	public static void main(String[] args) {
		//Khai báo các biến
		int a, b, tong;
		Scanner banPhim = new Scanner(System.in);
		//Nhap du lieu
		System.out.println("Tinh tong 2 so nguyen: ");
		System.out.print("a=");
		//Nhap du lieu cho bien a tu ban phim
		a = banPhim.nextInt();
		//Nhap du lieu cho b 
		System.out.print("b=");
		//Nhap du lieu cho bien b tu ban phim
		b = banPhim.nextInt();
		//tong
		tong = a + b;
		//in tong ra 
		System.out.print("tong = " + tong); 
	}
}
