/**
 * 
 * Player.java
 * 
 * File:
 * 	$Id: Player.java,v 1.1 2014/02/23 19:34:30 afs2842 Exp $
 * 
 * Log: 
 *  $Log: Player.java,v $
 *  Revision 1.1  2014/02/23 19:34:30  afs2842
 *  Final state of project, all pretty and pink. As well as commeneted. Awesome... - AS
 *
 *  
 */
/**
 * @author Alberto Scicali
 * 
 * Player class maintains players stats, such as wins, losses, age, etc. 
 * Various methods to control a players state and their inebriation as well.
 *
 */
public class Player {
	/** Types to maintain various stats*/
	private int intelligence;
	private int age;
	private int dexterity;
	private int luck;
	private int wins;
	private int played;
	private int intoxication;
	private final int BLACK_OUT = 125;
	private String name;
	private boolean incapacitated;
	
	/**
	 * Creates a players using the given params, and sets their 
	 * intoxication level.
	 * @param n name
	 * @param i intelligence
	 * @param d dexterity
	 * @param l luck
	 * @param a age
	 */
	public Player(String n, int i, int d, int l, int a){
		this.name = n;
		this.age = a;
		this.dexterity = d;
		this.intelligence = i;
		this.luck = l;
		intoxication = 0;
		wins = 0;
		played = 0;
		incapacitated = false;
	}
	/**
	 * @return player age
	 */
	public int getAge(){
		return age;
	}
	/**
	 * @return player dexterity
	 */
	public int getDexterity(){
		return dexterity;
	}
	/**
	 * @return player intelligence
	 */
	public int getIntelligence(){
		return intelligence;
	}
	/**
	 * @return player intoxication
	 */
	public int getIntoxication(){
		return intoxication;
	}
	/**
	 * @return player luck
	 */
	public int getLuck(){
		return luck;
	}
	/**
	 * @return player name
	 */
	public String getName(){
		return name;
	}
	/**
	 * @return player wins
	 */
	public int getWins(){
		return wins;
	}
	/**
	 * increments the number of games played for the player
	 */
	public void play(){
		played++;
	}
	/**
	 * @return true if player in incapacitated, false otherwise
	 */
	public boolean isOutForTheCount(){
		return incapacitated;
	}
	/**
	 * Player takes a drink, incrementing intoxication level. If intoxication reaches the limit, 
	 * the player will become incapacitated and cannot continue playing in the game night.
	 * 
	 * --Incapacitation does not remove the player from the possibility of winning.--
	 * 
	 * If the player age is too low, they will NOT be able to drink. An appropriate message
	 * will be displayed.
	 */
	public void drink(){
		if(age >= 10){
			intoxication += 5 * ((played - wins) + 1);
			System.out.println(name + " takes a drink!");
			if(intoxication >= BLACK_OUT){
				intoxication = BLACK_OUT;
				incapacitated = true;
				System.out.println("!!!" + name + " has fainted from exhaustion and has returned to their Pokeball!!!");
			}
		}
		else
			System.out.println(name + " isn't old enough to drink, you miscreant!");
	}
	/**
	 * Increments the player win counter
	 */
	public void youWin(){
		wins++;
	}
	/**
	 * Override
	 * @return player name, and number of games played and won.
	 */
	public String toString(){
		return String.format("%s has played %d and has %d wins.", name, played, wins);
	}
}


