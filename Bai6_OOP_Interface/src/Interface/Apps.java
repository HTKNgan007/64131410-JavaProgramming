package Interface;

public class Apps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat m1 = new Cat("Muop", false);
		Dog c1 = new Dog("Mun", true);
		System.out.println(m1.toString());
		System.out.println(c1.toString());
		IAnimal m2 = new Cat("Muop", false);
		IAnimal c2 = new Dog("Mun", true);
		System.out.println(m2.toString());
		System.out.println(c2.toString());
	}

}
