public class Circle extends GeometricShape{
    private double radius;

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
    @Override
    public double calculateArea() {
        return getRadius() * getRadius() * Math.PI;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * getRadius() * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle radius: " + getRadius() + " " + super.toString();
    }
}