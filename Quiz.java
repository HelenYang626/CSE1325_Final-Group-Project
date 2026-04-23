// package Project;
//done

public class Quiz extends Assignment{
	private double timeLimit;
	private int questionCount;
	
	public Quiz()
	{
		super();
		this.timeLimit=10;
		this.questionCount=1;
	}
	public Quiz(String title, String description, LocalDate dueDate, String type, double mP,double aW,double tL,int qC)
	{
		super(title, description, dueDate, type, mP,aW);
		this.setTimeLimit(tL);
		this.setQuestionCount(qC);
	}
	
	public double getTimeLimit()
	{
		return this.timeLimit;
	}
	
	public int getQuestionCount()
	{
		return this.questionCount;
	}
	
	public void setTimeLimit(double tL)
	{
		if(tL>=10)
		{
			this.timeLimit=tL;
		}
		else
		{
			this.timeLimit=10;
		}
	}
	public void setQuestionCount(int qC)
	{
		if(qC>=1)
		{
			this.questionCount=qC;
		}
		else
		{
			this.questionCount=1;
		}
	}
	public String toString()
	{
		return super.toString() + "\nTime Limit: "+ getTimeLimit()+ "\nQuestion Count: "+ getQuestionCount();
	}

}
