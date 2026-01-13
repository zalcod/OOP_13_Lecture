public class Rectangle extends GeometricShape{
    private double width, height;

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            System.out.println("Height must be positive.");
        }else{
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            System.out.println("Height must be positive.");
        }else{
            this.height = height;
        }
    }

    @Override
    public double calculateArea() {
        return getWidth() * getHeight();
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (getHeight() + getWidth());
    }

    @Override 
    public String toString() {
        return "Rectangle height: " + getHeight() + " width: " + getWidth() + " " + super.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Rectangle == false)  // if (!(obj instanceof Rectangle)) 
            return false;
        Rectangle incomingRectangleObj = (Rectangle)obj;
        if( this.getHeight() == incomingRectangleObj.getHeight() && 
            this.getWidth() == incomingRectangleObj .getWidth() )
            return true;
        return false;
    }
}
