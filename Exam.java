import java.time.LocalDate;

public class Exam extends Assignment{
	private double duration;
	private String location;
	
	public Exam() 
	{
		super();
		this.duration=30.0; //might change
		this.location="Class"; //might change
		
	}
	//parametrized constructor
	public Exam(String title, String description, LocalDate dueDate, String type, double mP,double aW,double aD,String aL)
	{
		super(title, description, dueDate, type, mP, aW);
		this.setDuration(aD);
		this.setLocation(aL);
	}
	public double getDuration()
	{
		return this.duration;
	}
	public String getLocation()
	{
		return this.location;
	}
	public void setDuration(double aD)
	{
		if(aD>=0 && aD<=180) // changed || to &&
		{
			this.duration=aD;
		}
		else
		{
			this.duration=30.0;
		}
	}
	
	public void setLocation(String aL) 
	{
		if(aL!=null) //might change it
		{
			this.location=aL;
		}
		else
		{
			this.location="Class";
		}
	}
	
	public String toString()
	{
		return super.toString() + "\nDuration: "+ getDuration()+ "\nLocation: "+ getLocation();
	}

}
