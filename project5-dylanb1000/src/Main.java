


import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application{
private static String TITLE="Nonogram Player";
private boolean RESIZABLE=false;
private String STYLE_SHEET="style.css";
private static Stage primaryStage;
public static void main(String[] args) throws Exception {
	launch(args);
	}
public void start(Stage primaryStage) throws Exception{
	PuzzleLoader grid=new PuzzleLoader(this);
	GridPane gridForm = grid.gridForm;
	Scene mainScene=new Scene(gridForm,320,150);
	this.primaryStage=primaryStage;
	this.primaryStage.setTitle(TITLE);
	
	
	this.primaryStage.setScene(mainScene);
	
	this.primaryStage.show();
	
	}
public void startNonogramPlayer(Model model,int cellLength) {
	this.primaryStage.close();
	int[][] row = new int[model.getNumRows()][];
	int[][] col=new int[model.getNumCols()][];
	for(int i=0;i<model.getNumRows();i++) {
		row[i]=new int[model.getRowClue(i).length];
		for (int j=0;j<model.getRowClue(i).length;j++){
			row[i][j]=model.getRowClue(i)[j];
		}
	}
	for(int i=0;i<model.getNumCols();i++) {
		col[i]=new int[model.getColClue(i).length];
		for (int j=0;j<model.getColClue(i).length;j++){
			col[i][j]=model.getColClue(i)[j];
		}
	}
	NonogramView view=new NonogramView(row,col,cellLength);
	Presenter presenter=new Presenter(model,view);
	view.register(presenter);
	BorderPane borderPane=view.borderPane;
	
	Scene mainScene=new Scene(borderPane);
	mainScene.getStylesheets().add("style.css");
	Stage Stage=new Stage();
	Stage.setTitle(TITLE);
	Stage.setScene(mainScene);
	
	
	Stage.show();
	this.primaryStage.close();
	}
}

