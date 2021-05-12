
public abstract class Shape implements Comparable<Shape> {
	private int id;
	private static int nextID=0;
	public Shape() {
		this.id=nextID;
		nextID++;
	}
	public int getID() {
		return this.id;
	}
	public abstract double getPerimeter();
	public abstract double getArea();
	public int compareTo(Shape other){
		if(this.getClass().getName().compareTo(other.getClass().getName())<0){
			return -1;
		}
		else if(this.getClass().getName().compareTo(other.getClass().getName())>0){
			return 1;
		}
		else if(this.getPerimeter()>other.getPerimeter()) {
			return 1;
		}
		else if(this.getPerimeter()<other.getPerimeter()) {
			return -1;
		}
		else if(this.getArea()>other.getArea()) {
			return 1;
		}
		else if(this.getArea()<other.getArea()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "<"
				+ getClass().getName()
				+ ", ID: " + id
				+ ", PERIMETER: " + String.format("%.1f", getPerimeter())
				+ ", AREA: " + String.format("%.1f", getArea())
				+ ">";
	}
}
