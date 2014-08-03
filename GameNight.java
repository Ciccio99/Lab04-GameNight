/**
 * 
 * GameNight.java
 * 
 * File:
 * 	$Id: GameNight.java,v 1.1 2014/02/23 19:34:30 afs2842 Exp $
 * 
 * Log: 
 *  $Log: GameNight.java,v $
 *  Revision 1.1  2014/02/23 19:34:30  afs2842
 *  Final state of project, all pretty and pink. As well as commeneted. Awesome... - AS
 *
 *  
 */

/**
 * @author Alberto Scicali
 * 
 * Class that represents a classic game night scenario. Hosts players of all ages.
 *
 */
import java.util.ArrayList;
public class GameNight {
	
	/** Lists to hold the people playing and games for the game night.*/
	private static ArrayList<Player> gamers = new ArrayList<Player>();
	private static ArrayList<Game> games = new ArrayList<Game>();
	
	public static void main(String[] args) {
		/** Creates and stores all the gamers/players */
		gamers.add(makeYoungling("Thomas"));
		gamers.add(makeYoungling("Elias"));
		gamers.add(makeYoungling("Pauls"));
		gamers.add(makeYoungling("Anya"));
		gamers.add(makeAdult("Dan"));
		gamers.add(makeAdult("Kyle"));
		gamers.add(makeAdult("Jean"));
		gamers.add(makeAdult("Gulshan"));
		gamers.add(makeAdult("Ryan"));
		gamers.add(makeAdult("Bob"));
		gamers.add(makeAdult("Olivia"));
		gamers.add(makeAdult("Renee"));
		/** Creates and stores all the games */
		games.add(new BoardGame("Parcheezy", 4, 2.5));
		games.add(new BoardGame("Sorry!", 6, 1.4));
		games.add(new ConsoleGame("Mario Kart", 4, true));
		games.add(new ConsoleGame("Halo", 8, false));
		games.add(new TeamCardGame("Spades"));
		games.add(new TeamCardGame("B*** S***"));
		games.add(new GermanBoardGame("King's Cup", 5));
		
		pickPlayers(games);
		playGames(games);
		determineWinner(gamers);
			
	}
	private static void pickPlayers(ArrayList<Game> zeGames){
		for(Game g : zeGames){
			g.pickPlayers(gamers, g.maxPlayers);
		}
		System.out.println();
	}
	/**
	 * Goes through the given list of games and plays them
	 * @param zeGames, list of games
	 */
	private static void playGames(ArrayList<Game> zeGames){
		//Goes through the list of games, and plays them
				for(Game g : zeGames){
					g.play();
					System.out.println();
				}
	}
	
	/**
	 * Goes through the list of given gamers and determines 
	 * the winner of game night.
	 * @param zePlayers, the list of gamers
	 */
	private  static void determineWinner(ArrayList<Player> zePlayers){
		Player weiner = null;
		int wins = 0;
		for(Player person : gamers){
			if(person.getWins() > wins){
				wins = person.getWins();
				weiner = person;
			}
		}
		System.out.println("The winner of game night is " + weiner.getName() + "!!!");
	}
	/**
	 * Creates a player with random stats, and an age below 10
	 * @param name
	 * @return the generated player
	 */
	private static Player makeYoungling(String name){
		int i = (int) (Math.random() * ((50 - 10) + 1)) + 10;
		int d = (int) (Math.random() * ((50 - 10) + 1)) + 10;
		int l = (int) (Math.random() * ((50 - 10) + 1)) + 10;
		int a = (int) Math.random() * 10;
		return new Player(name, i, d, l, a);
	}
	/**
	 * Created a player with random stats, and with 10 or higher
	 * @param name
	 * @return generated player
	 */
	private static Player makeAdult(String name){
		int i = (int) (Math.random() * ((100 - 15) + 1)) + 15;
		int d = (int) (Math.random() * ((100 - 15) + 1)) + 15;
		int l = (int) (Math.random() * ((100 - 15) + 1)) + 15;
		int a = (int) (Math.random() * ((50 - 10) + 1)) + 10;
		return new Player(name, i, d, l, a);
	}

}
