/**
 * 
 * Game.java
 * 
 * File:
 * 	$Id: Game.java,v 1.1 2014/02/23 19:34:29 afs2842 Exp $
 * 
 * Log: 
 *  $Log: Game.java,v $
 *  Revision 1.1  2014/02/23 19:34:29  afs2842
 *  Final state of project, all pretty and pink. As well as commeneted. Awesome... - AS
 *
 *  
 */

/**
 * @author Alberto cicali
 * 
 * Represents the game class that is used as a super by other game sub-classes.
 *
 */

import java.util.ArrayList;
public abstract class Game {
	/** Variables to hold various game information */
	protected String name;
	protected int maxPlayers;
	protected ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * Creates a game using the given parameters
	 * @param n, name
	 * @param np, max numbe of players
	 */
	public Game(String n, int np){
		this.name = n;
		this.maxPlayers = np;
	}
	/**
	 * Fills the player list with the max amount of players for the game.
	 * Selects players that aren't already in the list and that are not incapacitated.
	 * @param gamers
	 */
	public void pickPlayers(ArrayList<Player> gamers){
		this.players.clear();
		while(players.size() < maxPlayers){
			int peepIndex = (int) (Math.random() * (gamers.size()));
			if(!(gamers.get(peepIndex).isOutForTheCount()) && !(isPlaying(gamers.get(peepIndex)))){
				this.players.add(gamers.get(peepIndex));
				gamers.get(peepIndex).play();
				}
		}
		System.out.println("Picking players for " + this.name + "...");
		for(Player p : players){
			System.out.println(p.getName());
		}
	}
	
	/**
	 * Fills the players list with the given number of players, or up to the games max player count.
	 * Selects players that are not already in the list and that
	 * are not incapacitated.
	 * @param gamers
	 * @param num
	 */
	public void pickPlayers(ArrayList<Player> gamers, int num){
		this.players.clear();
		while(players.size() < num && players.size() < maxPlayers){
			int peepIndex = (int) (Math.random() * (gamers.size()));
			if(!(gamers.get(peepIndex).isOutForTheCount()) && !(isPlaying(gamers.get(peepIndex)))){
				this.players.add(gamers.get(peepIndex));
				gamers.get(peepIndex).play();
			}
		}
		System.out.println("Picking players for " + this.name + "...");
		for(Player p : players){
			System.out.println(p.getName());
		}
	}
	/**
	 * Checks if the given player is playing the game.
	 * @param p
	 * @return true if player is in the game, false otherwise
	 */
	public boolean isPlaying(Player p){
		for(Player peep : players){
			if(peep.equals(p))
				return true;
		}
		return false;
	}
	/**
	 * Abstract method uses to set the play rules for the game
	 */
	public abstract void play();
	/**
	 * @return the name of the game
	 */
	public String toString(){
		return name;
	}
}
