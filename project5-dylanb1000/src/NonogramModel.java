import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class NonogramModel implements Model{
private int [][] rowClues;
private int[][] colClues;
private CellState[][] cellStates;
public NonogramModel(int[][] rowClues,int[][] colClues) {
	this.rowClues = new int[rowClues.length][];
	this.colClues=new int[colClues.length][];
	for(int i=0;i<rowClues.length;i++) {
		this.rowClues[i]=new int[rowClues[i].length];
		for (int j=0;j<rowClues[i].length;j++){
			this.rowClues[i][j]=rowClues[i][j];
		}
	}
	for(int i=0;i<colClues.length;i++) {
		this.colClues[i]=new int[colClues[i].length];
		for (int j=0;j<colClues[i].length;j++){
			this.colClues[i][j]=colClues[i][j];
		}
	}
	cellStates=new CellState[this.rowClues.length][this.colClues.length];
	for(int i=0;i<cellStates.length;i++) {
		for(int j=0;j<cellStates[i].length;j++) {
			cellStates[i][j]=CellState.EMPTY;
		}
	}
	
}
public NonogramModel(String filename) throws IOException {
	String file="./puzzles/";
	BufferedReader br=new BufferedReader(new FileReader(file+filename));
	   String[] rowsCols=br.readLine().split(" ");
	   rowClues=new int[Integer.parseInt(rowsCols[0])][];
	   colClues=new int[Integer.parseInt(rowsCols[1])][];
	   int rows=Integer.parseInt(rowsCols[0]);
	   int cols=Integer.parseInt(rowsCols[1]);
	   int rowCount=0;
	   int colCount=0;
	   while(rowCount!=rows) {
		   String[] temp=br.readLine().split(" ");
		   rowClues[rowCount]=new int[temp.length];
		   for(int i=0;i<temp.length;i++) {
			   rowClues[rowCount][i]=Integer.parseInt(temp[i]);
		   }
		   rowCount+=1;
		   
		}
	   while(colCount!=cols) {
		   String[] temp=br.readLine().split(" ");
		   colClues[colCount]=new int[temp.length];
		   for(int i=0;i<temp.length;i++) {
			   colClues[colCount][i]=Integer.parseInt(temp[i]);
		   }
		   colCount+=1;
		}
	   cellStates=new CellState[rowCount][colCount];
		for(int i=0;i<cellStates.length;i++) {
			for(int j=0;j<cellStates[i].length;j++) {
				cellStates[i][j]=CellState.EMPTY;
			}
		}
}
@Override
public CellState getCellState(int rowIdx, int colIdx) {
	return cellStates[rowIdx][colIdx];
}
@Override
public boolean setCellState(int rowIdx, int colIdx, CellState state) {
	if(state==null) {
		return false;
	}
	else if(isSolved()==true) {
		return false;
	}
	else if(getCellState(rowIdx,colIdx)==state) {
		return false;
	}
	else {
		cellStates[rowIdx][colIdx]=state;
		return true;
	}
}
@Override
public int getNumRows() {
	return rowClues.length;
}
@Override
public int getNumCols() {
	return colClues.length;
}
@Override
public int[] getRowClue(int rowIdx) {
	int[] copy=new int[rowClues[rowIdx].length];
	for(int i=0;i<rowClues[rowIdx].length;i++) {
		copy[i]=rowClues[rowIdx][i];
	}
	return copy;
}
@Override
public int[] getColClue(int colIdx) {
	int[] copy=new int[colClues[colIdx].length];
	for(int i=0;i<colClues[colIdx].length;i++) {
		copy[i]=colClues[colIdx][i];
	}
	return copy;
}
@Override
//finish solving
public boolean isRowSolved(int rowIdx) {
		CellState[] states=cellStates[rowIdx];

			int[] check=rowClues[rowIdx];
			if((states[0]==CellState.EMPTY||states[0]==CellState.MARKED) && check[0]==0) {
				return true;
			}
		   int[] toCheck=new int[check.length];
		   int count=0;
		   int Idx=0;
		   boolean counting=false;
		   boolean addLast=false;
		   for(int i=0;i<states.length;i++) {
			   try {
			   if(states[i]==CellState.FILLED) {
				   count+=1;
				   counting=true;
			   }
			   else if((states[i]==CellState.EMPTY||states[i]==CellState.MARKED) && counting==true) {
				   toCheck[Idx]=count;
				   Idx+=1;
				   count=0;
				   counting=false;
			   }
			   
			   }
			   catch(ArrayIndexOutOfBoundsException e){
				   return false;
			   }
		   }
		   if(states[states.length-1]==CellState.FILLED) {
			   addLast=true;
		   }
		   try {
		   if(addLast==true) {
			   toCheck[Idx]=count;
		   }}
		   catch(ArrayIndexOutOfBoundsException e){
			   return false;
		   }
		   if(Arrays.equals(toCheck, check)) {
			   return true;
		   }
		   else {
			   return false;
		   }
}
@Override
public boolean isColSolved(int colIdx) {
	CellState[] states=new CellState[getNumRows()];
	for(int i=0;i<states.length;i++) {
		states[i]=cellStates[i][colIdx];
	}
	   int[] check=colClues[colIdx];
	   if((states[0]==CellState.EMPTY||states[0]==CellState.MARKED) && check[0]==0) {
			return true;
		}
	   int[] toCheck=new int[check.length];
	   int count=0;
	   int Idx=0;
	   boolean counting=false;
	   boolean addLast=false;
	   for(int i=0;i<states.length;i++) {
		   try {
		   if(states[i]==CellState.FILLED) {
			   count+=1;
			   counting=true;
		   }
		   else if((states[i]==CellState.EMPTY||states[i]==CellState.MARKED) && counting==true) {
			   toCheck[Idx]=count;
			   Idx+=1;
			   count=0;
			   counting=false;
		   }
		   }
		   catch(ArrayIndexOutOfBoundsException e){
			   return false;
		   }
	   }
	   if(states[states.length-1]==CellState.FILLED) {
		   addLast=true;
	   }
	   try {
	   if(addLast==true) {
		   toCheck[Idx]=count;
	   }}
	   catch(ArrayIndexOutOfBoundsException e){
		   return false;
	   }
	   if(Arrays.equals(toCheck, check)) {
		   return true;
	   }
	   else {
		   return false;
	   }
}
@Override
public boolean isSolved() {
	int rowLength=getNumRows();
	int colLength=getNumCols();
	int rowTemp=0;
	int colTemp=0;
	for(int i=0;i<rowLength;i++) {
		if(isRowSolved(i)==true) {
			rowTemp+=1;
		}
	}
	if(rowTemp!=rowLength) {
		return false;
	}
	for(int i=0;i<colLength;i++) {
		if(isColSolved(i)==true) {
			colTemp+=1;
		}
	}
	if(colTemp!=colLength) {
		return false;
	}
	else {
		return true;
	}
}
}
