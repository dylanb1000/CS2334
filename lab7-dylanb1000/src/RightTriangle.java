
public class RightTriangle extends Triangle{
	public RightTriangle(double base, double height) {
		super(base,height,Math.sqrt(Math.pow(base, 2)+Math.pow(height,2)));
	}
public double getBase() {
	return super.getSideA();
}
public double getHeight() {
	return super.getSideB();
}
public double getHypotenuse() {
	return super.getSideC();
}
}
