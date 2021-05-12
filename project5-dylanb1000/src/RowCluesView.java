import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.VBox;

public class RowCluesView extends VBox{
private List<RowClueView> rowCluesView=new ArrayList<RowClueView>();
VBox vbox= new VBox();
public RowCluesView(int[][] rowClues,int cellLength,int width) {
	for(int i=0;i<rowClues.length;i++) {
		RowClueView row=new RowClueView(rowClues[i],cellLength,width);
		rowCluesView.add(row);
		vbox.getChildren().add(row);
	}
}
public void setRowState(int rowIdx,boolean solved) {
	rowCluesView.get(rowIdx).setState(solved);
}
}
