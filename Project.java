// package Project;

public class Project extends Assignment {
	private int groupSize;
	private boolean hasPresentation;
	
	public Project()
	{
		super();
		this.groupSize=2;
		this.hasPresentation=true;
		
	}
	public Project(double mP,double aW,int gS,boolean hP)
	{
		super(mP,aW);
		this.setGroupSize(gS);
		this.setHasPresentation(hP);
	}
	
	public int getGroupSize()
	{
		return this.groupSize;
	}
	
	public boolean getHasPresentation()
	{
		return this.hasPresentation;
	}
	
	public void setGroupSize(int gS)
	{
		if(gS>=2)
		{
			this.groupSize=gS;
		}
		else
		{
			this.groupSize=2;
		}
	}
	public void setHasPresentation(boolean hP)
	{
		if(this.groupSize>=2) 
		{
			this.hasPresentation=hP;
		}
		else
		{
			this.hasPresentation=false;
		}
	}
	public String toString()
	{
		return super.toString() + "\nGroup Size:: "+ getGroupSize()+ "\nHas Presentation: "+ getHasPresentation();
	}

}
