import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class PuzzleLoader extends GridPane{
int MIN_CELL_LENGTH=20;
int MAX_CELL_LENGTH=50;
int DEFAULT_CELL_LENGTH=30;
int SPACING=10;
private static final int PADDING_AMT = 20;
GridPane gridForm=new GridPane();
public PuzzleLoader(Main main) {
	gridForm.setAlignment(Pos.CENTER);
	gridForm.setHgap(SPACING);
	gridForm.setVgap(SPACING);
	gridForm.setPadding(new Insets(PADDING_AMT));
	
	Label lblNano = new Label("Nanogram file:  ");
	gridForm.add(lblNano, 0, 2);
	
	TextField file=new TextField();
	file.setPromptText("Enter file name");
	HBox textBox = new HBox(SPACING);
	textBox.getChildren().add(file);
	gridForm.add(textBox, 1, 2);
	
	Label lblCellSideLength = new Label("Cell side length (px):  ");
	gridForm.add(lblCellSideLength, 0, 3);
	
	Spinner<Integer> cellSlider = new Spinner<>(MIN_CELL_LENGTH, MAX_CELL_LENGTH, DEFAULT_CELL_LENGTH);
	gridForm.add(cellSlider, 1, 3);
	
	Button loadPuzzleButton= new Button("Load Puzzle");
	gridForm.add(loadPuzzleButton, 1, 4);
	
//finish eventhandler***
	// Go button action
	loadPuzzleButton.setOnAction(new EventHandler<ActionEvent>() {
		private static final String ERROR1 = "File could not be read.";

		
		@Override
		public void handle(ActionEvent event) {
			String fileName=file.getText();
			if(fileName==null) {
				Alert alert=new Alert(AlertType.ERROR, ERROR1);
				alert.showAndWait();
			}
			
			else {
				// Create Game
				try {
				int cellLength=cellSlider.getValue();
				NonogramModel Model;
				Model=new NonogramModel(fileName);
				// Change focused scene
				main.startNonogramPlayer(Model, cellLength);
				
				}
				catch(IOException e){
					Alert alert=new Alert(AlertType.ERROR, ERROR1);
					alert.showAndWait();
				}
				
			}
		}
	});
}
}
