import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class checkerSquare {
	
	//The rectangle that is drawn to represent the square
	Rectangle drawRect;
	//X cordinate
	int xCord;
	//Y Cordinate
	int yCord;
	//Holds a checker piece that might exist on the square
	public checkerPiece placedCheckerPiece;
	//Keeps track of it the checkerPiece exists or not
	public boolean hasPlacedPiece;
	//Holds the gridPane
	GridPane gridPane;
	//Holds the checker play object
	CheckerGrid checkerGridObj;
	//The Consturctor
	public checkerSquare(int x, int y, GridPane gridPane,BorderPane borderPane,HBox botBaner,CheckerGrid checkerGridObj)
	{
		this.checkerGridObj = checkerGridObj;
		this.gridPane = gridPane;
		xCord = x;
		yCord = y;
		drawRect = new Rectangle();
		drawRect.setHeight(10);
		drawRect.setWidth(10);
		drawRect.setArcHeight(25);
		drawRect.setArcWidth(25);
		drawRect.widthProperty().bind(borderPane.widthProperty().divide(8));
		drawRect.heightProperty().bind(borderPane.heightProperty().divide(8).subtract(botBaner.heightProperty().divide(8)));
		if(((xCord+yCord) %2) == 0) {drawRect.setFill(Color.TAN);}
		else {drawRect.setFill(Color.DIMGREY);}
		drawRect.setStroke(Color.BLACK);
		if((xCord+yCord) %2==0) 
		{
			drawRect.setOnMouseClicked(e -> {
			if(CheckerGrid.isAnyPieceSelected == true && drawRect.getStroke().equals(Color.CYAN)) 
			{
				drawRect.setStroke(Color.BLACK);
				CheckerGrid.currentselectedpiece.updatePosition(xCord, yCord); 
			}
			}); 
		}
	//End of Constructor
	}
	public void deleteHeldPiece() 
	{
		gridPane.getChildren().remove(placedCheckerPiece.drawCircle);
	}
//End of Class
}
