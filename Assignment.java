package Project;
//done

public class Assignment extends Item { //subclass -of Item class,add later 
	private double maxPoints;
	private double weight;
	
	//constructor
	public Assignment() 
	{
		super();
		this.maxPoints=100.0; // might change it
		this.weight=.10;     //might change 
	}
	//Parameterized constructor
	public Assignment(String title,String description,LocalDate dueDate,String type, double mP,double aW)
	{
		//call mutators
		super(title,description,dueDate,Type);
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
		if(mP>=0 && mP<=100) //figure out what the condition will be,if anny
		{
			this.maxPoints=mP;
		}
		else
		{
			this.maxPoints=100;
		}
	}
	public void setWeight(double aW)
	{
		if(aW>0 && aW<=.35) //figure out what the condition will be,if any
		{
			this.weight=aW;
		}
		else
		{
			this.weight=.10;
		}
	}
	public String toString()
	{
		
		return  super.toString() + "\nMax Points: "+ getMaxPoints()+ "\nWeight: "+ getWeight();
	}
	

}
