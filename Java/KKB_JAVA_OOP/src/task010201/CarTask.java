package task010201;

public class CarTask {
	
	public static void main(String[] args) {
		Car car1 = new Car("Benz","black");
		car1.show();
	}
}

class Car {
	
	String brand;
	String color;
	
	Car(String b,String c){
		brand = b;
		color = c;		
	}
	
	void show() {
		System.out.println("The brand of the car:"+brand);
		System.out.println("The color of the car:"+color);
	}

}

