//Q28.What will be output of given code? 
class Q28 { 
int x = 5; 
	Q28()
	{
		this(10); 
	} 
	Q28(int x){ 
		this.x = x;
			System.out.println(x);
	} 
	public static void main(String[] args) { 	
		Q28 obj = new Q28(); 
		System.out.println(obj.x); 
	} 
} 