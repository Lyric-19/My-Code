package task010201;

public class GameTask {

	public static void main(String[] args) {
		
		Game game1 = new Game("Human Fall Flat","action","1G","5","A interesting 3D game!");
		game1.show();
	}
	

}

class Game {

	String name;
	String type;
	String size;
	String level;
	String desc;
	
	Game(String n,String t,String s,String l,String d){
		name = n;
		type = t;
		size = s;
		level = l;
		desc = d;
	}
	
	void show() {
		System.out.println("The name of game:"+name);
		System.out.println("The type of game:"+type);
		System.out.println("The size of game:"+size);
		System.out.println("The level of game:"+level);
		System.out.println("The describe of game:"+desc);
	}
	

}

