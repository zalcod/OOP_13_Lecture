import java.util.function.Predicate;

public class AreaGreaterThan12Predicate implements Predicate<GeometricShape> {
    @Override
    public boolean test(GeometricShape t) {
        return t.calculateArea() > 12;
    }
}