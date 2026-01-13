import java.util.function.Predicate;

public abstract class GeometricShape extends Object
 implements Comparable<GeometricShape>{
    private String color;
    private boolean filled;
    
    public GeometricShape(String color, boolean filled){
        super();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    @Override
    public String toString(){
        return "Color: " + getColor() + " isFilled: " + isFilled(); 
    }

    @Override
    public int compareTo(GeometricShape o) {
        double diff = this.calculateArea() - o.calculateArea();
        if (diff > 0)
            return 1;
        else if (diff < 0)    
            return -1;
        return 0;
    }
    public static class AreaGreaterThan12Predicate 
    implements Predicate<GeometricShape> {
        @Override
        public boolean test(GeometricShape t) {
            return t.calculateArea() > 12;
        }
    }
    
}
