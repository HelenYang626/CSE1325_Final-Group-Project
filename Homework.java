import java.time.LocalDate;

public class Homework extends Assignment {
	private int pageCount;
	private int problemNumbers;
	
	public Homework()
	{
		super();
		this.pageCount= 1;
		this.problemNumbers=1;
		this.setType("Homework"); // sets type as 'Homework'
	}
	
	public Homework(String title, String description, LocalDate dueDate, String type, double mP,double aW, int pC,int pN)
	{
		super(title, description, dueDate, type, mP,aW);
		this.setPageCount(pC);
		this.setProblemNumbers(pN);
	}
	
	public int getPageCount()
	{
		return this.pageCount;
	}
	public int getProblemNumbers()
	{
		return this.problemNumbers;
	}
	
	public void setPageCount(int pC)
	{
		// throws exception if page count is less than 1.
		if (pC < 1) {
			throw new IllegalArgumentException("Page count must be at least 1.");
		}
		this.pageCount = pC;
	}
	public void setProblemNumbers(int pN)
	{
		// throws exception if problem count is less than 1.
		if (pN < 1) {
			throw new IllegalArgumentException("Problem count must be at least 1.");
		}
		this.problemnumbers = pN;
	}
	public String toString()
	{
		return super.toString() + "\nPage Count: "+ getPageCount()+ "\nNumber of Problems: "+ getProblemNumbers();
	}

}
