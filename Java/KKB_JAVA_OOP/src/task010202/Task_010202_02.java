package task010202;

public class Task_010202_02 {

	public static void main(String[] args) {
		Stu s1 = new Stu();
		Stu s2 = new Stu();
		Stu s3 = new Stu();
		
		s1.setName("n1");
		s2.setName("n2");
		s3.setName("n3");
		
		s1.setAge(18);
		s2.setAge(17);
		s3.setAge(16);
		
		s1.show();
		s2.show();
		s3.show();
	}

}

class Stu{
	private String name;
	private String gender;
	private int age;
	private String hobby;
	private static String company = "KKB";
	private static String course = "JAVA";
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public static String getCompany() {
		return company;
	}
	
	public static void setCompany(String company) {
		System.out.println("Sorry!Cannot set the company!");
	}
	
	public static String getCourse() {
		return course;
	}
	
	public static void setCourse(String course) {
		System.out.println("Sorry!Cannot set the course!");
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public void show() {
		
		System.out.println("Company:"+company);
		System.out.println("Course:"+course);
		System.out.println("Name:"+name);
		System.out.println("Age:"+age);
		System.out.println("Gender:"+gender);
		System.out.println("Hobby:"+hobby);
		System.out.println();
		
	}

}
