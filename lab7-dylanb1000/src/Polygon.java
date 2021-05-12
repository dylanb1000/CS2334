
public abstract class Polygon extends Shape{
private double perimeter;
protected Polygon(double... sides) {
	if(sides==null) {
		throw new IllegalArgumentException("null sides");
	}
	else if(sides.length<3) {
		throw new IllegalArgumentException("Invalid number of sides: "+sides.length);
	}
	for(int i=0;i<sides.length;i++) {
		if(sides[i]<=0) {
			throw new IllegalArgumentException("Nonpositive side: "+sides[i]);
		}
	}
	double totalSum=0;
	double otherSides;
	for(int i=0;i<sides.length;i++) {
		totalSum+=sides[i];
	}
	for(int i=0;i<sides.length;i++) {
		otherSides=totalSum-sides[i];
		if(sides[i]>=otherSides) {
			throw new IllegalArgumentException("Polygon inequality violated: "+sides[i]+" >= "+otherSides);
		}
	}
	this.perimeter=totalSum;
	
}
public double getPerimeter() {
	return this.perimeter;
}
}
