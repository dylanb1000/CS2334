
public class Triangle {
	private double sideA;
	private double sideB;
	private double sideC;
	public final static double DEFAULT_SIDE=1;
	public Triangle() {
		sideA=DEFAULT_SIDE;
		sideB=DEFAULT_SIDE;
		sideC=DEFAULT_SIDE;
	}
	public Triangle(double sideA,double sideB,double sideC) {
		if(sideA<0 || sideB<0 || sideC<0||isTriangle(sideA,sideB,sideC)==false) {
			this.sideA=DEFAULT_SIDE;
			this.sideB=DEFAULT_SIDE;
			this.sideC=DEFAULT_SIDE;
		}
		else {
		this.sideA=sideA;
		this.sideB=sideB;
		this.sideC=sideC;
		}
				
	}
	public Triangle(double[] sides) {
		
		
		if(sides==null) {
			this.sideA=DEFAULT_SIDE;
			this.sideB=DEFAULT_SIDE;
			this.sideC=DEFAULT_SIDE;
		}
		else if(sides.length!=3) {
			this.sideA=DEFAULT_SIDE;
			this.sideB=DEFAULT_SIDE;
			this.sideC=DEFAULT_SIDE;
		}
		else if(sides[0]<0 || sides[1]<0 || sides[2]<0  || isTriangle(sides)==false) {
			this.sideA=DEFAULT_SIDE;
			this.sideB=DEFAULT_SIDE;
			this.sideC=DEFAULT_SIDE;
		}
		else {
		this.sideA=sides[0];
		this.sideB=sides[1];
		this.sideC=sides[2];
		}
	}
	public Triangle(Triangle triangle) {
		if(triangle==null) {
			this.sideA=DEFAULT_SIDE;
			this.sideB=DEFAULT_SIDE;
			this.sideC=DEFAULT_SIDE;
		}
		else {
		this.sideA=triangle.sideA;
		this.sideB=triangle.sideB;
		this.sideC=triangle.sideC;
		}
		
	}
	public double getSideA() {
		return sideA;
	}
	public double getSideB() {
		return sideB;
	}
	public double getSideC() {
		return sideC;
	}
	public double[] getSides() {
		double[] sides= {sideA,sideB,sideC};
		return sides;
	}
	public double getAngleA() {
		double angleA=Math.acos((sideB*sideB + sideC*sideC - sideA*sideA)/(2.0*sideB*sideC))*57.2958;
		return angleA;
	}
	public double getAngleB() {
		double angleB=Math.acos((sideC*sideC + sideA*sideA - sideB*sideB)/(2.0*sideC*sideA))*57.2958;
		return angleB;
	}
	public double getAngleC() {
		double angleC = Math.acos((sideA*sideA + sideB*sideB - sideC*sideC)/(2.0*sideA*sideB))*57.2958;
		return angleC;
	}
	public double[] getAngles() {
		double angleA=Math.acos((sideB*sideB + sideC*sideC - sideA*sideA)/(2.0*sideB*sideC))*57.2958;
		double angleB=Math.acos((sideC*sideC + sideA*sideA - sideB*sideB)/(2.0*sideC*sideA))*57.2958;
		double angleC = Math.acos((sideA*sideA + sideB*sideB - sideC*sideC)/(2.0*sideA*sideB))*57.2958;
		double[] angles= {angleA,angleB,angleC};
		return angles;
	}
	public boolean setSideA(double sideA) {
		if(sideA<1) {
		return false;
		}
		else if(isTriangle(sideA,this.sideB,this.sideC)==false) {
			return false;
		}
		else {
		this.sideA=sideA;
		return true;
		}
	}
	public boolean setSideB(double sideB) {
		if(sideB<1) {
			return false;
			}
		else if(isTriangle(this.sideA,sideB,this.sideC)==false) {
			return false;
		}
			else {
			this.sideB=sideB;
			return true;
			}
	}
	public boolean setSideC(double sideC) {
		if(sideC<1) {
			return false;
			}
		else if(isTriangle(this.sideA,this.sideB,sideC)==false) {
			return false;
		}
			else {
			this.sideC=sideC;
			return true;
			}
	}
	public boolean setSides(double[] sides) {
		if(sides==null) {
			return false;
		}
		else if(sides.length!=3) {
			return false;
		}
		else if(sides[0]<1 || sides[1]<1 || sides[2]<1  || isTriangle(sides)==false) {
			return false;
		}
		else {
		sideA=sides[0];
		sideB=sides[1];
		sideC=sides[2];
		return true;
		}
	}
	public String toString() {
	String string=String.format("Triangle(%.3f, %.3f, %.3f)",sideA,sideB,sideC);
	return string;
	}
	public static boolean isTriangle(double sideA, double sideB, double sideC) {
		if(sideA+sideB>sideC && sideB+sideC>sideA && sideC+sideA>sideB){
			return true;
			
		}
		else {
			return false;
		}
	}
	public static boolean isTriangle(double[] sides){
		if(sides==null) {
			return false;
		}
		else if(sides.length!=3) {
			return false;
		}
		else if(sides[0]+sides[1]>sides[2] && sides[1]+sides[2]>sides[0] && sides[2]+sides[0]>sides[1]){
			return true;
			
		}
		else {
			return false;
		}
	}
	public static double lawOfCosines(double sideA,double sideB,double sideC) {
		double angleC = Math.acos((sideA*sideA + sideB*sideB - sideC*sideC)/(2.0*sideA*sideB))*57.2958;
		return angleC;
	}
}
