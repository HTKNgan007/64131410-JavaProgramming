package BMI;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {
        float chieuCao, canNang, BMI;
        Scanner banPhim = new Scanner(System.in);
        
        //
        while (true) {
            try {
                System.out.print("Nhập chiều cao(m): ");
                chieuCao = banPhim.nextFloat();
                
                // Kiểm tra chiều cao hợp lệ
                if (chieuCao > 2.5 || chieuCao < 0.3) {
                    System.out.println("Chiều cao không hợp lệ, vui lòng nhập lại.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Nhập không đúng định dạng, vui lòng nhập lại.");
                banPhim.next();
            }
        }
        //
        while (true) {
            try {
                System.out.print("Nhập cân nặng(kg): ");
                canNang = banPhim.nextFloat();
                
                // Kiểm tra cân nặng hợp lệ
                if (canNang > 200 || canNang < 1.3) {
                    System.out.println("Cân nặng không hợp lệ, vui lòng nhập lại.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Nhập không đúng định dạng, vui lòng nhập lại.");
                banPhim.next();
            }
        }
        
        // Tính toán BMI
        BMI = canNang / (chieuCao * chieuCao);
        if (BMI < 18.5) {
            System.out.println("Thiếu cân");
        } else if (BMI < 24.9) {
            System.out.println("Bình thường");
        } else if (BMI < 29.9) {
            System.out.println("Thừa cân");
        } else {
            System.out.println("Béo phì");
        }
    }
}
