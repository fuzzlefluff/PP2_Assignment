import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class CheckerGrid {
	
	//DataFields
	//size of the grid
	final int gridSize = 8;
	//Boolean to keep track of what turn it is
	static boolean isBlackTurn = true;
	//Boolean to keep track of if a piece is selected
	static boolean  isAnyPieceSelected = false;
	//Holds the currently selected piece
	static checkerPiece currentselectedpiece;
	//Label that displays which player's turn it is
	Label currentTurn;
	//Holds the gridPane to display things with
	public GridPane SquaregridPane;
	//the array of checkerSquares
	checkerSquare[][] squareArray;
	//Keeps track of if a piece needs to be deleted
	static boolean isPieceDelete;
	//keeps track of skipped location
	public int skipX;
	public int skipY;
	boolean forceJump;
	
	//The Constructor for our checkers game object
	public CheckerGrid(BorderPane borderPane, HBox botBanner) 
	{
		isPieceDelete = false;
		//Create a grid Pane to display things with
		SquaregridPane = new GridPane();
		//create an array of checker squares
		squareArray = new checkerSquare[gridSize][gridSize];
		//create a label to display the current player's turn with
		currentTurn = new Label();
		currentTurn.setStyle("-fx-background-color: #C6E3FF;");
		currentTurn.setText("Current Turn: Black");
		
		//create and fill our array with checker square objects
		for(int i =0; i<gridSize; i++) {for(int c=0; c<gridSize; c++){
				squareArray[i][c] = new checkerSquare(i,c,SquaregridPane,borderPane,botBanner,this);
				SquaregridPane.add(squareArray[i][c].drawRect,i,c);}}
		//create and fill the checker squares with checker pieces at the appropriate places
		for(int i =0; i<gridSize; i++) {for(int c=0; c<gridSize; c++){
				if((i+c)%2==0 && (c<3||c>4)){
				checkerPiece piece = new checkerPiece(i,c,SquaregridPane, this);
				if(c>4){piece.drawCircle.setFill(Color.BLACK); piece.isBlack = true;}
				squareArray[i][c].placedCheckerPiece = piece; squareArray[i][c].hasPlacedPiece = true;}}
		//End of Constructor
		}
	}
	
	//A Method that highlights the right checker squares to let the player choose where to place a piece
	public void highlightPositions(int x, int y)
	{
		forceJump = false;
//////////////Piece is a King
		if(currentselectedpiece.isKing == true) 
		{
			//If the piece is at the top
			if(y == gridSize - 1) 
			{
				//Check Second Square
					//if the square has an enemy
						if(squareArray[x+1][y-1].hasPlacedPiece == true && squareArray[x+1][y-1].placedCheckerPiece.isBlack == false) 
							{if(squareArray[x+2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y-2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x+1][y-1].hasPlacedPiece == false && forceJump == false) {squareArray[x+1][y-1].drawRect.setStroke(Color.CYAN);}
				//Check Fourth Square
					//if the square has an enemy
						if(squareArray[x-1][y-1].hasPlacedPiece == true && squareArray[x-1][y-1].placedCheckerPiece.isBlack == false) 
							{if(squareArray[x-2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y-2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x-1][y-1].hasPlacedPiece == false && forceJump == false) {squareArray[x-1][y-1].drawRect.setStroke(Color.CYAN);}
			
			return;
			}
			if (y == 0)
			{
				//Checker First Square
					//if the square has an enemy
						if(squareArray[x+1][y+1].hasPlacedPiece == true && squareArray[x+1][y+1].placedCheckerPiece.isBlack == false) 
							{if(squareArray[x+2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y+2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x+1][y+1].hasPlacedPiece == false && forceJump == false) {squareArray[x+1][y+1].drawRect.setStroke(Color.CYAN);}
				//Check Third Square
					//if the square has an enemy
						if(squareArray[x-1][y+1].hasPlacedPiece == true && squareArray[x-1][y+1].placedCheckerPiece.isBlack == false) 
							{if(squareArray[x-2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y+2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x-1][y+1].hasPlacedPiece == false && forceJump == false) {squareArray[x-1][y+1].drawRect.setStroke(Color.CYAN);}
				
			return;
			}
			//Black
			if(currentselectedpiece.drawCircle.getFill().equals(Color.BLACK)) 
			{
				//Checker First Square
					//if the square has an enemy
						if(squareArray[x+1][y+1].hasPlacedPiece == true && squareArray[x+1][y+1].placedCheckerPiece.isBlack == false) 
							{if(squareArray[x+2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y+2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x+1][y+1].hasPlacedPiece == false && forceJump == false) {squareArray[x+1][y+1].drawRect.setStroke(Color.CYAN);}
				//Check Second Square
					//if the square has an enemy
						if(squareArray[x+1][y-1].hasPlacedPiece == true && squareArray[x+1][y-1].placedCheckerPiece.isBlack == false) 
							{if(squareArray[x+2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y-2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x+1][y-1].hasPlacedPiece == false && forceJump == false) {squareArray[x+1][y-1].drawRect.setStroke(Color.CYAN);}
				//Check Third Square
					//if the square has an enemy
						if(squareArray[x-1][y+1].hasPlacedPiece == true && squareArray[x-1][y+1].placedCheckerPiece.isBlack == false) 
							{if(squareArray[x-2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y+2].drawRect.setStroke(Color.CYAN); }}
					//if the square is empty
						if(squareArray[x-1][y+1].hasPlacedPiece == false && forceJump == false) {squareArray[x-1][y+1].drawRect.setStroke(Color.CYAN);}
				//Check Fourth Square
					//if the square has an enemy
						if(squareArray[x-1][y-1].hasPlacedPiece == true && squareArray[x-1][y-1].placedCheckerPiece.isBlack == false) 
							{if(squareArray[x-2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y-2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x-1][y-1].hasPlacedPiece == false && forceJump == false) {squareArray[x-1][y-1].drawRect.setStroke(Color.CYAN);}
			}
			//Red
			if(currentselectedpiece.drawCircle.getFill().equals(Color.RED)) 
			{
				//Checker First Square
					//if the square has an enemy
						if(squareArray[x+1][y+1].hasPlacedPiece == true && squareArray[x+1][y+1].placedCheckerPiece.isBlack == true) 
							{if(squareArray[x+2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y+2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x+1][y+1].hasPlacedPiece == false && forceJump == false) {squareArray[x+1][y+1].drawRect.setStroke(Color.CYAN);}
				//Check Second Square
					//if the square has an enemy
						if(squareArray[x+1][y-1].hasPlacedPiece == true && squareArray[x+1][y-1].placedCheckerPiece.isBlack == true) 
							{if(squareArray[x+2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y-2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x+1][y-1].hasPlacedPiece == false && forceJump == false) {squareArray[x+1][y-1].drawRect.setStroke(Color.CYAN);}
				//Check Third Square
					//if the square has an enemy
						if(squareArray[x-1][y+1].hasPlacedPiece == true && squareArray[x-1][y+1].placedCheckerPiece.isBlack == true) 
							{if(squareArray[x-2][y+2].hasPlacedPiece == false) {isPieceDelete = true;forceJump = true; squareArray[x-2][y+2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x-1][y+1].hasPlacedPiece == false && forceJump == false) {squareArray[x-1][y+1].drawRect.setStroke(Color.CYAN);}
				//Check Fourth Square
					//if the square has an enemy
						if(squareArray[x-1][y-1].hasPlacedPiece == true && squareArray[x-1][y-1].placedCheckerPiece.isBlack == true) 
							{if(squareArray[x-2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y-2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x-1][y-1].hasPlacedPiece == false && forceJump == false) {squareArray[x-1][y-1].drawRect.setStroke(Color.CYAN);}
			}
		return;
		}
//////////////Piece is on Left Edge
			if(x == 0) 
			{
				//Black
				if(currentselectedpiece.drawCircle.getFill().equals(Color.BLACK) ) 
				{
					//Check First Square
						//if the square has an enemy
							if(squareArray[x+1][y-1].hasPlacedPiece == true && squareArray[x+1][y-1].placedCheckerPiece.isBlack == false) 
								{ if( squareArray[x+2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y-2].drawRect.setStroke(Color.CYAN);}}
						//if the square is empty
							if(squareArray[x+1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y-1].drawRect.setStroke(Color.CYAN);}
				
				}
				//Red
				if(currentselectedpiece.drawCircle.getFill().equals(Color.RED) ) 
				{
					//Check First Square
						//if the square has an enemy
							if(squareArray[x+1][y+1].hasPlacedPiece == true && squareArray[x+1][y+1].placedCheckerPiece.isBlack == true) 
								{ if(squareArray[x+2][y+2].hasPlacedPiece == false) { isPieceDelete = true; forceJump = true; squareArray[x+2][y+2].drawRect.setStroke(Color.CYAN);}}
						//if the square is empty
							if(squareArray[x+1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y+1].drawRect.setStroke(Color.CYAN);}
				
				}
			return;
			}
//////////////Piece is on Right Edge
			if(x == gridSize -1) 
			{
				//Black
					if(currentselectedpiece.drawCircle.getFill().equals(Color.BLACK) ) 
					{
						//Check First Square
							//if the square has an enemy
								if(squareArray[x-1][y-1].hasPlacedPiece == true && squareArray[x-1][y-1].placedCheckerPiece.isBlack == false) 
									{ if( squareArray[x-2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y-2].drawRect.setStroke(Color.CYAN);}}
							//if the square is empty
								if(squareArray[x-1][y-1].hasPlacedPiece == false && forceJump == false) {isPieceDelete = true; squareArray[x-1][y-1].drawRect.setStroke(Color.CYAN);}
					}
				//Red
					if(currentselectedpiece.drawCircle.getFill().equals(Color.RED)) 
					{
						//Check First Square
							//if the square has an enemy
								if(squareArray[x-1][y+1].hasPlacedPiece == true && squareArray[x-1][y+1].placedCheckerPiece.isBlack == true) 
									{ if(squareArray[x-2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y+2].drawRect.setStroke(Color.CYAN);}}
							//if the square is empty
								if(squareArray[x-1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y+1].drawRect.setStroke(Color.CYAN);}
				
					}
			return;
			}
//////////////Piece is 1 away from Left Edge
			if( x == 1) 
			{
				//Black
				if(currentselectedpiece.drawCircle.getFill().equals(Color.BLACK) ) 
				{
					//Check First Square
						//if the square has an enemy
							if(squareArray[x+1][y-1].hasPlacedPiece == true && squareArray[x+1][y-1].placedCheckerPiece.isBlack == false) 
								{ if( squareArray[x+2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y-2].drawRect.setStroke(Color.CYAN);}}
						//if the square is empty
							if(squareArray[x+1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y-1].drawRect.setStroke(Color.CYAN);}
					//Check Second Square
						//if the square has an enemy
							if(squareArray[x-1][y-1].hasPlacedPiece == true && squareArray[x-1][y-1].placedCheckerPiece.isBlack == false) 
								{ }
						//if the square is empty
							if(squareArray[x-1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y-1].drawRect.setStroke(Color.CYAN);}
				}
				//Red
				if(currentselectedpiece.drawCircle.getFill().equals(Color.RED) ) 
				{
					//Check First Square
						//if the square has an enemy
							if(squareArray[x+1][y+1].hasPlacedPiece == true && squareArray[x+1][y+1].placedCheckerPiece.isBlack == true) 
								{ if(squareArray[x+2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y+2].drawRect.setStroke(Color.CYAN);}}
						//if the square is empty
							if(squareArray[x+1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y+1].drawRect.setStroke(Color.CYAN);}
					//Check Second Square
						//if the square has an enemy
							if(squareArray[x-1][y+1].hasPlacedPiece == true && squareArray[x-1][y+1].placedCheckerPiece.isBlack == true) 
								{}
						//if the square is empty
							if(squareArray[x-1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y+1].drawRect.setStroke(Color.CYAN);}
				}
			return;
			}
//////////////Piece is 1 away from Right Edge
			if(x == gridSize - 2){
			//Black
				if(currentselectedpiece.drawCircle.getFill().equals(Color.BLACK) ) 
				{
				//Check First Square
					//if the square has an enemy
						if(squareArray[x+1][y-1].hasPlacedPiece == true && squareArray[x+1][y-1].placedCheckerPiece.isBlack == false) 
							{ }
					//if the square is empty
						if(squareArray[x+1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y-1].drawRect.setStroke(Color.CYAN);}
				//Check Second Square
					//if the square has an enemy
						if(squareArray[x-1][y-1].hasPlacedPiece == true && squareArray[x-1][y-1].placedCheckerPiece.isBlack == false) 
							{ if( squareArray[x-2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y-2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x-1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y-1].drawRect.setStroke(Color.CYAN);}
				}
			//Red
				if(currentselectedpiece.drawCircle.getFill().equals(Color.RED) ) 
				{
				//Check First Square
					//if the square has an enemy
						if(squareArray[x+1][y+1].hasPlacedPiece == true && squareArray[x+1][y+1].placedCheckerPiece.isBlack == true) 
							{}
					//if the square is empty
						if(squareArray[x+1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y+1].drawRect.setStroke(Color.CYAN);}
				//Check Second Square
					//if the square has an enemy
						if(squareArray[x-1][y+1].hasPlacedPiece == true && squareArray[x-1][y+1].placedCheckerPiece.isBlack == true) 
							{ if(squareArray[x-2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y+2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x-1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y+1].drawRect.setStroke(Color.CYAN);}
				}
			return;
			}
//////////////Piece is one away from top
			if(y == 1) 
			{
				//Black
				if(currentselectedpiece.drawCircle.getFill().equals(Color.BLACK) ) 
				{
					//Check First Square
						//if the square has an enemy
							if(squareArray[x+1][y-1].hasPlacedPiece == true && squareArray[x+1][y-1].placedCheckerPiece.isBlack == false) 
								{ }
						//if the square is empty
							if(squareArray[x+1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y-1].drawRect.setStroke(Color.CYAN);}
					//Check Second Square
						//if the square has an enemy
							if(squareArray[x-1][y-1].hasPlacedPiece == true && squareArray[x-1][y-1].placedCheckerPiece.isBlack == false) 
								{ }
						//if the square is empty
							if(squareArray[x-1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y-1].drawRect.setStroke(Color.CYAN);}
				}
				//Red
				if(currentselectedpiece.drawCircle.getFill().equals(Color.RED) ) 
				{
					//Check First Square
						//if the square has an enemy
							if(squareArray[x+1][y+1].hasPlacedPiece == true && squareArray[x+1][y+1].placedCheckerPiece.isBlack == true) 
								{if(squareArray[x+2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y+2].drawRect.setStroke(Color.CYAN);}}
						//if the square is empty
							if(squareArray[x+1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y+1].drawRect.setStroke(Color.CYAN);}
					//Check Second Square
						//if the square has an enemy
							if(squareArray[x-1][y+1].hasPlacedPiece == true && squareArray[x-1][y+1].placedCheckerPiece.isBlack == true) 
								{if(squareArray[x-2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y+2].drawRect.setStroke(Color.CYAN);}}
						//if the square is empty
							if(squareArray[x-1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y+1].drawRect.setStroke(Color.CYAN);}
				}
			return;
			}
//////////////Piece is one away from bottom
		if(y == gridSize - 2)
		{
			//Black
			if(currentselectedpiece.drawCircle.getFill().equals(Color.BLACK) ) 
			{
			//Check First Square
				//if the square has an enemy
					if(squareArray[x+1][y-1].hasPlacedPiece == true && squareArray[x+1][y-1].placedCheckerPiece.isBlack == false) 
						{ if( squareArray[x+2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y-2].drawRect.setStroke(Color.CYAN);}}
				//if the square is empty
					if(squareArray[x+1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y-1].drawRect.setStroke(Color.CYAN);}
			//Check Second Square
				//if the square has an enemy
					if(squareArray[x-1][y-1].hasPlacedPiece == true && squareArray[x-1][y-1].placedCheckerPiece.isBlack == false) 
						{ if( squareArray[x-2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y-2].drawRect.setStroke(Color.CYAN);}}
				//if the square is empty
					if(squareArray[x-1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y-1].drawRect.setStroke(Color.CYAN);}
			}
			//Red
			if(currentselectedpiece.drawCircle.getFill().equals(Color.RED) ) 
			{
			//Check First Square
				//if the square has an enemy
					if(squareArray[x+1][y+1].hasPlacedPiece == true && squareArray[x+1][y+1].placedCheckerPiece.isBlack == true) 
						{}
				//if the square is empty
					if(squareArray[x+1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y+1].drawRect.setStroke(Color.CYAN);}
			//Check Second Square
				//if the square has an enemy
					if(squareArray[x-1][y+1].hasPlacedPiece == true && squareArray[x-1][y+1].placedCheckerPiece.isBlack == true) 
						{ }
				//if the square is empty
					if(squareArray[x-1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y+1].drawRect.setStroke(Color.CYAN);}
			}
		return;
		}
//////////////Regular Pieces
			//Black
				if(currentselectedpiece.drawCircle.getFill().equals(Color.BLACK) ) 
				{
				//Check First Square
					//if the square has an enemy
						if(squareArray[x+1][y-1].hasPlacedPiece == true && squareArray[x+1][y-1].placedCheckerPiece.isBlack == false) 
							{ if( squareArray[x+2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y-2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x+1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y-1].drawRect.setStroke(Color.CYAN);}
				//Check Second Square
					//if the square has an enemy
						if(squareArray[x-1][y-1].hasPlacedPiece == true && squareArray[x-1][y-1].placedCheckerPiece.isBlack == false) 
							{ if( squareArray[x-2][y-2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y-2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x-1][y-1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y-1].drawRect.setStroke(Color.CYAN);}
				}
			//Red
				if(currentselectedpiece.drawCircle.getFill().equals(Color.RED) ) 
				{
				//Check First Square
					//if the square has an enemy
						if(squareArray[x+1][y+1].hasPlacedPiece == true && squareArray[x+1][y+1].placedCheckerPiece.isBlack == true) 
							{ if(squareArray[x+2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x+2][y+2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x+1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x+1][y+1].drawRect.setStroke(Color.CYAN);}
				//Check Second Square
					//if the square has an enemy
						if(squareArray[x-1][y+1].hasPlacedPiece == true && squareArray[x-1][y+1].placedCheckerPiece.isBlack == true) 
							{ if(squareArray[x-2][y+2].hasPlacedPiece == false) {isPieceDelete = true; forceJump = true; squareArray[x-2][y+2].drawRect.setStroke(Color.CYAN);}}
					//if the square is empty
						if(squareArray[x-1][y+1].hasPlacedPiece == false && forceJump == false) { squareArray[x-1][y+1].drawRect.setStroke(Color.CYAN);}
				}
	//End of Method
	}
	
	//A Method that undoes the highlightPositions method
	public void deHighlightPositions (int x, int y) 
	{
		forceJump = false;
		for(int i=0; i<gridSize; i++) 
		{
			for(int c=0; c<gridSize; c++) {isPieceDelete = false; squareArray[i][c].drawRect.setStroke(Color.BLACK);}
		}
	}
	
//EndofClass
}
