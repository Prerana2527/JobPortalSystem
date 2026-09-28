
 
//Q4.what will be output of given code? 
class Q2
{ 
    int a = 10; 
    void test(Q2 obj){
		obj.a += 5; 
	} 
    public static void main(String[] args) { 
        Q2 obj = new Q2(); 
        obj.test(obj); 
        System.out.println(obj.a); 
    }
	
}