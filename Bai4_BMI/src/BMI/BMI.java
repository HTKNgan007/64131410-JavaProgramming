package BMI;
import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	float chieuCao, canNang, BMI ;
	Scanner banPhim = new Scanner(System.in);
		System.out.print("Nhap chieu cao(m): ");
		chieuCao = banPhim.nextFloat();	
	while (chieuCao > 2.5 || chieuCao < 0.3) {
		System.out.print("Nhap lai chieu cao(m): ");
		chieuCao = banPhim.nextFloat();
	}	
		System.out.print("Nhap can nang(kg): ");
		canNang = banPhim.nextFloat();		
	while (canNang > 200 || canNang < 1.3) {
		System.out.print("Nhap lai can nang(kg): ");
		canNang = banPhim.nextFloat();
	}
		BMI = canNang / (chieuCao * chieuCao);
		if (BMI < 18.5) {
	         System.out.println("Thieu can");
	      } else if (BMI < 24.9) {
			System.out.print("Binh thuong");
		} else if (BMI < 29.9) {
			System.out.print("Thua can");
		} else if (BMI > 30) {
			System.out.print("Beo Phi");
		}
	}

}
