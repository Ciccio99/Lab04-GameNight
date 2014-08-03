/**
 * 
 * ConsoleGame.java
 * 
 * File:
 * 	$Id: ConsoleGame.java,v 1.1 2014/02/23 19:34:29 afs2842 Exp $
 * 
 * Log: 
 *  $Log: ConsoleGame.java,v $
 *  Revision 1.1  2014/02/23 19:34:29  afs2842
 *  Final state of project, all pretty and pink. As well as commeneted. Awesome... - AS
 *
 *  
 */

/**
 * @author Alberto Scicali
 * 
 * Class that represents a Console type game. Has a factor of brainuse or no brainuse,
 * which includes/excludes the use of intelligence in the winning factor.
 *
 */
public class ConsoleGame extends Game {
	/** Determines if intelligence is factored into the winning rules*/
	private boolean brainUse;
	
	/**
	 * Created a console game using the given params.
	 * @param n
	 * @param np
	 */
	public ConsoleGame(String n, int np, boolean usesBrains) {
		super(n, np);
		brainUse = usesBrains;
	}
	/**
	 * Plays the game and determines the winner based on  the rules.
	 * Rules: w/ brainUse, Intelligence + dexterity - 1/4 intoxication
	 * w/o brainUse, Dexterity - 1/4 intoxication.
	 * 
	 * Prints who won at the end. Winner takes a celebratory drink if they're of age.
	 */
	public void play() {
        System.out.println("Playing " + name + "...");
        double bestval = 0;
        Player winner = null;
        if(brainUse){
        	// find player with max dexterity + intelligence - 1/4 intoxication
	        for (Player player : players) {
	            double thisval = player.getIntelligence() + player.getDexterity() -
	            		(player.getIntoxication() / 4);
	            if (thisval > bestval) {
	                bestval = thisval;
	                winner = player;
	            }
	        }
        }
        else{
        	for (Player player : players) {
        		double thisval = player.getDexterity() -
	            		(player.getIntoxication() / 4);
	            if (thisval > bestval) {
	                bestval = thisval;
	                winner = player;
	            }
	        }
        }
        System.out.println("Winner is " + winner.getName());
        winner.youWin();
        winner.drink();
    }
}
