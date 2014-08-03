/**
 * 
 * TeamCardGame.java
 * 
 * File:
 * 	$Id: TeamCardGame.java,v 1.1 2014/02/23 19:34:30 afs2842 Exp $
 * 
 * Log: 
 *  $Log: TeamCardGame.java,v $
 *  Revision 1.1  2014/02/23 19:34:30  afs2842
 *  Final state of project, all pretty and pink. As well as commeneted. Awesome... - AS
 *
 *  
 */

/**
 * @author Alberto Scicali
 * 
 * Class represents a team car game. Teams are composed of two players, and only two teams allowed.
 *
 */
public class TeamCardGame extends Game {
	/** Holds the scores of the two teams for calculation purposes */
	private int teamOneScore;
	private int teamTwoScore;
	
	/**
	 * Creates the team card game using the given params
	 * @param n
	 */
	public TeamCardGame(String n) {
		super(n, 4);
	}
	
	/**
	 * Plays the game and determines the winner based on  the rules.
	 * Rules: The team with the highest score wins.
	 * Score determination: High intel of the two teammates + 2*lower intel of teammates 
	 * - (1/4)*teammate one - (1/4)*teammate two.
	 * 
	 * Prints who won at the end. Winners takes a celebratory drink if they're of age.
	 */
	public void play() {
		teamOneScore = 0;
		teamTwoScore = 0;
		Player winnerOne = null;
		Player winnerTwo = null;
        System.out.println("Playing " + name + "...");
        calcTeamOne();
        calcTeamTwo();
        if(teamOneScore >= teamTwoScore){
        	winnerOne = players.get(0);
        	winnerTwo = players.get(2);
        }
        else{
        	winnerOne = players.get(1);
        	winnerTwo = players.get(3);
        }
        
        System.out.println("Winner team is " + winnerOne.getName() + " and " + winnerTwo.getName());
        winnerOne.youWin();
        winnerTwo.youWin();
        winnerOne.drink();
        winnerTwo.drink();
    }
	
	/**
	 * Calculates the score of team one
	 */
	private void calcTeamOne(){
		int playOneInt = players.get(0).getIntelligence();
		int playTwoInt = players.get(2).getIntelligence();
		if(playOneInt > playTwoInt){
			teamOneScore = playOneInt + (2 * playTwoInt);
		}
		else{
			teamOneScore = (playOneInt * 2) + playTwoInt;
		}
		teamOneScore -= ((players.get(0).getIntoxication() / 4) + 
				(players.get(2).getIntoxication() / 4));
	}
	
	/**
	 * Calculates the score of team two
	 */
	private void calcTeamTwo(){
		int playOneInt = players.get(1).getIntelligence();
		int playTwoInt = players.get(3).getIntelligence();
		if(playOneInt > playTwoInt){
			teamTwoScore = playOneInt + (2 * playTwoInt);
		}
		else{
			teamTwoScore = (playOneInt * 2) + playTwoInt;
		}
		teamTwoScore -= ((players.get(1).getIntoxication() / 4) + 
				(players.get(3).getIntoxication() / 4));
	}
}
