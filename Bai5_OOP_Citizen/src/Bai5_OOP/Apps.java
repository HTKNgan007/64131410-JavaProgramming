package Bai5_OOP;

public class Apps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Citizen c1 = new Citizen();
		c1.setId("01");
		c1.setName("Ngan");
		c1.setGenner("female");
		c1.setNation("VietNam");
		c1.setYear((short)2000);
		System.out.println(c1.toString());
		Citizen c2 = new Citizen("02", "Tom", (short)2001, "male", "UK");
		System.out.println(c2.toString());
	}
}
