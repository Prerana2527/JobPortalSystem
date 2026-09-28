class Value
{
	int x,y;
	void setValue(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Add extends Value{
	int getAdd(){
		return x+y;
	}
}
class Mul extends Value{
	int getMul()
	{
		return x*y;
	}
}
public class Inheritance
{
	public static void main(String args[])
	{
		Add ad=new Add();
		ad.setValue(10,20);
		int result=ad.getAdd();
		System.out.println("Addition is:"+result);
		Mul m=new Mul();
		m.setValue(10,20);
		resul=m.getMul();
		System.out.println("Multiplication is :"+result);
	}
}