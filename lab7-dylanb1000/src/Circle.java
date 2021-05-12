
public class Circle extends Shape{
private double radius;
public Circle(double radius) {
	if(radius<=0) {
		throw new IllegalArgumentException("Nonpositive radius: "+radius);
	}
	else {
		this.radius=radius;
	}
}
public double getRadius() {
	return this.radius;
}
public double getPerimeter() {
	return 2*Math.PI*this.radius;
}
public double getArea() {
	return Math.PI*Math.pow(radius, 2);
}
}
