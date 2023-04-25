package Model.Board;
import java.util.ArrayList;
import Model.Board.Obstacle;
public class Board {

	BoardElements[][] board = new BoardElements[10][10];
	
//A constructor that initializes the board with only ocean 
	public Board() {
		
		for ( int i=0; i<10; i++) {
			for ( int j=0; j<10; j++) {
				board[i][j]= new Ocean(); 
			}
		}
		
	}

//Method that sets ships	
	public void setShip(Position position, Ship ship) {
		if (ship.getDirection()== Direction.VERTICAL ) {
			for (int i= 0; i<ship.getLength() ; i++) {
				board[position.getX()+i][position.getY()]= ship;
			}
		}
	
		
		else if (ship.getDirection()== Direction.HORIZONTAL ) {
			for (int i= 0; i<ship.getLength() ; i++) {
				board[position.getX()][position.getY()+i]= ship;
			}
		}
		else if (ship.getDirection()== Direction.DIAGONAL ) {
			for (int i= 0; i<ship.getLength() ; i++) {
				board[position.getX()+i][position.getY()+i]= ship;
			}
		}
	}
	
	
//Method that lets each player set obstacles	
	public void setObstacle(Position position, String obstacleType) {
	    BoardElements element = board[position.getX()][position.getY()];
	    if (element instanceof Ocean) {
	        Obstacle obstacle = new Obstacle(obstacleType);
	        obstacle.setPosition(position.getX(), position.getY());
	        setBoardElement(position, obstacle);
	    }
	}
	
	
	private void setBoardElement(Position position, BoardElements element) {
	    board[position.getX()][position.getY()] = element;
	}
	
	
	public BoardElements getBoardElement (Position position) {
		return board [position.getX()][position.getY()];
		
	}
	//Making a move == setting a bomb
	public void setBomb(int X, int Y, Bomb bomb, Player currentPlayer) {
        BoardElements element = board[X][Y];
        if (element instanceof Ship) {
            // Bomb hit a ship
           //successfulMoves.add(new Position(X, Y));
           currentPlayer.getSuccessfulMoves().add(new Position(X, Y));
        } else if (element instanceof Ocean || element instanceof Obstacle) {
            // Bomb missed
            board[X][Y] = new Miss();
        }
    }
	
	
	//Checking if it is valid to place a ship on a certain position 
	public boolean isValid(Position position, Ship ship) {
	    if (position.getX() < 0 || position.getX() + ship.getLength() > 10 || 
	        position.getY() < 0 || position.getY() + ship.getLength() > 10) {
	        // Out of bounds
	        return false;
	    }

	    // Check if there's another ship in the given position
	    for (int i = 0; i < ship.getLength(); i++) {
	        int x = position.getX();
	        int y = position.getY();

	        if (ship.getDirection() == Direction.HORIZONTAL) {
	            y += i;
	        } else {
	            x += i;
	        }

	        if (board[x][y] instanceof Ship) {
	            // There's already a ship in the given position
	            return false;
	        }
	    }

	    // The position is valid
	    return true;
	}
	
	//Method to display the board
	
	public void printBoard() {
		System.out.println("+---------+");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (board[i][j] instanceof Ocean) {
					System.out.print('o');
				}

				else  if (board[i][j] instanceof Ship) {
					System.out.print('+');
				}
				else if (board[i][j] instanceof Bomb) {
					System.out.print('-');
				}
				else if (board[i][j] instanceof Miss) {
					System.out.print('x');
				}
			}
			System.out.println();
		}
		System.out.println("+---------+");
	}

}
