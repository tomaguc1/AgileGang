package Model.Board;
import java.util.Scanner;
public class LogicShipRun {

	public static void main(String[] args) {
		Board b = new Board();
		b.printBoard();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter ship: ");
		String shipType = s.nextLine();
		
		System.out.println("Enter X:");
		int x=s.nextInt();
		System.out.println("Enter Y:");
		int y=s.nextInt();
		
		//hhh
		
		/*
		Ship titanic = new Ship();
		titanic.setLength(5);
		titanic.setPosition(y, x);
		titanic.setDirection(Direction.HORIZONTAL);
		b.setShip(titanic.position, titanic);
		b.printBoard();
		*/
		
		if (shipType.equals("carrier")) {
			Ship Carrier = new Ship("Carrier");
			Carrier.setPosition(x, y);
			b.setShip(Carrier.position, Carrier);
			b.printBoard();
		}
		else if (shipType.equals("destroyer")) {
			Ship Destroyer = new Ship("Destroyer");
			Destroyer.setPosition(x, y);
			b.setShip(Destroyer.position, Destroyer);
			b.printBoard();
		}
		else if (shipType.equals("battleship")) {
			Ship BattleShip = new Ship("BattleShip");
			BattleShip.setPosition(x, y);
			b.setShip(BattleShip.position, BattleShip);
			b.printBoard();
		}
		else if (shipType.equals("submarine")) {
			Ship Submarine = new Ship("Submarine");
			Submarine.setPosition(x, y);
			b.setShip(Submarine.position, Submarine);
			b.printBoard();
		}
		else if (shipType.equals("patrol")) {
			Ship Patrol = new Ship("Patrol");
			Patrol.setPosition(x, y);
			b.setShip(Patrol.position, Patrol);
			b.printBoard();
		}
		else {
			System.out.println("Bye bye loser");
		}
		
		/*
		Ship D = new Ship("Destroyer");
		D.setPosition(x, y);
		b.setShip(D.position, D);
		b.printBoard();
		*/
		/*
		Scanner s = new Scanner(System.in);
		System.out.println("Enter X:");
		int x=s.nextInt();
		System.out.println("Enter Y:");
		int y=s.nextInt();
		
		Position position = new Position(y,x);
		b.move(position);
		b.printBoard();
		
		*/
		
		
		
		
		
		
		//b.printBoard();
		/*
		int x = 0;
		int y= 5;
		Position position = new Position(x,y);
		b.move(position);
		b.printBoard();
		*/
		
	}
}
