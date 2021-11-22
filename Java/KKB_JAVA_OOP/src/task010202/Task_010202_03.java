package task010202;

public class Task_010202_03 {

	public static void main(String[] args) {
		
		Cloth c1 = new Cloth();
		Cloth c2 = new Cloth();
		Cloth c3 = new Cloth();

		System.out.println(c1.getNumber());
		System.out.println(c2.getNumber());
		System.out.println(c3.getNumber());
	}

}

class Cloth{
	private int id;
	public static int num=1000;
	
	public Cloth() {
		id = num;
		num++;		
	}
	
	public int getNumber() {
		return id;
	}
}