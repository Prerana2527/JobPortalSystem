//Q14.what will be output of given code? 
//Q25.what will be output of given code? 
class Q25 { 
    final void show() 
	{ 
		System.out.println
		("Final Method");
	} 
    class Sub extends Q25 
	{ 
        void show(){ 
		System.out.println("Override");
	} 
 } 
    public static void main(String[] args) { 
        new Sub().show(); 
    } 
} 