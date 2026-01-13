import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        
        /*
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
                
        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.printList(); // Output: 10 -> 20 -> 30 -> null
        
        // Remove an element
        list.remove(20);
        list.printList(); // Output: 10 -> 30 -> null
        
        // Get size
        System.out.println("Size: " + list.size()); // Output: Size: 2
        
        // Get element by index
        System.out.println("Element at index 1: " + list.get(1)); // Output: Element at index 1: 30
        
        // Check if empty
        System.out.println("Is empty: " + list.isEmpty()); // Output: Is empty: false

        // Create a CustomLinkedList of Strings
        CustomLinkedList<String> nameList = new CustomLinkedList<>();

        // Add elements to the list
        nameList.add("Alice");
        nameList.add("Bob");
        nameList.add("Charlie");
        nameList.printList(); // Output: Alice -> Bob -> Charlie -> null

        // Remove an element
        nameList.remove("Bob");
        nameList.printList(); // Output: Alice -> Charlie -> null

        // Add another element
        nameList.add("Diana");
        nameList.printList(); // Output: Alice -> Charlie -> Diana -> null

        // Get an element by index
        System.out.println("First name: " + nameList.get(0)); // Output: First name: Alice

        // Get the size of the list
        System.out.println("Number of names: " + nameList.size()); // Output: Number of names: 3

        // Check if the list is empty
        System.out.println("Is the list empty? " + nameList.isEmpty()); // Output: Is the list empty? false
    
        CustomLinkedList<Integer> numberList = new CustomLinkedList<>();
        
        // Add elements
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);

        for (Integer number : numberList) {
            System.out.println(number);
        }

        Iterator <Integer> linkedListInterator = numberList.iterator();

        while(linkedListInterator.hasNext())
        {
            Integer number = linkedListInterator.next();
            System.out.println(number);
        }
           */


      /*
        Integer[] integers = {10, 20, 40, 100};
        String[] strings = {"Ali", "Mehmet", "Can"};
        
        MyGenericMethodDemo.<Integer>printArray(integers); 
        //MyGenericMethodDemo.printArray(integers);
        System.out.println("null");
        MyGenericMethodDemo.printArray(strings); 
        //MyGenericMethodDemo.<String>printArray(strings);
        */

        /*
        MyGenericMethodDemo m = new MyGenericMethodDemo();
        System.out.println(m.calculateTax(100, .2));

         */

       /* ArrayList <Integer> src = new ArrayList<>();
        src.add(10);
        src.add(20);
        ArrayList <Object> dest = new ArrayList<>();
        // copy to Object array list
        MyGenericMethodDemo.<Integer>copyTo(dest, src);
        MyGenericMethodDemo.printArray(dest.toArray());
        System.out.println(" ");
        
        
        // copy to Number array list
        ArrayList <Number> destNumber = new ArrayList<>();
        MyGenericMethodDemo.<Integer>copyTo(destNumber, src);
        MyGenericMethodDemo.printArray(dest.toArray());
        System.out.println(" ");
        
        // copy to Integer array list
        ArrayList <Integer> destInteger = new ArrayList<>();
        MyGenericMethodDemo.<Integer>copyTo(destInteger, src);
        MyGenericMethodDemo.printArray(dest.toArray());
        System.out.println(" ");

        // however the following is not possible, so it is in comments
       /*
        ArrayList <Double> destDouble = new ArrayList<>();
        MyGenericMethodDemo.<Integer>copyTo(destDouble, src);
        MyGenericMethodDemo.printArray(dest.toArray());
        System.out.println(" ");
        
*/
        ArrayList<GeometricShape> elements = new ArrayList<>();
        elements.add(new Triangle("blue", false, 3, 4, 5));
        elements.add(new Rectangle("blue", false, 3, 5));
        elements.add(new Square("blue", false, 5));
        elements.add(new Circle("Red", false, 2));
        Predicate<GeometricShape> pr = new Predicate<GeometricShape>() {
          @Override
          public boolean test(GeometricShape gS){
             return gS.calculateArea() > 12;
          }
        };
        Predicate <GeometricShape> p = (t) -> t.calculateArea()>20;

        List <GeometricShape> filteredShapes = filterShapes(elements,
            new Predicate<GeometricShape>() {
                @Override
                public boolean test(GeometricShape gS){
                return gS.calculateArea() > 12;
            }
            }
        );
        List <GeometricShape> filteredShapes_ = filterShapes(elements,
            (t) -> t.getColor().equals("Red")
        );

        //Predicate<GeometricShape> a = (t) -> t.calculateArea()>12;
        /*List <GeometricShape> filteredShapes = filterShapes(elements, (t)->t.calculateArea()>12);/*new Predicate<GeometricShape>(){
            @Override
            public boolean test(GeometricShape t){
                return t.calculateArea()>12;
            }   
        });*///new GeometricShape.AreaGreaterThan12Predicate());
        /* 
        for (GeometricShape geometricShape : filteredShapes_) {
            System.out.println(geometricShape);
        }
        System.out.println("___________");
        */

        Function<GeometricShape, String> classificationFunction = (t) -> {
            double area = t.calculateArea();
            return area > 12 ? "Large": "Small";
        };
        List<String> classifiedShapes = 
        applyToShapes(elements, classificationFunction);
        
        for (String geometricShape : classifiedShapes) {
            System.out.println(geometricShape);
        }

       List<GeometricShape> blackShapes = applyToShapes(elements, 
        (GeometricShape gs) -> {
            gs.setColor("Black");
            gs.setFilled(true);
            return gs;
        });

        for (GeometricShape geometricShape : blackShapes) {
            System.out.println(geometricShape);
        }

        /*List <GeometricShape> filteredShapes = filterShapes(elements, new GeometricShape.AreaGreaterThan12Predicate());
        for (GeometricShape geometricShape : filteredShapes) {
            System.out.println(geometricShape);
        }*/


        /*
        // I am defining an unnamed, anonymous class
        // by providing an implementation to the Predicate class.
        // See how I implement the interface
        Predicate<GeometricShape> areaGreaterThan12 = new Predicate<GeometricShape>(){
            @Override
            public boolean test(GeometricShape shape) {
                return shape.calculateArea() > 12;
            }
        }; // notice the semi-colon

        List <GeometricShape> filteredShapes = filterShapes(elements, areaGreaterThan12);
        for (GeometricShape geometricShape : filteredShapes) {
            System.out.println(geometricShape);
        }*/


        /*
        List <GeometricShape> filteredShapes = filterShapes(elements, new Predicate<GeometricShape>() {
            @Override
            public boolean test(GeometricShape shape) {
                return shape.calculateArea() > 12;
            }
        });
        for (GeometricShape geometricShape : filteredShapes) {
            System.out.println(geometricShape);
        }
        */

        /*

        Predicate<GeometricShape> areaGreaterThan12 = (GeometricShape gS) -> gS.calculateArea()>12;
        List <GeometricShape> filteredShapes = filterShapes(elements, areaGreaterThan12);
        for (GeometricShape geometricShape : filteredShapes) {
            System.out.println(geometricShape);
        }
        */


       /*
        Predicate<GeometricShape> areaGreaterThan12 = (gS) -> gS.calculateArea()>12;
        List <GeometricShape> filteredShapes = filterShapes(elements, areaGreaterThan12);
        for (GeometricShape geometricShape : filteredShapes) {
            System.out.println(geometricShape);
        }
        */

        /*

        List <GeometricShape> filteredShapes = filterShapes(elements, (gS) -> gS.calculateArea()>12);
        for (GeometricShape geometricShape : filteredShapes) {
            System.out.println(geometricShape);

        }*/

        
        

      /*
        System.out.println("sort by implementing Comparable");
        Collections.sort(elements);
        for (GeometricShape geometricShape : elements) {
            System.out.println(geometricShape);
        }

        System.out.println("sort with a comparator to compare by area");
        Collections.sort(elements, new GeometricShapeAreaComparator());
        for (GeometricShape geometricShape : elements) {
            System.out.println(geometricShape);
        }

        System.out.println("sort with a comparator to compare by perimeter");
        Collections.sort(elements, new GeometricShapePerimeterComparator());
        for (GeometricShape geometricShape : elements) {
            System.out.println(geometricShape);
        }
*/


    /*
    Utility.Validator.isValidEmail("ali@gmail.com");
        Utility.Validator.isValidPhoneNumber("1111111");

        Utility.Validator uVal = new Utility.Validator();
        uVal.isValidEmail("ali@gmail.com");
    }

     */
    }


    // this method may appear anywhere in your code
    public static List<GeometricShape> filterShapes(List<GeometricShape> shapes, 
    Predicate<GeometricShape> condition) {
        List<GeometricShape> result = new ArrayList<>();
        for (GeometricShape shape : shapes) {
            if (condition.test(shape)) {
                result.add(shape);
            }
        }
        return result;
    }

    // A method that applies a transformation to each GeometricShape
    public static <T extends GeometricShape, R> List<R> applyToShapes(List<T> shapes, 
    Function<T, R> function) {
        List<R> results = new ArrayList<>();
        for (T shape : shapes) {
            R result = function.apply(shape); // Apply the transformation and capture the result
            results.add(result); // Store the result
        }
        return results; // Return the list of results
    }



    
}

