import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.HBox;

public class ColCluesView extends HBox{
private List<ColClueView> colCluesView=new ArrayList<ColClueView>();
HBox hbox= new HBox();
public ColCluesView(int[][] colClues,int cellLength,int width) {
		for(int i=0;i<colClues.length;i++) {
			ColClueView col=new ColClueView(colClues[i],cellLength,width);
			colCluesView.add(col);
			hbox.getChildren().add(col);
		}
	}
	public void setColState(int colIdx,boolean solved) {
		colCluesView.get(colIdx).setState(solved);
	}
}
