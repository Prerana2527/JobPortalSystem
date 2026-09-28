//Q14.what will be output of given code? 
//Q25.what will be output of given code? 
abstract class Q25 { 
    abstract void display(); 
} 
class SubQ25 extends Q25 { 
    void display(){
		System.out.println("Hello");
	} 
    public static void main(String[] args) { 
        new SubQ25().display(); 
    }  
    
} 