
import java.util.*;
import java.util.stream.IntStream;
public class Main {
  public static void main(String[] args) {
    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    System.out.println(cars.length);
    
    //Arrays.stream(cars).forEach(s -> System.out.println(s));
    
    IntStream.range(0, cars.length)
            .mapToObj(index -> String.format("%d -> %s",index, cars[index]))
            .forEach(System.out::println); 
  }
}
