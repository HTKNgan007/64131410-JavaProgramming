package Interface;

public class Cat implements IAnimal{
		private String catelogy;
		private boolean gender;
		public Cat(String catelogy, boolean gender) {
			super();
			this.catelogy = catelogy;
			this.gender = gender;
		}
		@Override
		public void sound() {
			// TODO Auto-generated method stub
			System.out.println("Meo Meo");
		}
		@Override
		public String toString() {
			return "Cat [catelogy=" + catelogy + ", gender=" + gender + "]";
		}
		

}
