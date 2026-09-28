Q28.What will be output of given code? 
interface I28 { 
    void show(); 
} 
class Q28 implements I28 { 
    public void show() { System.out.println("Interface"); } 
    public static void main(String[] args) { 
        new Q28().show(); 
    } 
} 