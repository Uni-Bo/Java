import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Mazda");
        cars.add("Ford");
        
        System.out.println(cars);

        System.out.println("Size of the ArrayList: " + cars.size());
        System.out.println("Element at index 0: " + cars.get(0));
        
        cars.set(0, "Opel");
        cars.remove(0);
        // cars.clear(); clears the ArrayList

        for (String car : cars) {
            System.out.println(car);
        }

        Collections.sort(cars);  // Sort cars

        Iterator<String> it = cars.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        it = cars.iterator(); // Reset the iterator
        while (it.hasNext()) {
            String car = it.next();
            if (car.equals("Ford")) {
                int index = cars.indexOf(car); // Find the index of "Ford" in the ArrayList
                cars.set(index,"Audi");
                System.out.println(cars);
            }
        }
}

}