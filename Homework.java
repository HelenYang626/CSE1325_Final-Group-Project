import java.time.LocalDate;

public class Homework extends Assignment {
	private int pageCount;
	private int problemNumbers;
	
	public Homework()
	{
		super();
		this.pageCount= 1;
		this.problemNumbers=1;
	}
	
	public Homework(double mP,double aW, int pC,int pN)
	{
		super(mP,aW);
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
		if(pC>=1) //might change it
		{
			this.pageCount=pC;
		}
		else 
		{
			this.pageCount=1;
		}
		
	}
	public void setProblemNumbers(int pN)
	{
		if(pN>=1)//might change
		{
			this.problemNumbers=pN;
		}
		else
		{
			this.problemNumbers=1;
		}
	}
	public String toString()
	{
		return super.toString() + "\nPage Count: "+ getPageCount()+ "\nNumber of Problems: "+ getProblemNumbers();
	}

}
