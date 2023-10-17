import java.util.*;

public class Main { 
  public static void main(String[] args) { 
    List<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
    cars.forEach(System.out::println);
    
  } 
}
