import java.util.ArrayList;
import java.util.Random;

public class RandomPlayer extends Player{
private Random generator=new Random();
public RandomPlayer(String name) {
	super(name);
}
@Override
public int[] getMove(int[] pileSizes) {
	ArrayList<Integer> indexes=new ArrayList<Integer>();
	for(int i=0;i<pileSizes.length;i++) {
		if(pileSizes[i]!=0) {
		indexes.add(i);
		}
	}
	int ranIndex=indexes.get(generator.nextInt(indexes.size()));
	int ranObject=generator.nextInt(pileSizes[ranIndex])+1;
	return new int[] {ranIndex,ranObject};
}
}
