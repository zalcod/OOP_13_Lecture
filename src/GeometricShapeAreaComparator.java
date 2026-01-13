import java.util.Comparator;

public class GeometricShapeAreaComparator implements Comparator<GeometricShape>{

    @Override
    public int compare(GeometricShape o1, GeometricShape o2) {
        return o1.compareTo(o2);
    }
    
}
