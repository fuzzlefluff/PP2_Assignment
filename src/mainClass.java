import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class mainClass extends Application{

	

	@Override
	public void start(Stage mainStage) throws Exception {
		
		//StartObjects
		BorderPane mainBorderPane = new BorderPane();
		mainBorderPane.setMinSize(0, 0);
		Scene mainScene = new Scene(mainBorderPane,500,500);
		mainStage.setScene(mainScene);
		
		
		
		
		//Objects
		HBox bottomBannerBox = new HBox();
		bottomBannerBox.setStyle("-fx-background-color: #4D9900;");
		CheckerGrid checkerPlay = new CheckerGrid(mainBorderPane,bottomBannerBox);
		
		Button newGameAI = new Button();
		newGameAI.setText("New Game 1 Player");
		newGameAI.setOnMouseClicked(e -> {
			mainBorderPane.setCenter(checkerPlay.SquaregridPane);
		}); 
		Button newGameUS = new Button();
		newGameUS.setText("New Game 2 Players");
		
		bottomBannerBox.getChildren().add(checkerPlay.currentTurn);
		bottomBannerBox.getChildren().add(newGameAI);
		bottomBannerBox.getChildren().add(newGameUS);
		
		//BackGround Rectangle
		Rectangle backRectangle = new Rectangle();
		backRectangle.heightProperty().bind(mainScene.heightProperty());
		backRectangle.widthProperty().bind(mainScene.widthProperty());
		backRectangle.setFill(Color.BROWN);
		
		//Display
		mainBorderPane.getChildren().add(backRectangle);
		
		mainBorderPane.setBottom(bottomBannerBox);
		mainStage.setTitle("Checkers");
		mainStage.show();
	}
	
	//mainMethod for Eclipse IDE
	public static void main(String[] args) {launch();}
	
//EndofClass
}
