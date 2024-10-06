/*
[Note]
[Reference]: Code
[Problem]: NA
[Pattern]: Common code
[Tips]: Any collection can be printed with forEach. ArrayList, List, HashMap
[Revision]: 4
[Confidence]: 50%
[Next]: Practice 
[Steps]: Add elements to Collection, collection.forEach(s->{});
[Code]	
	ListNode newHead = cur.next;

[/Code]
[/Note]
*/

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
    cars.forEach(s -> {if(s == "Volvo"){System.out.println(s);}});
    
  } 
}
