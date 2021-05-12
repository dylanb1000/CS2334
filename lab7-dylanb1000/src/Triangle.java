
public class Triangle extends Polygon{
	private double sideA;
	private double sideB;
	private double sideC;
	private double area;
	public Triangle(double sideA,double sideB,double sideC){
		super(sideA,sideB,sideC);
		this.sideA=sideA;
		this.sideB=sideB;
		this.sideC=sideC;
		double s=(sideA+sideB+sideC)/2;
		double inside=s*(s-sideA)*(s-sideB)*(s-sideC);
		this.area=Math.sqrt(inside);
	}
	public double getSideA() {
		return this.sideA;
	}
	public double getSideB() {
		return this.sideB;
	}
	public double getSideC() {
		return this.sideC;
	}
	public double getArea() {
		return this.area;
	}

}
