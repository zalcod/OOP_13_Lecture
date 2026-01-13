import java.util.function.Predicate;

public class BlueCOlor implements Predicate<GeometricShape>{

    @Override
    public boolean test(GeometricShape t) {
       return t.getColor().equals("Blue");
    }
    
}
