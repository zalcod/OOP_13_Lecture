import java.util.Comparator;

public class GeometricShapePerimeterComparator implements Comparator<GeometricShape>{

    @Override
    public int compare(GeometricShape o1, GeometricShape o2) {
        return (int)(o1.calculatePerimeter() - o2.calculatePerimeter());
    }
    
}
