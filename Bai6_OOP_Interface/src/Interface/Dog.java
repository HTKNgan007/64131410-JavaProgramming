package Interface;

public class Dog implements IAnimal{
		private String catelogy;
		private boolean gender;
		public Dog(String catelogy, boolean gender) {
			super();
			this.catelogy = catelogy;
			this.gender = gender;
		}
		@Override
		public void sound() {
			// TODO Auto-generated method stub
			System.out.println("Gâu Gâu");
		}
		@Override
		public String toString() {
			return "Dog [catelogy=" + catelogy + ", gender=" + gender + "]";
		}
		

}
