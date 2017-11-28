package demo;

public class Constructor {
	
	int i;
	String name;
	
	void display() {
		System.out.println(i+ " " + name);
	}
	public static void main(String args[]) {
		Constructor s1 = new Constructor();
		s1.display();
	}

}
