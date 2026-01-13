public class Triangle extends GeometricShape{
    private double side1, side2, side3;

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        if (side1 <= 0) {
            System.out.println("Side 1 must be positive.");
        }else {
            this.side1 = side1;
        }
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        if (side2 <= 0) {
            System.out.println("Side 2 must be positive.");
        }else {
            this.side2 = side2;
        }
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        if (side3<= 0) {
            System.out.println("Side 3 must be positive.");
        }else {
            this.side3 = side3;
        }
    }

    @Override
    public double calculateArea() {
        double s = (getSide1() + getSide2() + getSide3()) / 2;
        // Heron's formula
        return Math.sqrt(s * (s - getSide1()) * (s - getSide2()) * (s - getSide3()));
    }

    @Override
    public double calculatePerimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    public boolean checTrEq(){
        return true;
    }

    @Override
    public String toString() {
        return "Triangle side1 = " + getSide1() + " side2 = " + getSide2() + " side3 = " + getSide3() + " " + super.toString();
    }
}
