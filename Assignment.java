import java.time.LocalDate;

public class Assignment extends Item { //subclass -of Item class,add later 
	private double maxPoints;
	private double weight;
	
	//constructor
	public Assignment() 
	{
		super();
		this.maxPoints=100.0; // might change it
		this.weight=.10;     //might change 
		this.setType("Assignment"); // sets the type of the item as an "Assignment"
	}
	//Parameterized constructor
	public Assignment(String title,String description,LocalDate dueDate,String type, double mP,double aW)
	{
		//call mutators
		super(title,description,dueDate,type);
		this.setMaxPoints(mP);
		this.setWeight(aW);
	}
	
	public double getMaxPoints()
	{
		return this.maxPoints;
	}
	
	public double getWeight()
	{
		return this.weight;
	}
	
	public void setMaxPoints(double mP)
	{
		// throws exception if the max points are less than 0
		if (mP <= 0) {
			throw new IllegalArgumentException("Max points must be greater than 0.");
		}
		this.maxPoints = mP;
	}
	public void setWeight(double aW)
	{
		if (aW <= 0 || aw > 100.0) {
			throw new IllegalArgumentException("Weight must be between 0 and 100");
		}
		this.weight = aW;
	}
	public String toString()
	{
		
		return  super.toString() + "\nMax Points: "+ getMaxPoints()+ "\nWeight: "+ getWeight();
	}
	

}
