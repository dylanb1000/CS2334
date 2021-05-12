

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NonogramView extends BorderPane implements View{
private RowCluesView left;
private ColCluesView top;
private CellGridView center;
BorderPane borderPane=new BorderPane();
Rectangle fill;
private static final String STYLE_CLASS = "nonogram-view";
private static final String STYLE_CLASS_SOLVED = "nonogram-view-solved";
NonogramView(int[][] rowClues,int[][] colClues,int cellLength){
	getStyleClass().add(STYLE_CLASS);
	int rowGreatestWidth=0;
	int colGreatestWidth=0;
	for(int i=0;i<rowClues.length;i++) {
		if(rowClues[i].length>rowGreatestWidth) {
			rowGreatestWidth=rowClues[i].length;
		}
	}
	for(int i=0;i<colClues.length;i++) {
		if(colClues[i].length>colGreatestWidth) {
			colGreatestWidth=colClues[i].length;
		}
	}
	this.left=new RowCluesView(rowClues,cellLength,rowGreatestWidth);
	this.top=new ColCluesView(colClues,cellLength,colGreatestWidth);
	this.center=new CellGridView(rowClues.length,colClues.length,cellLength);
	this.borderPane.setLeft(left.vbox);
	BorderPane box=new BorderPane();
	fill=new Rectangle(rowGreatestWidth*cellLength,colGreatestWidth*cellLength,rowGreatestWidth*cellLength,colGreatestWidth*cellLength);
	fill.setFill(Color.web("#f4f4f4"));
	box.setLeft(fill);
	box.setRight(top.hbox);
	this.borderPane.setTop(box);
	this.borderPane.setTop(box);
	this.borderPane.setCenter(center.gridPane);
	
	
}
@Override
public void setCellState(int rowIdx, int colIdx, CellState state) {
	this.center.setCellState(rowIdx, colIdx, state);
}
@Override
public void setRowClueState(int rowIdx, boolean solved) {
	this.left.setRowState(rowIdx, solved);
}
@Override
public void setColClueState(int colIdx, boolean solved) {
	this.top.setColState(colIdx, solved);
	
}
@Override
public void setPuzzleState(boolean solved) {
	if(solved==true) {
		getStyleClass().add(STYLE_CLASS_SOLVED);
		fill.setFill(Color.web("#114E60"));
	}
	else if(solved==false){
		getStyleClass().remove(STYLE_CLASS_SOLVED);
	}
}
@Override
public void register(Presenter presenter) {
	this.center.register(presenter);
	
}
}
