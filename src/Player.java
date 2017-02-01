
public class Player //player class for the object known as player within the game
{
	//variable declaration
	private double dblDmg;
	private int intEvolution;
	private double dblCrit;
	
	
	//Constructor
	public Player(double dblDmg, int intEvolution, double dblCrit)
	{
		//creating objects
		this.dblDmg = dblDmg;
		this.intEvolution = intEvolution;
		this.dblCrit = dblCrit;
	}
	
	//Setters
	public void setDmg(double dblFactor)
	{
		this.dblDmg = dblFactor;
	}
	
	public void setEvolution(int intFactor)
	{
		this.intEvolution = intFactor;
	}
	
	//Getters
	public double getDmg()
	{
		return dblDmg;
	}
	
	public int getEvolution()
	{
		return intEvolution;
	}
	
	public double getCrit()
	{
		return dblCrit;
	}
	
	public String toString() 
	{
		return ("Damage per tap: " + dblDmg + "\nEvolution " + intEvolution + "\nCrit Chance" + dblCrit);
	}

	
	
}
