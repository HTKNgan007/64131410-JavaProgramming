package OddEven;
import java.util.Scanner; 
public class OddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		Scanner banPhim = new Scanner(System.in);
		System.out.println("Enter an integer:");
		a = banPhim.nextInt();
		if (a % 2 == 0) {
	         System.out.println(a + " is even");
	      } else {
	         System.out.println(a + " is odd");
	      }
		System.out.println("bye");
	}

}
