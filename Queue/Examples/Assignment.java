import java.util.Date;


public class Assignment implements Comparable 
{
	String courseCode;
	String task;
	Date dueDate;
	
	public Assignment (String courseCode, String task, Date dueDate)
	{
		this.courseCode = courseCode;
		this.task = task;
		this.dueDate = dueDate;
	}

	@Override
	public int compareTo(Object obj) 
	{
		if(obj.getClass() == this.getClass())
		{
			Assignment a = (Assignment)obj;
			return this.courseCode.compareTo(a.courseCode);
		}
		
		return 0;
	}
	
	
}
