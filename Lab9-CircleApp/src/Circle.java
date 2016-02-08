import java.text.NumberFormat;

public class Circle {
	int radius;

	public Circle(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return "Circle radius = " + radius + 
				"\nCircumference = " + getCircumference1() + 
				"\nArea = "				+ getArea() ;
	}

	public String getCircumference1(){
		return formatNumber(radius*Math.PI*2);
	}

	public String getArea(){
		return formatNumber(radius*radius*Math.PI);
	}
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String formatNumber(double number){
		
		NumberFormat decimal = NumberFormat.getInstance();
		decimal.setMaximumFractionDigits(2);
		String numberAsString = decimal.format(number);
		
		return numberAsString;
	}
}
