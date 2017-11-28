package demo;

public class Paramconstruct {
	static int i= 10;
	static String city = "Coimbatore"; 
	
	Paramconstruct(int a,String area){
		i = a;
		city = area;
		
	}
	void display() {
		System.out.println(i + "" + city);
	}
	
	public static void main(String args[]){
		Paramconstruct p1 = new Paramconstruct(i, city);
		
		p1.display();
		
	}

}
