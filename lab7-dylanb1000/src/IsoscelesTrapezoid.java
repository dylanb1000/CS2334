
public class IsoscelesTrapezoid extends Polygon{
	private double initBase;
	private double initTop;
	private double top;
	private double base;
	private double leg;
	private double area;
	public IsoscelesTrapezoid(double top,double base,double leg){
		super(top,base,leg,leg);
		this.initBase=base;
		this.initTop=top;
		if(top>base) {
			this.base=top;
			this.top=base;
		}
		else {
			this.top=top;
			this.base=base;
		}
		
		this.leg=leg;
		double height=Math.sqrt(Math.pow(leg, 2)-Math.pow((0.5)*(base-top), 2));
		this.area=0.5*(top+base)*height;
	}
	public double getTop() {
		return this.initTop;
	}
	public double getBase() {
		return this.initBase;
	}
	public double getLeg() {
		return this.leg;
	}
	public double getArea() {
		return this.area;
	}
	public Rectangle getCenterRectangle() {
		return new Rectangle(this.top,Math.sqrt(Math.pow(leg, 2)-Math.pow((0.5)*(base-top), 2)));
	}
	public RightTriangle getSideTriangle() {
		return new RightTriangle((0.5)*(this.base-this.top),Math.sqrt(Math.pow(this.leg, 2)-Math.pow(0.5*(this.base-this.top), 2)));
	}
}
