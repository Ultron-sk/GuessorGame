import java.util.Random;
import java.util.Scanner;




class Player 
{
	int PlayerGuess;
	Scanner sc= new Scanner(System.in);
	public int GuessNum() {
		
		System.out.println("What's Your Guess??");
		PlayerGuess = sc.nextInt();
		
		
		return PlayerGuess;
	
	}
	
	
}
	
class Umpire
{    
	 int numGuesser;
	 int numPlayer1;
	 int numPlayer2;
	 int numPlayer3;
	 int trycount;
	 
	
	 public void guessorNum()//A robot for guessing
	 {
			
				Random guess = new Random();
				
				numGuesser = guess.nextInt(100)+1;
				System.out.println("Find the Guessed Number(1-100)!!!");
				//System.out.println(numGuesser);
			}		 
	 
	 public void playerNum()
	 
	 {
		 
	   Player p1=new Player();	
	   Player p2=new Player();	
	   Player p3=new Player();
	   System.out.println("Player 1......");
	   numPlayer1=p1.GuessNum();
	   System.out.println("Player 2......");
	   numPlayer2=p2.GuessNum();
	   System.out.println("Player 3......");
	   numPlayer3=p3.GuessNum();
	   if(numPlayer1>100||numPlayer2>100||numPlayer3>100) {
		   System.out.println("Someone guessed beyond limit!!\nPlay agin");
		   playAgain();
	   }
	   
	   
	 }
	 void compare() {
		 trycount++;
			if(numGuesser==numPlayer1)
			{
				if(numGuesser==numPlayer2 && numGuesser==numPlayer3)
				{
					System.out.println("Game tied ");
					
					
					
				}
				else if(numGuesser==numPlayer2)
				{
					System.out.println("Player 1 and Player 2 won the game");
				}
				else if(numGuesser==numPlayer3)
				{
					System.out.println("Player 1 and Player 3 won ");
				}
				else
				{
				
				System.out.println("Player 1 won the game");
				
				}
				
				System.out.println("The amount of tries is:"+trycount);
			    playAgain();
			}
			
			
			else if(numGuesser==numPlayer2)
			{
				
				if(numGuesser==numPlayer3)
				{
				System.out.println("Player 2 and Player 3 won the game");
				}
				else
				{
					System.out.println("Player 2 won the game");
				}
				System.out.println("The amount of tries is:"+trycount);
				playAgain();
			
			}
			
			
			
			else if(numGuesser==numPlayer3)
			{
				System.out.println("Player 3 won the game");
				System.out.println("The amount of tries is:"+trycount);
				playAgain();
				
			}
			else
			{
				System.out.println("HA HA!! Wrong Guess!!!\nGuess again!!");
				hint();
			}
			 
			
			
		}
	 private void playAgain() {
		 System.out.println("Press w to play again\nPress x to quit");
		 Scanner sc = new Scanner(System.in);
			String Launcher = sc.next();
			GuesserGame.start(Launcher);
			sc.close();
		 
	 }

	private void hint() {
		if(numPlayer1<numGuesser) {
			System.out.println("Player 1 the Guessed number is higher than your Guess!");
		}
		if(numPlayer2<numGuesser) {
			System.out.println("Player 2 the Guessed number is higher than your Guess!");
		}
		if(numPlayer3<numGuesser) {
			System.out.println("Player 3 the Guessed number is higher than your Guess!");
		}
		if(numPlayer1>numGuesser) {
			System.out.println("Player 1 the Guessed number is lower than your Guess!");
		}
		if(numPlayer2>numGuesser) {
			System.out.println("Player 2 the Guessed number is lower than your Guess!");
		}
		if(numPlayer3>numGuesser) {
			System.out.println("Player 3 the Guessed number is lower than your Guess!");
		}
	}
}
class GameLauncher
{
   public void Launch() {
	   Umpire U = new Umpire();
		U.guessorNum();
		do {
		
	    U.playerNum();
		U.compare();
		}while(!(U.numGuesser==U.numPlayer1||U.numGuesser==U.numPlayer2||U.numGuesser==U.numPlayer3));
		
		
   }
}
	
	
public class GuesserGame {
	public static void main(String[] args) {
		waitingLobby();

		}

	public static void waitingLobby() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press w to start\nPress x to exit");
		String Launcher = sc.next();
		start(Launcher);
		sc.close();
	}

	public static void start(String Launcher) {
		switch(Launcher) {
		case"w":
			GameLauncher G = new GameLauncher();
			G.Launch();
			
			break;
		
		
		case"x" :
			System.exit(0);break;
		default:
			System.out.println("Wrong Entry");
			break;  
		}
	}

}

