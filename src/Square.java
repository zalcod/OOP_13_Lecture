public class Square extends Rectangle{
    public Square(String color, boolean filled, double sideLength) {
        // Call Rectangle constructor with side length as both width and height
        super(color, filled, sideLength, sideLength);
    } 

    public double getSideLength() {
        return getWidth(); // or getHeight(), as they should be equal
    } 

    public void setSideLength(double sideLength) {
        setWidth(sideLength);
        setHeight(sideLength); // Ensure both width and height remain equal
    } 
    
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width); // Ensure height matches width for a square
    } 
    
    @Override
    public void setHeight(double height) {
        super.setWidth(height);
        super.setHeight(height); // Ensure width matches height for a square
    } 
    
    @Override
    public String toString() {
        return "Square sideLength = " + getSideLength() + " " + "Color: " + getColor() + " isFilled: " + isFilled(); 
    }
}
