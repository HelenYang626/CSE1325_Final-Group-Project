// package Project;
//done
import java.time.LocalDate;

public class Quiz extends Assignment{
	private double timeLimit;
	private int questionCount;
	
	public Quiz()
	{
		super();
		this.timeLimit=10;
		this.questionCount=1;
		this.setType("Quiz"); // sets type to 'Quiz'
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
		if (tL < 1) {
			throw new IllegalArgumentException("Time limit must be at least 1 minute.");
		}
		this.timeLimit = tL;
	}
	public void setQuestionCount(int qC)
	{
		if (qC < 1) {
			throw new IllegalArgumentException("Question count must be at least 1.");
		}
		this.questionCount = qC;
	}
	public String toString()
	{
		return super.toString() + "\nTime Limit: "+ getTimeLimit()+ "\nQuestion Count: "+ getQuestionCount();
	}

}
