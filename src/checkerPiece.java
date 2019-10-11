import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class checkerPiece {
	
	//The Circle that is drawn to represent the checker piece
	Circle drawCircle;
	//keeps track of if the piece is selected
	boolean isSelected;
	//keeps track of it the piece is a king
	boolean isKing;
	//keeps track of which team the piece is on
	boolean isBlack;
	int xCord;
	int yCord;
	//holds the grid pane that is drawn to the screen
	GridPane gridPane;
	//holds the parent object
	CheckerGrid checkerGridObj;
	
	public checkerPiece(int x, int y, GridPane gridPane, CheckerGrid checkerObj )
	{
		xCord = x;
		yCord = y;
		isKing = false;
		checkerGridObj = checkerObj;
		this.gridPane = gridPane;
		drawCircle = new Circle(); 
		drawCircle.setFill(Color.RED);
		isBlack = false;
		drawCircle.setStroke(Color.BLACK);
		drawCircle.setRadius(10);
		drawCircle.radiusProperty().bind(gridPane.widthProperty().divide(20));
		drawCircle.centerXProperty().bind(gridPane.widthProperty().divide(8));
		drawCircle.centerYProperty().bind(gridPane.heightProperty().divide(8));
		drawCircle.setOnMouseClicked(IntputEvent -> 
			{
				if(isSelected == false && CheckerGrid.isAnyPieceSelected == false && CheckerGrid.isBlackTurn == true && drawCircle.getFill().equals(Color.BLACK)) 
				{
					drawCircle.setStroke(Color.YELLOW); 
					isSelected = true;
					CheckerGrid.isAnyPieceSelected = true;
					CheckerGrid.currentselectedpiece = this;
					checkerGridObj.highlightPositions(xCord, yCord);
					System.out.println("NewPiece Selected");
					System.out.print("Xcord: "+ xCord+" || ");
					System.out.println("Ycord: "+ yCord);
				}
				else if (isSelected == false && CheckerGrid.isAnyPieceSelected == false && CheckerGrid.isBlackTurn == false && drawCircle.getFill().equals(Color.RED)) 
				{
					drawCircle.setStroke(Color.YELLOW); 
					isSelected = true;
					CheckerGrid.currentselectedpiece = this;
					CheckerGrid.isAnyPieceSelected = true;
					checkerGridObj.highlightPositions(xCord, yCord);
					System.out.println("NewPiece Selected");
					System.out.print("Xcord: "+ xCord+" || ");
					System.out.println("Ycord: "+ yCord);
					
				}
				else if(isSelected == true) 
				{
					if(isKing == false) {drawCircle.setStroke(Color.BLACK);}
					else if (isKing == true) {drawCircle.setStroke(Color.WHITE);}
					isSelected = false;
					CheckerGrid.isAnyPieceSelected = false;
					checkerGridObj.deHighlightPositions(xCord, yCord);
				}
			});
			
				
			
			gridPane.add(drawCircle, x, y);	
	}
	public void updatePosition(int x, int y)
	{
		int oneX =0;
		int oneY =0;
		if(xCord > x && yCord < y ) {oneX = xCord-1; oneY = yCord+1;}
		if(xCord < x && yCord < y ) {oneX = xCord+1; oneY = yCord+1;}
		if(xCord > x && yCord > y ) {oneX = xCord-1; oneY = yCord-1;}
		if(xCord < x && yCord > y ) {oneX = xCord+1; oneY = yCord-1;}
		if(x == oneX || y == oneY) {CheckerGrid.isPieceDelete = false;}
		if(CheckerGrid.isPieceDelete == true) 
		{gridPane.getChildren().remove(checkerGridObj.squareArray[oneX][oneY].placedCheckerPiece.drawCircle); 
		checkerGridObj.squareArray[oneX][oneY].hasPlacedPiece = false; 
		checkerGridObj.squareArray[oneX][oneY].placedCheckerPiece = null; 
		CheckerGrid.isPieceDelete = false;}
		checkerGridObj.squareArray[xCord][yCord].hasPlacedPiece = false;
		checkerGridObj.deHighlightPositions(xCord, yCord);
		xCord = x;
		yCord = y;
		isSelected = false;
		if(isKing == false) {drawCircle.setStroke(Color.BLACK);}
		else if(isKing == true) {drawCircle.setStroke(Color.SNOW);}
		CheckerGrid.isAnyPieceSelected = false;
		if(CheckerGrid.isBlackTurn == false) { checkerGridObj.currentTurn.setText("Current Turn: Black"); CheckerGrid.isBlackTurn = true;}
		else if(CheckerGrid.isBlackTurn == true) {checkerGridObj.currentTurn.setText("Current Turn: Red"); CheckerGrid.isBlackTurn = false;}
		if(drawCircle.getFill().equals(Color.BLACK) && y == 0) {isKing = true; drawCircle.setStroke(Color.SNOW);}
		else if (drawCircle.getFill().equals(Color.RED) && y == checkerGridObj.gridSize - 1) {isKing = true; drawCircle.setStroke(Color.WHITE);}
		checkerGridObj.squareArray[xCord][yCord].hasPlacedPiece = true;
		checkerGridObj.squareArray[xCord][yCord].placedCheckerPiece = this;
		
		gridPane.getChildren().remove(this.drawCircle);
		gridPane.add(this.drawCircle, x, y);
	}
//EndOfClass
}
