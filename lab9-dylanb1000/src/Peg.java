
public enum Peg {
LEFT,MIDDLE,RIGHT;
public static Peg other(Peg p1,Peg p2) {
	if(p1==p2) {
		throw new IllegalArgumentException();
	}
	else if(p1==null || p2==null) {
		throw new NullPointerException();
	}
	else {
		if((p1==Peg.LEFT && p2==Peg.RIGHT) || (p1==Peg.RIGHT && p2==Peg.LEFT)) {
			return Peg.MIDDLE;
		}
		else if((p1==Peg.MIDDLE && p2==Peg.RIGHT) || (p1==Peg.RIGHT && p2==Peg.MIDDLE)){
			return Peg.LEFT;
		}
		else {
			return Peg.RIGHT;
		}
	}
}
}
