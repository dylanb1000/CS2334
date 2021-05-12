
public class Presenter{
private Model model;
private View view;
public Presenter(Model model, View view) {
	this.model=model;
	this.view=view;
	int rowNum=model.getNumRows();
	int colNum=model.getNumCols();
	for(int i=0;i<rowNum;i++) {
		if(model.isRowSolved(i)==true) {
			view.setRowClueState(i, true);
		}
		else {
			view.setRowClueState(i, false);
		}
	}
	for(int i=0;i<colNum;i++) {
		if(model.isColSolved(i)==true) {
			view.setColClueState(i, true);
		}
		else {
			view.setColClueState(i, false);
		}
	}
	for(int i=0;i<rowNum;i++) {
		for(int j=0;j<colNum;j++) {
			view.setCellState(i, j, model.getCellState(i, j));
		}
	}
	if(model.isSolved()==true) {
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				if(model.getCellState(i, j)==CellState.MARKED) {
				view.setCellState(i, j, CellState.EMPTY);
				}
			}
		}
		view.setPuzzleState(true);
	}
	view.setPuzzleState(model.isSolved());
	view.register(this);
	
}
public void cellClicked(int rowIdx,int colIdx,boolean primaryButton) {
	CellState currentState=model.getCellState(rowIdx, colIdx);
	if(model.isSolved()==true) {
		int rowNum=model.getNumRows();
		int colNum=model.getNumCols();
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				if(model.getCellState(i, j)==CellState.MARKED) {
				view.setCellState(i, j, CellState.EMPTY);
				}
			}
		}
		view.setPuzzleState(true);
	}
	else if(primaryButton==true && (currentState==CellState.EMPTY ||currentState==CellState.MARKED)) {
		model.setCellState(rowIdx, colIdx, CellState.FILLED);
		view.setCellState(rowIdx, colIdx, CellState.FILLED);
		view.setRowClueState(rowIdx, model.isRowSolved(rowIdx));
		view.setColClueState(colIdx, model.isColSolved(colIdx));
		view.setPuzzleState(model.isSolved());
	}
	else if(primaryButton==false && (currentState==CellState.EMPTY ||currentState==CellState.FILLED)) {
		model.setCellState(rowIdx, colIdx, CellState.MARKED);
		view.setCellState(rowIdx, colIdx, CellState.MARKED);
		view.setRowClueState(rowIdx, model.isRowSolved(rowIdx));
		view.setColClueState(colIdx, model.isColSolved(colIdx));
		view.setPuzzleState(model.isSolved());
	}
	else if(primaryButton==false && (currentState==CellState.MARKED)) {
		model.setCellState(rowIdx, colIdx, CellState.EMPTY);
		view.setCellState(rowIdx, colIdx, CellState.EMPTY);
		view.setRowClueState(rowIdx, model.isRowSolved(rowIdx));
		view.setColClueState(colIdx, model.isColSolved(colIdx));
		view.setPuzzleState(model.isSolved());
	}
	else if((primaryButton==true || primaryButton==false) && currentState==CellState.FILLED) {
		model.setCellState(rowIdx, colIdx, CellState.EMPTY);
		view.setCellState(rowIdx, colIdx, CellState.EMPTY);
		view.setRowClueState(rowIdx, model.isRowSolved(rowIdx));
		view.setColClueState(colIdx, model.isColSolved(colIdx));
		view.setPuzzleState(model.isSolved());
	}
	if(model.isSolved()==true) {
		int rowNum=model.getNumRows();
		int colNum=model.getNumCols();
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				if(model.getCellState(i, j)==CellState.MARKED) {
				view.setCellState(i, j, CellState.EMPTY);
				}
			}
		}
		view.setPuzzleState(true);
	}
	
	
}
}
