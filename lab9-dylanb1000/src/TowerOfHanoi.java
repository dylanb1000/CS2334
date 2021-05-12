import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TowerOfHanoi {
private Map<Peg, Deque<Integer>> diskStacks=new HashMap<Peg, Deque<Integer>>();
public TowerOfHanoi(int numDisks, Peg start) {
	if(numDisks<=0) {
		throw new IllegalArgumentException();
	}
	else if(start==null) {
		throw new NullPointerException();
	}
	else {
		Deque<Integer> disksL=new LinkedList<Integer>();
		Deque<Integer> disksM=new LinkedList<Integer>();
		Deque<Integer> disksR=new LinkedList<Integer>();
		if(start==Peg.LEFT) {
		for(int i=1;i<numDisks+1;i++) {
			disksL.add(i);
		}
		}
		else if(start==Peg.MIDDLE) {
			for(int i=1;i<numDisks+1;i++) {
				disksM.add(i);
			}
		}
		else if(start==Peg.RIGHT) {
			for(int i=1;i<numDisks+1;i++) {
				disksR.add(i);
			}
		}	
		diskStacks.put(Peg.LEFT, disksL);
		diskStacks.put(Peg.MIDDLE, disksM);
		diskStacks.put(Peg.RIGHT, disksR);
	}
}
public Deque<Integer> getDiskStack(Peg peg){
	if(peg==null) {
		throw new NullPointerException();
	}
	Deque<Integer> toReturn= new LinkedList<Integer>();
	Iterator<Integer> l=diskStacks.get(peg).iterator();
	while(l.hasNext()) {
	toReturn.add(l.next());
	}
	return toReturn;
}
public void moveDisk(Move move) {
	boolean action=false;
	if(move==null) {
		throw new NullPointerException();
	}
	else if(diskStacks.get(move.from).isEmpty()) {
		throw new IllegalArgumentException();
	}
	else if(diskStacks.get(move.to).isEmpty()) {
		int removed=diskStacks.get(move.from).poll();
		diskStacks.get(move.to).push(removed);
		action=true;
	}
	else if(diskStacks.get(move.from).peekLast()>diskStacks.get(move.to).peekLast()) {
		throw new IllegalArgumentException();
	}
	else if(action==false){
		int removed=diskStacks.get(move.from).pollLast();
		diskStacks.get(move.to).push(removed);
	}
}
public String toString() {
	String diskString;
	String left="  LEFT: [",middle="MIDDLE: [",right=" RIGHT: [";
	if(diskStacks.get(Peg.LEFT).isEmpty()) {
		left=left+"]";
	}
	else if(!diskStacks.get(Peg.LEFT).isEmpty()){
		Iterator<Integer> l=diskStacks.get(Peg.LEFT).descendingIterator();
		while(l.hasNext()) {
		left=left+l.next()+", ";
	}
	left=left.substring(0,left.length()-2);
	left=left+"]";
	}
	if(diskStacks.get(Peg.MIDDLE).isEmpty()) {
		middle=middle+"]";
	}
	else if(!diskStacks.get(Peg.MIDDLE).isEmpty()){
		Iterator<Integer> l=diskStacks.get(Peg.MIDDLE).descendingIterator();
		while(l.hasNext()) {
		middle=middle+l.next()+", ";
	}
	middle=middle.substring(0,middle.length()-2);
	middle=middle+"]";
	}
	if(diskStacks.get(Peg.RIGHT).isEmpty()) {
		right=right+"]";
	}
	else if(!diskStacks.get(Peg.RIGHT).isEmpty()){
		Iterator<Integer> l=diskStacks.get(Peg.RIGHT).descendingIterator();
		while(l.hasNext()) {
		right=right+l.next()+", ";
	}
	right=right.substring(0,right.length()-2);
	right=right+"]";
	}
	diskString=left+System.lineSeparator()+middle+System.lineSeparator()+right;
	return diskString;
	
}
public static List<Move> solve(int numDisks, Peg start, Peg end){
	if(numDisks<0) {
		throw new IllegalArgumentException();
	}
	else if(start==null||end==null) {
		throw new NullPointerException();
	}
	else if(numDisks==0) {
		List<Move> moves=new ArrayList<Move>();
		return moves;
	}
	else if(start==end) {
		List<Move> moves=new ArrayList<Move>();
		return moves;
	}
	else if(numDisks==1){
		List<Move> moves=new ArrayList<Move>();
		//System.out.println(-1);
		moves.add(0,Move.move(start,end));
		return moves;
	}
	else{
		List<Move> moves=solve(numDisks-1,start,Peg.other(start, end));
		moves.add(Move.move(start, end));
		moves.addAll(solve(numDisks-1,Peg.other(start, end),end));
		return moves;
	}
}
}
