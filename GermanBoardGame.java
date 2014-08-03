/**
 * 
 * GermanBoardGame.java
 * 
 * File:
 * 	$Id: GermanBoardGame.java,v 1.1 2014/02/23 19:34:29 afs2842 Exp $
 * 
 * Log: 
 *  $Log: GermanBoardGame.java,v $
 *  Revision 1.1  2014/02/23 19:34:29  afs2842
 *  Final state of project, all pretty and pink. As well as commeneted. Awesome... - AS
 *
 *  
 */

/**
 * @author Alberto Scicali
 * 
 * Class that represents a German board game. The game type is oriented around a drinking game,
 * since it's German, it seems appropriate. This game type is age limited to 10 or older. 
 * It can be assumed that the game does not take place in America.
 *
 */

import java.util.ArrayList;
public class GermanBoardGame extends BoardGame {
	/**
	 * Created a German board game using the given parameters.
	 * @param n, name
	 * @param np, max players
	 */
	public GermanBoardGame(String n, int np) {
		super(n, np, 0);
	}
	/**
	 * Plays the game and determines the winner based on  the rules.
	 * Calls the drinking simulation.
	 * Rules: The player with highest intelligence + (intoxication / 2) wins.
	 * (Assuming anyone makes it through to the end)
	 * If no players is left standing at the end of the simulation
	 * nobody wins.
	 * 
	 * Prints who has won at the end. Winner takes a celebratory drink.
	 */
	public void play() {
        System.out.println("Playing " + name + "...");
        // Begins the drinking game simulation
        drinkingSimulation(players);
        
        // find player with max intelligence + 1/2 intoxication
        //If nobody is left standing
    	if(players.size() == 0){
    		System.out.println("No one is left standing, nobody wins the German boardgame...");
    	}
    	else{
    		double bestval = 0;
    		Player winner = null;
	        for (Player player : this.players) {
	            double thisval = player.getIntelligence() + (player.getIntoxication() / 2);
	            if (thisval > bestval) {
	                bestval = thisval;
	                winner = player;
	            }
	        }
	        System.out.println("Winner is " + winner.getName());
	        winner.youWin();
	        winner.drink();
    	}
    }
	
	/**
	 * Simulates 5 rounds of drinking, or until no one is left standing.
	 * @param zeDrinkers
	 */
	private void drinkingSimulation(ArrayList<Player> zeDrinkers){
		System.out.println("~~~Drinks for all the players of King's Cup!~~~");
		for(Player person : this.players){
			person.drink();
		}
		int round = 1;
        ArrayList<Player> sleepers = new ArrayList<Player>();
        while(round < 6 && zeDrinkers.size() > 0){
        	System.out.println("~~~Drinks for round " + round + "~~~");
	    	for(Player drinker : zeDrinkers){
	    		drinker.drink();
	    		if(drinker.isOutForTheCount())
	    			sleepers.add(drinker);
	    	}
	    	for(Player p : sleepers){
	        	players.remove(p);
	        }
	    	round++;
        }
	}
	/**
	 * Picks players that are of age 10 or older
	 * @param gamers
	 * @param max number of players
	 */
	public void pickPlayers(ArrayList<Player> gamers, int num){
		
		this.players.clear();
		while(players.size() < num && players.size() < maxPlayers){
			int peepIndex = (int) (Math.random() * (gamers.size()));
			if(!(gamers.get(peepIndex).isOutForTheCount()) && gamers.get(peepIndex).getAge() > 9 && !(isPlaying(gamers.get(peepIndex)))){
				this.players.add(gamers.get(peepIndex));
				gamers.get(peepIndex).play();
				}
		}
		System.out.println("Picking players for " + this.name + "...");
		for(Player p : players){
			System.out.println(p.getName());
		}
	}
	
	
}
