package task010201;

public class EmployeeTask {

	public static void main(String[] args) {
		
		Employee user1 = new Employee("Lyric",1001,20000,0.15);
		System.out.println("user1's name:"+user1.getName());
		System.out.println("user1's number:"+user1.getNumber());
		System.out.println("user1's salary:"+user1.getSalary());
		System.out.println("user1's uprate:"+user1.getUprate());
		System.out.println("user1's final salary:"+user1.getFinal());
	}

}

class Employee{
	String name;
	int number;
	double salary;
	double uprate;
	
	Employee(String n,int m,double s,double u){
		name = n;
		
		number = m;
		salary = s;
		uprate = u;
	}
	
	String getName() {
		return name;
	}
	
	int getNumber() {
		return number;
	}
	
	double getSalary() {
		return salary;
	}

	double getUprate() {
		return uprate;
	}
	
	double getFinal() {
		
		return salary*(uprate+1);
	}
}
