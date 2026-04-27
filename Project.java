// package Project;
import java.time.LocalDate;

public class Project extends Assignment {
	private int groupSize;
	private boolean hasPresentation;
	
	public Project()
	{
		super();
		this.groupSize=2;
		this.hasPresentation=true;
		this.setType("Project"); // sets type to 'Project'
	}
	public Project(String title, String description, LocalDate dueDate, String type, double mP,double aW,int gS,boolean hP)
	{
		super(title, description, dueDate, type, mP, aW);
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
		// throws exception if the group size is less than 1
		if (gS < 1) {
            throw new IllegalArgumentException("Group size must be at least 1.");
        }
        this.groupSize = gS;
	}
	public void setHasPresentation(boolean hP)
	{
		// sets boolean to whether there's a presentation or not
		this.hasPresentation = hasPresentation;
	}
	public String toString()
	{
		return super.toString() + "\nGroup Size: "+ getGroupSize()+ "\nHas Presentation: "+ getHasPresentation();
	}

}
