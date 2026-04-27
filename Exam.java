import java.time.LocalDate;

public class Exam extends Assignment{
	private double duration;
	private String location;
	
	public Exam() 
	{
		super();
		this.duration=30.0; //might change
		this.location="TBD"; // sets the default location to TBD
		this.setType("Exam"); // sets the type of assignment as 'Exam'.
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
		// throws exception if the duration is less than 0 
		if (aD < 0) {
			throw new IllegalArgumentException("Duration cannot be negative.");
		}
		this.duration = aD;
	}
	
	public void setLocation(String aL) 
	{
		if(aL!=null) //might change it
		{
			this.location=aL;
		}
		else
		{
			this.location="TBD";
		}
	}
	
	public String toString()
	{
		return super.toString() + "\nDuration: "+ getDuration()+ "\nLocation: "+ getLocation();
	}

}
