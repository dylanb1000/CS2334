import java.util.Scanner;

public class PlayNim {
	public static void main(String[] args) throws IllegalMoveException{  
		//1. add all classes that are not included in starter code(piles,random player,illegal move exception)
		//2. add stubs for all the methods
		//3. create player objects,piles
		//4. initiate nim with above
		Scanner keyboard=new Scanner(System.in);
		Player Me=new HumanPlayer("Dylan",keyboard);
		Player Bot=new RandomPlayer("Mr.Bot");
		int[] stones= {3,4,5};
		Nim Game=new Nim(Me,Bot,stones);
		Game.play();
		
	}
}
