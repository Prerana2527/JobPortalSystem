import java.util.*; 
class Schedule
{
	private int id;
	private String examName;
	private String date;
	private int totalMarks;
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setExamName(String examName)
	{
		this.examName=examName;
	}
	public String getExamName()
	{
		return examName;
	}
	public void setDate(String date)
	{
		this.date=date;
	}
	public String getDate()
	{
		return date;
	}
	public void setTotalMarks(int totalMarks)
	{
		this.totalMarks=totalMarks;
	}
	public int getTotalMarks()
	{
		return totalMarks;
	}
}
class ShowSchedule
{
	private Schedule sh;
	public void verifyUser(String username, String password)
	{	
		if(username.equals("abc") && password.equals("mno"))
		{
			sh=new Schedule();
			sh.setId(1);
			sh.setExamName("TEST");
			sh.setDate("22/04/2026");
			sh.setTotalMarks(100);
			show(sh);
		}else
		{
			System.out.println("Invalid User");
		}
	}
	public void show(Schedule sh)
	{
		System.out.println(sh.getId()+"\t"+sh.getExamName()+"\t"+sh.getDate()+"\t"+sh.getTotalMarks());
	}
}
public class EncApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		ShowSchedule sh=new ShowSchedule();
		String username=sc.nextLine();
		String password=sc.nextLine();
		sh.verifyUser(username,password);
	}
}