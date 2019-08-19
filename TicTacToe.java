package Game;

import java.util.Scanner;

public class TicTacToe 
{
	private Player player1,player2;
	private Board board;
	
	public void startGame()
	{
		Scanner s = new Scanner(System.in);
		//Players Input
		player1 = takePlayerInput(1);
		player2 = takePlayerInput(2);
		
		//Check if symbol is not same for both
		
		while(player1.getSymbol()==player2.getSymbol())
		{
			System.out.println("\tSymbol ALready Taken. Take Another Symbol");
			char symbol = s.next().charAt(0);
			player2.setSymbol(symbol);
		}
		
		//Create Board
		
		board = new Board(player1.getSymbol(),player2.getSymbol());
		
		//Conduct Game
		
		boolean player1Turn=true;
		
		String status = "Incomplete";
		while(status.equals("Incomplete") || status.equals("Invalid") )
		{
			if(player1Turn==true)
			{
				System.out.println("\t\tPLayer 1- "+player1.getName()+"'s turn");
				System.out.print("\t\t\tEnter x-coordinate: ");
				int x=s.nextInt();
				System.out.print("\t\t\tEnter y-coordinate: ");
				int y=s.nextInt();
				status = board.move(player1.getSymbol(),x,y);
				if(status.equals("Invalid"))
				{
					System.out.println("\tPlease Enter Valid Coordinates Again!");
				}
				else
				{
					player1Turn=false;
					board.print();
				}
				
			}
			else
			{
				System.out.println("\t\tPLayer 2- "+player2.getName()+"'s turn");
				System.out.print("\t\t\tEnter x-coordinate: ");
				int x=s.nextInt();
				System.out.print("\t\t\tEnter y-coordinate: ");
				int y=s.nextInt();
				status = board.move(player2.getSymbol(),x,y);
				if(status.equals("Invalid"))
				{
					System.out.println("\tPlease Enter Valid Coordinates Again!");
				}
				else
				{
					player1Turn=true;
					board.print();
				}
			}
		}
		if(status.equals("Player 1 Wins!!"))
			System.out.println("\t\t\t\tPlayer 1: "+player1.getName()+" Wins!!!");
		else if(status.equals("Player 2 Wins"))
			System.out.println("\t\t\t\tPLayer 2: "+player2.getName()+" Wins!!!");
		else 
			System.out.println("\t\t\t\tGame Ends In a Draw!!!");
	}
	
	private Player takePlayerInput(int num)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("\t\tEnter Player "+num+" name: ");
		String name = s.nextLine();
		System.out.print("\t\t\tEnter Player "+num+" symbol: ");
		char symbol = s.next().charAt(0);
		Player p = new Player(name,symbol);
		return p;
	}
}
